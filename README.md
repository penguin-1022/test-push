# DUCC-demo

The demo for DUCC 

### demo中用到的配置示例
http://taishan.jd.com/ducc/web/namespacedetail?id=10382&name=ducc_demo

### 测试环境域名以进行域名解析

test.ducc.jd.local

### 线上环境域名
ducc.jd.local

### model说明
- [common](common)
  - 说明：demo 各个 module 共用
- [keyValue-demo](keyValue-demo)
  - 说明：key/value 数据类型配置相关 demo
  - [java-api 示例 demo](keyValue-demo/java-api)
    - 说明：在 pom 里引入 ducc sdk，通过 api 方式使用 ducc sdk.
    - [点击查看文档](https://joyspace.jd.com/pages/9bs15WpgAqeEQeSOKPfQ)
  - [dynamic-log](keyValue-demo/dynamic-log)
    - 说明：动态日志配置 demo
    - [点击查看文档](https://joyspace.jd.com/pages/jE12zp1TKbGSkLYPSqWZ)
  - [spring](keyValue-demo/spring)
      - 说明：spring 场景的 demo
      - [点击查看文档](https://joyspace.jd.com/pages/uicp9fIrlr8iufE9L1fZ)
  - [spring-boot](keyValue-demo/spring-boot)
      - 说明：spring boot 场景的 demo
      - [点击查看文档](https://joyspace.jd.com/pages/EstJJ1FE8cwKfHjtwlAF)
  - [spring-web-mvc](keyValue-demo/spring-web-mvc)
      - 说明：spring web mvc 场景的 demo. 和 spring 场景相同，可以查看 spring 场景使用文档.
      - [点击查看spring场景文档](https://joyspace.jd.com/pages/uicp9fIrlr8iufE9L1fZ)
  - [spring-web-mvc](keyValue-demo/spring-web-mvc)
      - 说明：ducc sdk 支持读取本地静态配置文件.
- [staticconfig](static-config)
  - 说明：ducc sdk 支持读取本地静态配置文件.
- [dict-demo](dict-demo)
  - 说明： 词表数据结构类型配置相关 demo
  - [dict-api-demo](dict-demo/dict-api-demo)
    - 说明：词表 api 方式 demo
  - [dict-spring-demo](dict-demo/dict-spring-demo)
  - 说明：词表 spring 方式 demo


