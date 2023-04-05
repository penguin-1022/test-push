package com.jd.laf.config.demo.common.beans;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2023/4/3
 * @since todo
 */
public class Address {

    public Address() {
        System.out.println();
    }

    public Address(String city) {
        this.city = city;
        System.out.println();
    }
    private String city;
    //街道
    private String street;
    //邮编
    private String zipoode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipoode() {
        return zipoode;
    }

    public void setZipoode(String zipoode) {
        this.zipoode = zipoode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipoode='" + zipoode + '\'' +
                '}';
    }
}
