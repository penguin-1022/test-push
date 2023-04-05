package com.jd.laf.config.demo.springboot.configbean;

import com.jd.laf.config.demo.common.beans.Address;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2023/4/3
 * @since todo
 */
public class UserInfo {

    public UserInfo() {
        System.out.println();
    }

    private String name;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
