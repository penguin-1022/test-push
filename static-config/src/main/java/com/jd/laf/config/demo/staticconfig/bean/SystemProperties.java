package com.jd.laf.config.demo.staticconfig.bean;

import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.stereotype.Component;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/1/25
 * @since todo
 */
@Component
public class SystemProperties {
    @LafValue("sun.jnu.encoding")
    private String encoding;
    @LafValue("java.class.path")
    private String classPath;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String toString() {
        return "SystemProperties{" +
                "encoding='" + encoding + '\'' +
                ", classPath='" + classPath + '\'' +
                '}';
    }
}
