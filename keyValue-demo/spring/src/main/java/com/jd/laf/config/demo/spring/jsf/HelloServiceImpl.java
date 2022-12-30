/**
 * 
 */
package com.jd.laf.config.demo.spring.jsf;

import com.jd.jsf.gd.server.AsyncContext;
import com.jd.jsf.gd.transport.Callback;
import com.jd.jsf.gd.util.RpcContext;
import com.jd.laf.config.spring.annotation.LafUcc;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Random;

public class HelloServiceImpl implements HelloService, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Value("${ducc_key1}")
    private String duccConfig1;
    @LafUcc
    @Value("${ducc_key2}")
    private String duccConfig2;
    @LafValue("ducc_key3")
    private String duccConfig3;
    private String duccConfig4;

    @Override
    public String echoStr(String str) {
        return str + " server";
    }

    public void init() {
        System.out.println("HelloServiceImpl.init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("HelloServiceImpl.afterPropertiesSet");
    }
}
