package com.jd.laf.config.demo.common.listener;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.Property;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class ConfigListener implements InitializingBean {
    private static Logger LOGGER = LoggerFactory.getLogger(ConfigListener.class);

    /**
     * 指定key 即可 , key 维度监听器
     *
     * 注意：不能使用如下用法
     * <p>
     *     "@LafValue("${ducc_key1}")"
     * </p>
     * <p>
     *     "@LafValue("${ducc_key1:value}")"
     * </p>
     *
     * @param property
     */
    @LafValue("ducc_key1")
    public void onChange(Property property) {
        System.out.println(property);
    }

    /**
     * resource (即 profile)维度监听器<br/>
     * name 对应的是 src/main/resources/spring-ducc.xml 中的 resource name <br/>
     *
     * @param configuration
     */
    @LafValue(name = "ucc_test")
    public void onConfigurationChange(Configuration configuration){
       LOGGER.info("使用 @LafValue name 监听 resource (即 profile )维度配置", configuration);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ConfigListener.afterPropertiesSet");
    }
}
