package com.jd.laf.config.demo.predict;

import com.jd.laf.binding.Binding;
import com.jd.laf.binding.reflect.exception.ReflectionException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/8/3
 * @since todo
 */
public class PredictOperatorTest {

    @Test
    public void testPredict() throws ReflectionException, NoSuchFieldException {
        MyBean1 bean1 = new MyBean1(1);
        Binding.set(bean1, MyBean1.class.getDeclaredField("user"), "zhangsan,18");
        System.out.println(bean1);
        Assert.assertEquals(bean1.id, 1);
        Assert.assertEquals(bean1.user.name, "zhangsan");
        Assert.assertEquals(bean1.user.age, 18);

        MyBean1 bean2 = new MyBean1(2);
        Binding.set(bean2, MyBean1.class.getDeclaredField("user"), "lisi,20");
        System.out.println(bean2);
        Assert.assertEquals(bean2.id, 2);
        Assert.assertEquals(bean2.user.name, "lisi");
        Assert.assertEquals(bean2.user.age, 20);
    }

    public static class MyBean1 {
        private int id;
        private User user;

        public MyBean1(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "MyBean1{" +
                    "id=" + id +
                    ", user=" + user +
                    '}';
        }
    }

}
