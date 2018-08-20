## 项目介绍

　CityserverX是一个基于SpringBoot2.0的搭建的MOA框架--面向模块开发框架，力争做到开发人员只需要关心业务逻辑。具有以下特点：

- 模块耦合度低
- 模块按需打包、按需部署
- 自由的模块扩展
- 统一的返回模型
- 统一异常处理与日志记录
- 全局API接口鉴权(token等)

## 项目结构

```bash
city-server-parent          
|--cole-demo-controller            # controller/REST模块
|  |--***/config                   # 模块的配置，目前Swagger
|  |--***/controller               # 接口定义
|--cole-demo-service               # 业务实现模块
|  |--***/config                   # 配置（非必要）
|  |--***/dao                      # 持久层
|  |--***/model                    # 数据模型/实体
|  |--***/service                  # 业务层
|--cole-web                        # 服务入口（固定，一般不动）
|  |--java/***                     # ····
|  |--resources/application.yml    # 配置文件
|  |--resources/application-dev.yml# 开发的配置
|  |--resources/application-prod.yml# 生产环境的配置

```



