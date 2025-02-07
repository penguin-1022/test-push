package com.jd.laf.config.demo.common.bo;

import org.springframework.beans.factory.InitializingBean;

/**
 * Title: 普通 spring bean. <br>
 * <p/>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/5/25
 * @since todo
 */
public class User implements InitializingBean {
    private String name;
    private int age;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    public void init() {
        System.out.println("User.init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("User.afterPropertiesSet");
    }
}
