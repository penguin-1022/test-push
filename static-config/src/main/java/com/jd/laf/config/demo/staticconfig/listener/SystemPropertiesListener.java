package com.jd.laf.config.demo.staticconfig.listener;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.listener.ConfigurationListener;
import org.springframework.stereotype.Component;

/**
 * 场景：创建一个监听器，获取配置文件数据（注意，不支持动态修改）<br>
 *
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/1/25
 * @since todo
 */
@Component
public class SystemPropertiesListener implements ConfigurationListener {

    @Override
    public String getName() {
        return "system";
    }

    @Override
    public void onUpdate(Configuration configuration) {
        System.out.println(configuration);
    }
}
