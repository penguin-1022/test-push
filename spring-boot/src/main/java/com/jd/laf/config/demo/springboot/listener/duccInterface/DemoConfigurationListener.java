package com.jd.laf.config.demo.springboot.listener.duccInterface;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.listener.ConfigurationListener;
import org.springframework.stereotype.Component;

/**
 * Title: 通过实现 {@link ConfigurationListener} 接口，实现 DUCC 配置监听器. <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2021/11/12
 * @since todo
 */
@Component
public class DemoConfigurationListener implements ConfigurationListener {

    @Override
    public String getName() {
        //返回值是： laf.config.manager.resources[index].name 对应的配置名称
        return "myapp_test";
    }

    @Override
    public void onUpdate(Configuration configuration) {
        System.out.println("configuration: " + configuration);
    }
}
