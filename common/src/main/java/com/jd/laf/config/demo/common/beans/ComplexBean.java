package com.jd.laf.config.demo.common.beans;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.common.bo.DateBean;
import com.jd.laf.config.demo.common.bo.StdClass;
import com.jd.laf.config.demo.common.bo.User;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/6/26
 * @since todo
 */
public class ComplexBean {
    private static Logger LOGGER = LoggerFactory.getLogger(ComplexBean.class);

    private String springXMLMethod;

    @LafValue("complex.integerList")
    @JsonConverter
    private List<Integer> integerList;

    @LafValue("complex.simpleValue")
    private String simpleValue;

    /**
     * json 反序列化，说明： <br>
     *     {@link ComplexBean#user} 没有使用泛型，这里会转换成 {@link User} 对象.
     */
    @LafValue("complex.user")
    @JsonConverter
    private User user;

    /**
     * json 反序列化，说明： <br>
     *     {@link ComplexBean#userList} 使用了泛型，并且{@link JsonConverter#isSupportGeneric() = false (默认值)}, 因此这里会转换成 Json 对象. <br>
     *     注： {@link JsonConverter#isSupportGeneric} 参数在 ducc sdk 1.2.0 及之后版本支持, 在 1.2.0 之前不支持泛型反序列化.
     */
    @LafValue("complex.userList")
    @JsonConverter
    private List<User> userList;

    /**
     * json 反序列化，说明： <br>
     *     {@link ComplexBean#userMap} 使用了泛型，并且{@link JsonConverter#isSupportGeneric() = false (默认值)}, 因此这里 Map 里面的 User 会转换成 Json 对象. <br>
     *     注： {@link JsonConverter#isSupportGeneric} 参数在 ducc sdk 1.2.0 及之后版本支持, 在 1.2.0 之前不支持泛型反序列化.
     */
    @LafValue("complex.userMap")
    @JsonConverter
    private Map<String, User> userMap;

    /**
     * json 反序列化，说明： 和 {@link ComplexBean#user} 类似.
     */
    @LafValue("complex.dateBean")
    @JsonConverter
    private DateBean dateBean;

    /**
     * json 反序列化，说明： <br>
     *     {@link ComplexBean#userMap} 使用了泛型，并且{@link JsonConverter#isSupportGeneric() = false (默认值)}, 因此这里 Map 里面的 List<User> 会转换成 Json 对象. <br>
     *     注： {@link JsonConverter#isSupportGeneric} 参数在 ducc sdk 1.2.0 及之后版本支持, 在 1.2.0 之前不支持泛型反序列化.
     */
    @LafValue("complex.map.list")
    @JsonConverter
    private Map<String, List<User>> userMapList;

    /**
     * json 反序列化，说明： <br>
     *     {@link ComplexBean#userMap} 使用了泛型，并且{@link JsonConverter#isSupportGeneric() = true }, 因此这里 Map 里面的 List<User> 会转换成 List 对象, List里面是 User 对象. <br>
     *     注： {@link JsonConverter#isSupportGeneric} 参数在 ducc sdk 1.2.0 及之后版本支持, 在 1.2.0 之前不支持泛型反序列化.
     */
    @LafValue("complex.map.list")
    @JsonConverter(isSupportGeneric = true)
    private Map<String, List<User>> userMapList2;

    private Map<String, List<User>> userMapList3;

    private Map<String, List<User>> userMapList4;

    //inject at method
    private List<StdClass> classList;

    public String getSpringXMLMethod() {
        return springXMLMethod;
    }

    public void setSpringXMLMethod(String springXMLMethod) {
        this.springXMLMethod = springXMLMethod;
    }

    public String getSimpleValue() {
        return simpleValue;
    }

    public void setSimpleValue(String simpleValue) {
        this.simpleValue = simpleValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public DateBean getDateBean() {
        return dateBean;
    }

    public void setDateBean(DateBean dateBean) {
        this.dateBean = dateBean;
    }

    public List<StdClass> getClassList() {
        return classList;
    }

    public void setClassList(List<StdClass> classList) {
        this.classList = classList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    @LafValue("complex.classList")
    public void onClassListChanged(@JsonConverter List<StdClass> classList) {
        this.classList = classList;
        LOGGER.info("classList: {}", classList);
    }

    public Map<String, List<User>> getUserMapList() {
        return userMapList;
    }

    public void setUserMapList(Map<String, List<User>> userMapList) {
        this.userMapList = userMapList;
    }


    public Map<String, List<User>> getUserMapList2() {
        return userMapList2;
    }

    public void setUserMapList2(Map<String, List<User>> userMapList2) {
        this.userMapList2 = userMapList2;
    }

    public Map<String, List<User>> getUserMapList3() {
        return userMapList3;
    }

    /**
     * json 反序列化，说明： 和 {@link ComplexBean#userMapList} 类似
     */
    @LafValue("complex.map.list")
    public void setUserMapList3(@JsonConverter Map<String, List<User>> userMapList3) {
        this.userMapList3 = userMapList3;
    }

    public Map<String, List<User>> getUserMapList4() {
        return userMapList4;
    }

    /**
     * json 反序列化，说明： 和 {@link ComplexBean#userMapList2} 类似
     */
    @LafValue("complex.map.list")
    public void setUserMapList4(@JsonConverter(isSupportGeneric = true) Map<String, List<User>> userMapList4) {
        this.userMapList4 = userMapList4;
    }

    @Override
    public String toString() {
        return "ComplexBean{" +
                "springXMLMethod='" + springXMLMethod + '\'' +
                ", integerList=" + integerList +
                ", simpleValue='" + simpleValue + '\'' +
                ", user=" + user +
                ", userList=" + userList +
                ", userMap=" + userMap +
                ", dateBean=" + dateBean +
                ", userMapList=" + userMapList +
                ", userMapList2=" + userMapList2 +
                ", userMapList3=" + userMapList3 +
                ", userMapList4=" + userMapList4 +
                ", classList=" + classList +
                '}';
    }

    @Override
    public void finalize() {
        System.out.println("执行析构函数: " + toString());
    }
}
