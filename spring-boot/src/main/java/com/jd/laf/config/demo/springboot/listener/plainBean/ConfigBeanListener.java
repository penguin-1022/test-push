package com.jd.laf.config.demo.springboot.listener.plainBean;

import com.jd.laf.config.Property;
import com.jd.laf.config.listener.PropertyListener;
import org.springframework.stereotype.Component;

/**
 * Title: 普通 bean 作为 ducc listener <br>
 * <p/>
 * Description: 结合配置文件，可以使用一个未实现 DUCC {@link PropertyListener} 接口普通 bean 监听 ducc 配置。
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2021/11/12
 * @since todo
 */
@Component("configBeanListener")
public class ConfigBeanListener {

    private String c1;
    protected String propertyStr;

    public String getName() {
        return "admin";
    }

    public String getKey() {
        return "conf.c1";
    }

    public void onUpdate(Property property) {
        System.out.println("onUpdate: " + property);
        propertyStr = property.toString();
    }

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
        return "ConfigBeanListener{" +
                "c1='" + c1 + '\'' +
                ", propertyStr='" + propertyStr + '\'' +
                '}';
    }
}
