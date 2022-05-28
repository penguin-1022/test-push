package com.jd.laf.config.demo.spring.listener;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.Property;
import com.jd.laf.config.spring.annotation.LafValue;

import java.util.Date;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class ConfigListener {

    /**
     * 指定key 即可 , key 维度监听器
     * @param property
     */
    @LafValue("ducc_key1")
    public void onChange(Property property) {
        System.out.println(property);
    }

    /**
     * 指定resource.name ， resource维度监听器
     * @param configuration
     */
    @LafValue(name = "ucc_test")
    public void onConfigurationChange(Configuration configuration){
       // System.out.println(configuration);
    }

    @LafValue("AreaConfigCache")
    public void on(Property property){
        System.out.println(new Date().toString() + " -----"+ property);
    }
}
