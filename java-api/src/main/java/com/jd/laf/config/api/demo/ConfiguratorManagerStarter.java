package com.jd.laf.config.api.demo;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Property;
import com.jd.laf.config.Resource;
import com.jd.laf.config.listener.ConfigurationListener;
import com.jd.laf.config.listener.PropertyListener;

/**
 * Created by bjliuyong on 2018/12/18.
 */
public class ConfiguratorManagerStarter {

    public static void main(String args[]) throws Exception {
        String appName = "myapp_test" ;
        //resource uri format => ucc://{app_name}:{token}@{domain}:{port}/v1/namespace/{namespace}/config/{configuration}/profiles/{profiles}?longPolling=60000&necessary=false
        String uri = "ucc://myapp_test:0bb15faf-a36d-40cd-9a93-88074eb920b0@ducc.jd.local/v1/namespace/ducc_admin/config/admin/profiles/common?longPolling=60000&necessary=false" ;
        //创建ConfiguratorManager 实例
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance() ;
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

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
        System.out.println("jdbc.url:" + property1.getString());

        //获取配置 方式2 (获取指定配置源下指定配置)
        Property property2 = configuratorManager.getProperty(resourceName, "jdbc.url");
        System.out.println("jdbc.url:" + property2.getString());

        //获取配置 方式3 (获取指定配置源下配置集合)
        Configuration configuraiton = configuratorManager.getConfiguration(resourceName);
        System.out.println("ucc configuration:" + configuraiton);
        System.out.println("jdbc.url:" + configuraiton.getProperty("jdbc.url").getString());

        //添加监听器，配置项维度的监听器
        configuratorManager.addListener(new PropertyListener.CustomPropertyListener("test.key") {
            @Override
            public void onUpdate(Property property) {
                System.out.println(property);
            }
        });

        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                System.out.println(configuration);
            }
        });

        synchronized (configuraiton){
            configuraiton.wait();
        }

        //java进程退出时，可进行关闭
        configuratorManager.stop();

    }
}
