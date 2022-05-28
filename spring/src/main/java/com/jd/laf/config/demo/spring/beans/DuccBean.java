package com.jd.laf.config.demo.spring.beans;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.annotation.Value;

/**
 * Title: ducc spring bean. <br>
 * <p/>
 * Description: ducc spring bean 会监听 ducc 服务端动态配置.
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/5/28
 * @since todo
 */
public class DuccBean {

    @Value("${local_key1}")
    private String localConfig;

    @Value("${ducc_key1}")
    private String duccConfig1;

    @LafValue("ducc_key2")
    private String duccConfig;

    /**
     * name 对应的是 src/main/resources/spring-ducc.xml 中的 resource name
     */
    @LafValue(name = "ucc_test")
    private Configuration configuration;

    @Override
    public String toString() {
        return "DuccBean{" +
                "localConfig='" + localConfig + '\'' +
                ", duccConfig1='" + duccConfig1 + '\'' +
                ", duccConfig='" + duccConfig + '\'' +
                '}';
    }
}
