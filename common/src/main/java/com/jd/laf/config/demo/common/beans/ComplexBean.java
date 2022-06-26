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

    @LafValue("complex.simpleValue")
    private String simpleValue;

    @LafValue("complex.user")
    @JsonConverter
    private User user;

    @LafValue("complex.userList")
    @JsonConverter
    private List<User> userList;

    @LafValue("complex.userMap")
    @JsonConverter
    private Map<String, User> userMap;

    @LafValue("complex.dateBean")
    @JsonConverter
    private DateBean dateBean;

    //inject at method
    private List<StdClass> classList;

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

    @Override
    public String toString() {
        return "ComplexBean{" +
                "simpleValue='" + simpleValue + '\'' +
                ", user=" + user +
                ", userList=" + userList +
                ", userMap=" + userMap +
                ", dateBean=" + dateBean +
                ", classList=" + classList +
                '}';
    }
}
