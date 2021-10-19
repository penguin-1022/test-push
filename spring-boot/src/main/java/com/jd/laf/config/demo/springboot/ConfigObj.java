package com.jd.laf.config.demo.springboot;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.springboot.bo.DateBean;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by bjliuyong on 2019/2/1.
 */
@Component
public class ConfigObj {

    @Value("${conf.c1:1}")
    private int c1 ;
    @Value("${conf.c2:xxxx}")
    private String c2 ;

    @Value("${conf.c3:0.33333}")
    private double c3 ;

    @Value("${conf.on:true}")
    private boolean safetySwitch ;

    @LafValue("datebean")
    @JsonConverter
    private DateBean dateBean;

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

    public boolean isSafetySwitch() {
        return safetySwitch;
    }

    public void setSafetySwitch(boolean safetySwitch) {
        this.safetySwitch = safetySwitch;
    }

    public DateBean getDateBean() {
        return dateBean;
    }

    public void setDateBean(DateBean dateBean) {
        this.dateBean = dateBean;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("ConfigObj{");
        sb.append("c1=").append(c1);
        sb.append(", c2='").append(c2).append('\'');
        sb.append(", c3=").append(c3);
        sb.append(", safetySwitch=").append(safetySwitch);
        sb.append(", dateBean=").append(dateBean);
        sb.append('}');
        return sb.toString();
    }
}
