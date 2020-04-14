package com.jd.laf.config.demo.spring;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class Config {

    @Value("${k1}")
    private String k1 ;

    @Value("${k2}")
    private int k2 ;

    @Value("${k3}")
    private double k3 ;

    @LafValue("ucc_test")
    private Configuration configuration;

    @Override
    public String toString() {
        return "Config{" +
                "k1='" + k1 + '\'' +
                ", k2=" + k2 +
                ", k3=" + k3 +
                '}';
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public double getK3() {
        return k3;
    }

    public void setK3(double k3) {
        this.k3 = k3;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
