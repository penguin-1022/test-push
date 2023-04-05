package com.jd.laf.config.demo.common.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/6/25
 * @since todo
 */
@ConfigurationProperties(prefix = "config")
public class DuccPrefixBean {
    private String key1 ;
    private String key2 ;

    private Address address;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    @Override
    public String toString() {
        return "DuccPrefixBean{" +
                "key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public void finalize() {
        System.out.println("执行析构函数: " + toString());
    }
}
