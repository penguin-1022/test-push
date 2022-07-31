package com.jd.laf.config.api.demo;

import com.jd.laf.binding.Binding;
import com.jd.laf.binding.reflect.exception.ReflectionException;
import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Property;
import com.jd.laf.config.Resource;
import com.jd.laf.config.demo.common.beans.JsonConvertUser;
import com.jd.laf.config.listener.ConfigurationListener;
import com.jd.laf.config.listener.PropertyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by bjliuyong on 2018/12/18.
 */
public class ConfiguratorManagerStarter {

    private final static Logger logger = LoggerFactory.getLogger(ConfiguratorManagerStarter.class);
    private JsonConvertUser jsonConvertUser = new JsonConvertUser();

    public static void main(String args[]) throws Exception {

        ConfiguratorManager configuratorManager = new ConfiguratorManagerStarter().ducc();

        synchronized (ConfiguratorManagerStarter.class){
            ConfiguratorManagerStarter.class.wait();
        }

        //java进程退出时，可进行关闭
        configuratorManager.stop();

    }

    public ConfiguratorManager ducc() throws Exception {
        String appName = "myapp_test" ;
        //uri格式详解参见：https://git.jd.com/laf/laf-config/wikis/客户端使用指南->UCC配置服务
        //resource uri format => ucc://{app_name}:{token}@{domain}:{port}/v1/namespace/{namespace}/config/{configuration}/profiles/{profiles}?longPolling=60000&necessary=false
//        String uri = "ucc://myapp_test:0bb15faf-a36d-40cd-9a93-88074eb920b0@test.ducc.jd.local/v1/namespace/ducc_admin/config/admin/profiles/common?longPolling=60000&necessary=false" ;
        String uri = "ucc://duccadmin:bd2f271319e349048853701b4dba2512@ducc.jd.local/v1/namespace/ducc_demo/config/config1/profiles/profile2?longPolling=60000&necessary=true" ;
        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance() ;
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

        //resourceName是资源名，命名自定义，多个时不要重复
        String resourceName = "myResourceName";

        //创建资源对象，此处直接使用ducc远程，Name属性很重要，下面会用到
        Resource resource = new Resource(resourceName, uri);
        //给配置管理器添加管理的资源
        configuratorManager.addResource(resource);

        //可以监听多个Resource
        //configuratorManager.addResource(resource); 调用多次

        //启动之后才可以获取配置
        configuratorManager.start();

        //获取配置 方式1 (获取合并后指定配置)
        Property property1 = configuratorManager.getProperty("jdbc.url");
        logger.info("{}", "jdbc.url:" + property1.getString());

        //获取配置 方式2 (获取指定配置源下指定配置)
        Property property2 = configuratorManager.getProperty(resourceName, "jdbc.url");
        logger.info("{}", "jdbc.url:" + property2.getString());

        //获取配置 方式3 (获取指定配置源下配置集合)
        final Configuration configuraiton = configuratorManager.getConfiguration(resourceName);
        logger.info("{}", "ucc configuration:" + configuraiton);
        logger.info("{}", "jdbc.url:" + configuraiton.getProperty("jdbc.url").getString());

        //添加监听器，配置项维度的监听器
        configuratorManager.addListener(new PropertyListener.CustomPropertyListener("test.key") {
            @Override
            public void onUpdate(Property property) {
                logger.info("{}", property);
            }
        });

        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                logger.info("{}", configuration);
                try {
                    String fName = "user";
                    Field userField = jsonConvertUser.getClass().getDeclaredField(fName);
                    String value = configuration.getProperty(fName).getValue().toString();
                    Binding.set(jsonConvertUser, userField, value);

                    //key1
                    fName = "key1";
                    Field key1Field = jsonConvertUser.getClass().getDeclaredField(fName);
                    value = configuration.getProperty(fName).getValue().toString();
                    Binding.set(jsonConvertUser, key1Field, value);

                    //key2
                    fName = "key2";
                    Field key2Field = jsonConvertUser.getClass().getDeclaredField(fName);
                    value = configuration.getProperty(fName).getValue().toString();
                    Binding.set(jsonConvertUser, key2Field, value);

                    //ignoreJsonUser
                    fName = "ignoreJsonUser";
                    Field ignoreJsonUserField = jsonConvertUser.getClass().getDeclaredField(fName);
                    value = configuration.getProperty(fName).getValue().toString();
                    Binding.set(jsonConvertUser, ignoreJsonUserField, value);

                    logger.info("jsonConvertUser: {}", jsonConvertUser);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (ReflectionException e) {
                    e.printStackTrace();
                }
            }
        });

        return configuratorManager;
    }

}
