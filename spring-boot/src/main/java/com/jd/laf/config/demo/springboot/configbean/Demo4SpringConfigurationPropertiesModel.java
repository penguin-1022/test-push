package com.jd.laf.config.demo.springboot.configbean;

/**
 * 在 spring boot 环境下，ducc 结合 {@link org.springframework.boot.context.properties.ConfigurationProperties} 的示例.
 *
 * 这个 {@link Demo4SpringConfigurationPropertiesModel} 类的 Bean 对象创建，在 {@link com.jd.laf.config.demo.springboot.configbean}
 *
 * @see {@link org.springframework.boot.context.properties.ConfigurationProperties}
 *
 * Created by bjliuyong on 2018/11/26.
 */
public class Demo4SpringConfigurationPropertiesModel {

    private int c1 ;
    private String c2 ;
    private double c3 ;
    private boolean on ;

    @Override
    public String toString() {
        return "Demo4SpringConfigurationPropertiesModel{" +
                "c1=" + c1 +
                ", c2='" + c2 + '\'' +
                ", c3=" + c3 +
                ", on=" + on +
                '}';
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public double getC3() {
        return c3;
    }

    public void setC3(double c3) {
        this.c3 = c3;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
