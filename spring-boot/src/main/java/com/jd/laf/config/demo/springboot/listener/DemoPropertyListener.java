package com.jd.laf.config.demo.springboot.listener;

import com.jd.laf.config.Property;
import com.jd.laf.config.listener.PropertyListener;
import org.springframework.stereotype.Component;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2021/11/12
 * @since todo
 */
@Component("demoPropertyListener")
public class DemoPropertyListener {

    private String c1;

    public String getC1() {
        return c1;
    }

    public void setConfig1(String c1) {
        this.c1 = c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "DemoPropertyListener{" +
                "c1='" + c1 + '\'' +
                '}';
    }
}
