package com.jd.laf.config.demo.common.bo;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/6/26
 * @since todo
 */
public class StdStudent {
    private String name;

    public StdStudent(){}

    public StdStudent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StdStudent{" +
                "name='" + name + '\'' +
                '}';
    }
}
