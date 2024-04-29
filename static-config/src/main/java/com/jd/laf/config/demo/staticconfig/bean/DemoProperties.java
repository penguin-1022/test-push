package com.jd.laf.config.demo.staticconfig.bean;

import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.stereotype.Component;

/**
 * 场景，获取配置文件数据（注意，不支持动态修改）<br/>
 *
 * 模拟一个 spring bean 使用 {@link  LafValue} 注解注入配置文件里的 key <br>
 *
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/1/25
 * @since todo
 */
@Component
public class DemoProperties {
    @LafValue("key1")
    private String key1;
    @LafValue("key2")
    private String key2;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    @Override
    public String toString() {
        return "DemoProperties{" +
                "key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                '}';
    }
}
