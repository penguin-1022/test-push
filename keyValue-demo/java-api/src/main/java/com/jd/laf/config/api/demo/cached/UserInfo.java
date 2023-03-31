package com.jd.laf.config.api.demo.cached;

import com.jd.laf.binding.Plugin;
import com.jd.laf.binding.marshaller.Marshaller;
import com.jd.laf.binding.marshaller.TypeReference;
import com.jd.laf.binding.marshaller.Unmarshaller;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2023/3/26
 * @since 1.4.2
 */
public class UserInfo {
    private int id;
    private String code;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(123);
        userInfo.setCode("1001");
        userInfo.setName("ZhangSan");
        try {
            Marshaller marshaller = Plugin.JSON.get().getMarshaller();
            Unmarshaller unmarshaller = Plugin.JSON.get().getUnmarshaller();

            String json = marshaller.marshall(userInfo);
            System.out.println("json:" + json);

            userInfo = unmarshaller.unmarshall(json, UserInfo.class);
            System.out.println("userInfo: " + userInfo);


            userInfo = unmarshaller.unmarshall(json, new TypeReference<UserInfo>() {
            });
            System.out.println("userInfo: " + userInfo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
