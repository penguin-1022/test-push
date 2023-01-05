package com.jd.laf.config.demo.common.beans;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.spring.annotation.LafUcc;
import com.jd.laf.config.spring.annotation.LafValue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * Title: ducc spring bean. <br>
 * <p/>
 * Description: ducc spring bean 会监听 ducc 服务端动态配置.
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/5/28
 * @since todo
 */
public class DuccBean implements InitializingBean {

    /**
     * 没什么特殊的<br>
     * 标准 spring 注入外部化配置.
     */
    @Value("${local_key1}")
    private String localConfig;

    /**
     * 监听 key：方式1 <br>
     *
     * 使用 spring @Value {@link Value 注解} 监听： ducc_key1 的配置变化.<br>
     * <p></p>
     * 注意: 当 autoListener = true 时使用可以获监听 ducc 服务端 key 的动态变化，autoListener 配置方式如下： <br>
     * laf-config:parameter key="autoListener" value="true", 示例见： spring-ducc.xml
     */
    @Value("${ducc_key1}")
    private String duccConfig1;


    /**
     * 监听配置 key：方式2<br>
     *
     * 在使用 ducc {@link LafValue 注解} 和 spring {@link Value 注解} 监听 ducc_key2 的配置变化.<br>
     * <p></p>
     * 注意: 和方式 1 对比，当 autoListener = true 或者 false， 方式2都可以监听 key 的动态变化
     *
     */
    @LafUcc
    @Value("${ducc_key2}")
    private String duccConfig2;

    /**
     * 监听 key：方式3 <br>
     *
     * 使用 DUCC @LafValue {@link LafValue 注解} 监听：ducc_key3 的配置变化.<br>
     * <p></p>
     * 注意: 当 autoListener = true 或者 false， 都可以监听 key 的动态变化
     */
    @LafValue("ducc_key3")
    private String duccConfig3;

    /**
     * 监听 key：方式4<br>
     *
     * 注意： 不推荐使用此方式： 因为 listener-field 标签的方式在注入配置比较滞后，可能比其它中间件如 jsf/jmq 配置加载晚<br/>
     *
     * 在 spring-ducc.xml 中使用 laf-config:listener-field 监听 ducc_key4 的配置变化，示例见： spring-ducc.xml.<br>
     * <p></p>
     */
    private String duccConfig4;

    /**
     * 监听 key：方式5<br>
     *
     * 注： ducc sdk 版本要求 >= 1.4.1<br>
     *
     * 在 方法上使用 spring @{@link Value} 注解.<br>
     *
     * <p></p>
     */
    private String duccConfig5;

    /**
     * name 对应的是 src/main/resources/spring-ducc.xml 中的 resource name
     */
    @LafValue(name = "ucc_test")
    private Configuration configuration;

    public String getLocalConfig() {
        return localConfig;
    }

    public void setLocalConfig(String localConfig) {
        this.localConfig = localConfig;
    }

    public String getDuccConfig1() {
        return duccConfig1;
    }

    public void setDuccConfig1(String duccConfig1) {
        this.duccConfig1 = duccConfig1;
    }

    public String getDuccConfig2() {
        return duccConfig2;
    }

    public void setDuccConfig2(String duccConfig2) {
        this.duccConfig2 = duccConfig2;
    }

    public String getDuccConfig3() {
        return duccConfig3;
    }

    public void setDuccConfig3(String duccConfig3) {
        this.duccConfig3 = duccConfig3;
    }

    public String getDuccConfig4() {
        return duccConfig4;
    }

    public void setDuccConfig4(String duccConfig4) {
        this.duccConfig4 = duccConfig4;
    }

    public String getDuccConfig5() {
        return duccConfig5;
    }

    /**
     * 注： ducc sdk 版本要求 >= 1.4.1
     * @param duccConfig5
     */
    @LafUcc
    @Value("${ducc_key5:defaultValue}")
    public void setDuccConfig5(String duccConfig5) {
        this.duccConfig5 = duccConfig5;
    }

    @Override
    public void finalize() {
        System.out.println("执行析构函数: " + toString());
    }

    @Override
    public String toString() {
        return "DuccBean{" +
                "localConfig='" + localConfig + '\'' +
                ", duccConfig1='" + duccConfig1 + '\'' +
                ", duccConfig2='" + duccConfig2 + '\'' +
                ", duccConfig3='" + duccConfig3 + '\'' +
                ", duccConfig4='" + duccConfig4 + '\'' +
                ", duccConfig5='" + duccConfig5 + '\'' +
                '}';
    }

    public void init() {
        System.out.println("DuccBean.init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DuccBean.afterPropertiesSet");
    }
}
