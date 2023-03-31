package com.jd.laf.config.api.demo.cached;

import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Property;
import com.jd.laf.config.Resource;
import com.jd.laf.config.cached.ConfigurationCachedManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CachedDemoMain {

    private final static Logger logger = LoggerFactory.getLogger(CachedDemoMain.class);

    public static void main(String args[]) throws Exception {

        ConfiguratorManager configuratorManager = new CachedDemoMain().ducc();

        while (true) {
            System.out.println("-----------------------------get user from global, -----------------------------");
            UserInfo userInfo = ConfigurationCachedManager.getGlobalObject(configuratorManager, "zs.a", UserInfo.class);
            System.out.println("global user, zs.a: " + userInfo);

            userInfo = ConfigurationCachedManager.getGlobalObject(configuratorManager, "zs.b", UserInfo.class);
            System.out.println("global user, zs.b: " + userInfo);
            System.out.println("-----------------------------get user from global,-----------------------------");

            System.out.println("-----------------------------get user from rs1, -----------------------------");
            userInfo = ConfigurationCachedManager.getObject(configuratorManager, "rs1", "zs.a", UserInfo.class);
            System.out.println("rs1 user, zs.a: " + userInfo);

            userInfo = ConfigurationCachedManager.getObject(configuratorManager, "rs1", "zs.b", UserInfo.class);
            System.out.println("rs1 user, zs.b: " + userInfo);
            System.out.println("-----------------------------get user from rs1, -----------------------------");

            System.out.println("-----------------------------get user array from global-----------------------------");
            List<Property> pList = ConfigurationCachedManager.getGlobalPrefix(configuratorManager, "userInfo.", UserInfo.class);
            List<UserInfo> userInfos = ConfigurationCachedManager.convert(pList);
            System.out.println("user, zs.a: " + userInfos);
            System.out.println("-----------------------------get user array from global-----------------------------");

            System.out.println("-----------------------------get user array from rs1-----------------------------");
            pList = ConfigurationCachedManager.getPrefix(configuratorManager, "rs1", "userInfo.", UserInfo.class);
            userInfos = ConfigurationCachedManager.convert(pList);
            System.out.println("user, zs.a: " + userInfos);
            System.out.println("-----------------------------get user array from rs1-----------------------------");

            TimeUnit.SECONDS.sleep(2);
            System.out.println("\n\n\n");
        }
    }

    public ConfiguratorManager ducc() throws Exception {
        String appName = "myapp_test" ;
        String uri1 = "ucc://duccadmin:bd2f271319e349048853701b4dba2512@ducc.jd.local/v1/namespace/ducc_demo/config/config1/profiles/cached_demo?longPolling=60000&necessary=true";
        String uri2 = "ucc://duccadmin:bd2f271319e349048853701b4dba2512@ducc.jd.local/v1/namespace/ducc_demo/config/config1/profiles/cached_demo_2?longPolling=60000&necessary=true";

        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance() ;
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

        //resourceName是资源名，命名自定义，多个时不要重复
        String rs1 = "rs1";
        String rs2 = "rs2";

        //创建资源对象，此处直接使用ducc远程，Name属性很重要，下面会用到
        Resource resource1 = new Resource(rs1, uri1);
        Resource resource2 = new Resource(rs2, uri2);
        //给配置管理器添加管理的资源
        configuratorManager.addResource(resource1);
        configuratorManager.addResource(resource2);

        //启动之后才可以获取配置
        configuratorManager.start();

        return configuratorManager;
    }

}
