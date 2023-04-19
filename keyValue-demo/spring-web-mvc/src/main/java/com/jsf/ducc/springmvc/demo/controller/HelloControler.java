package com.jsf.ducc.springmvc.demo.controller;

import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.bo.User;
import com.jd.laf.config.spring.annotation.LafUcc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/5/28
 * @since todo
 */
@Controller
public class HelloControler {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloControler.class);

    @Autowired
    private DuccBean duccBean;
    @Autowired
    private User user;

    @LafUcc
    @Value("${ducc_key2}")
    private String duccConfig2;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        LOGGER.info("DUCC Bean 监听动态配置； {}", duccBean);
        LOGGER.debug("普通 spring bean； {}", user);
        LOGGER.info("普通 spring bean； {}", user);
        LOGGER.warn("普通 spring bean； {}", user);
        LOGGER.error("普通 spring bean； {}", user);
        System.out.println("\n\n");
        return "index";
    }

}
