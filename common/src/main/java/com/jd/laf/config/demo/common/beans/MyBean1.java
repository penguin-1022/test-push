package com.jd.laf.config.demo.common.beans;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.spring.annotation.LafUcc;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * Title: 在类上加 @LafUcc 注解 <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/8/5
 * @since todo
 */
@LafUcc(value = true)
public class MyBean1 {

    @Value("${key1}")
    private String key1;
    @Value("${key2}")
    private String key2;

    @LafValue("jsonkey")
    @JsonConverter
    private Map<String, Integer> m;

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

    public Map<String, Integer> getM() {
        return m;
    }

    public void setM(Map<String, Integer> m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "MyBean1{" +
                "key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                ", m=" + m +
                '}';
    }


    @Override
    public void finalize() {
        System.out.println("执行析构函数: " + toString());
    }
}
