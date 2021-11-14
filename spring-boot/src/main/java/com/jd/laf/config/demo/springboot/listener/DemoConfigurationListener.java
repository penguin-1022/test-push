package com.jd.laf.config.demo.springboot.listener;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.listener.ConfigurationListener;

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
public class DemoConfigurationListener implements ConfigurationListener {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onUpdate(Configuration property) {

    }
}
