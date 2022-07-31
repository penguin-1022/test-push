package com.jd.laf.config.demo.common.beans;

import com.jd.laf.binding.annotation.IgnoreClassConverter;
import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.common.bo.User;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/7/26
 * @since todo
 */
@JsonConverter
public class JsonConvertUser {
    private User user;
    private int key1;
    private String key2;
    private String key3;
    @IgnoreClassConverter
    private User ignoreJsonUser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public User getIgnoreJsonUser() {
        return ignoreJsonUser;
    }

    public void setIgnoreJsonUser(User ignoreJsonUser) {
        this.ignoreJsonUser = ignoreJsonUser;
    }

    @Override
    public String toString() {
        return "JsonConvertUser{" +
                "user=" + user +
                ", key1=" + key1 +
                ", key2='" + key2 + '\'' +
                ", key3='" + key3 + '\'' +
                ", ignoreJsonUser=" + ignoreJsonUser +
                '}';
    }
}
