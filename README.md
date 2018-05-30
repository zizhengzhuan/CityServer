# CityServer

将cityserver的包解压到tomcat的webapps下，作为一个应用发布。cityserver的结构说明：


```markdown
- conf				--配置文件
 - application.yml	 --项目全局配置文件
- services			--服务包的目录
 - sp-xxx.jar
 - .....
- lib				--依赖包地址
 - xxxxx.jar
- WEB-INF			--应用的入口
  - beans.xml
  - web.xml
```



------

Zhongzhi Hongtu Technology Co., Ltd.（ZZHT）CityServer WebApp Document