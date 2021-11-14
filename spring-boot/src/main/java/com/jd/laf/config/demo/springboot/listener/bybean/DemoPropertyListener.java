package com.jd.laf.config.demo.springboot.listener.bybean;

import com.jd.laf.config.Property;
import com.jd.laf.config.listener.PropertyListener;
import org.springframework.stereotype.Component;

/**
 * Title: 通过实现 {@link PropertyListener} 接口，实现 DUCC 配置属性监听器 <br>
 * <p/>
 *
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2021/11/14
 * @since todo
 */
@Component
public class DemoPropertyListener implements PropertyListener {

    private String str;

    @Override
    public void onUpdate(Property property) {
        System.out.println("onUpdate, property: " + property);
        str = property.toString();
    }

    @Override
    public String getName() {
        //laf.config.manager.resources[x].name 对应的配置名称
        return "myapp_test";
    }

    @Override
    public String getKey() {
        return "bean.property.listener";
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "BeanDemoPropertyListener{" +
                "str='" + str + '\'' +
                '}';
    }
}
