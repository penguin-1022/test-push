package com.jd.laf.config.demo.springboot.beans;

import com.jd.laf.binding.marshaller.FastJsonProvider;
import com.jd.laf.binding.marshaller.Marshaller;
import com.jd.laf.binding.marshaller.TypeReference;
import com.jd.laf.binding.marshaller.Unmarshaller;
import com.jd.laf.config.demo.common.beans.ComplexBean;
import com.jd.laf.config.demo.common.bo.DateBean;
import com.jd.laf.config.demo.common.bo.StdClass;
import com.jd.laf.config.demo.common.bo.StdStudent;
import com.jd.laf.config.demo.common.bo.User;
import org.junit.Test;
import java.util.*;

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
public class ComplexBeanTest {

    @Test
    public void testConvert() throws Exception {
        FastJsonProvider provider = new FastJsonProvider();
        Marshaller marshaller = provider.getMarshaller();
        Unmarshaller unmarshaller = provider.getUnmarshaller();

        //user
        User user = new User();
        user.setAge(18);
        user.setName("zhangsan");
        user.setPassword("pwd123456");

        String json = marshaller.marshall(user);
        System.out.println("user json: " + json);

        user = unmarshaller.unmarshall(json, User.class);
        System.out.println("unmarshall user json: " + user);

        //students
        List<StdStudent> students = new ArrayList<StdStudent>();
        students.add(new StdStudent("zhangsan"));
        students.add(new StdStudent("lisi"));
        json = marshaller.marshall(students);
        System.out.println("student list json: " + json);
        students = unmarshaller.unmarshall(json, new TypeReference<ArrayList<StdStudent>>() {
        });
        System.out.println("unmarshall student list: " + students);

        //clazz
        StdClass clazz = new StdClass();
        DateBean dateBean = new DateBean();
        dateBean.setCreateDate(new Date(2015, 9, 1, 8, 0, 0));
        dateBean.setUpdateDate(new Date(2015, 9, 1, 8, 0, 0));
        clazz.setClassName("2015-01");
        clazz.setCreateDate(dateBean);
        clazz.setStudentList(students);

        json = marshaller.marshall(clazz);
        System.out.println("clazz json: " + json);
        System.out.println("unmarshall clazz json: " + unmarshaller.unmarshall(json, StdClass.class));


        //ComplexBean
        ComplexBean complexBean = new ComplexBean();
        complexBean.setDateBean(dateBean);
        List classList = new ArrayList();
        classList.add(clazz);
        complexBean.setClassList(classList);
        complexBean.setUser(user);
        complexBean.setSimpleValue("v1.1");

        json = marshaller.marshall(complexBean);
        System.out.println("complex bean json: " + json);
        complexBean = unmarshaller.unmarshall(json, new TypeReference<ComplexBean>() {
        });
        System.out.println("unmarshall ComplexBean json: " + complexBean);

        //user map
        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put(user.getName(), user);
        System.out.println("user map json: " + marshaller.marshall(userMap));


    }
}
