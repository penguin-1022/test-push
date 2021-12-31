package com.jd.laf.config.demo.springboot.configbean;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.springboot.bo.DateBean;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 在 spring boot 下，普通 spring bean 场景
 * Created by bjliuyong on 2019/2/1.
 */
@Component
public class Demo4ComponentBean {

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

    @LafValue("datebean.list")
    @JsonConverter
    private List<DateBean> dateBeanList;

    @LafValue("number.list")
    private List<Integer> numbers;

    @Value("${password:qwerasdf}")
    private String password;

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

    public List<DateBean> getDateBeanList() {
        return dateBeanList;
    }

    public void setDateBeanList(List<DateBean> dateBeanList) {
        this.dateBeanList = dateBeanList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Demo4ComponentBean{" +
                "c1=" + c1 +
                ", c2='" + c2 + '\'' +
                ", c3=" + c3 +
                ", safetySwitch=" + safetySwitch +
                ", dateBean=" + dateBean +
                ", dateBeanList=" + dateBeanList +
                ", numbers=" + numbers +
                ", password='" + password + '\'' +
                '}';
    }
}
