package com.jsf.ducc.springmvc.demo.controller;

import com.jsf.ducc.springmvc.demo.beans.DuccBean;
import com.jsf.ducc.springmvc.demo.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        LOGGER.info("DUCC Bean 监听动态配置； {}", duccBean);
        LOGGER.info("普通 spring bean； {}", user);
        return "index";
    }

}
