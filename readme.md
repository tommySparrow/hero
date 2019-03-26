com.house.hero.web.controller
    1.OneToOneController:演示mybatis一对一
    2.OneToManyController:演示mybatis一对多
    3.VerifyCodeController:演示验证码的生成
    4.ShiroLoginController:演示shiro登录
    5.ShiroMenuController:演示shiro权限(在登录成功的前提下,拥有权限才能访问)
    
com.house.hero.common.utils(工具类)
    1.HashUtils:哈希MD5加密
    2.QRCodeUtil:二维码工具类
    3.ImageUtil:验证码工具类
    4.RedisUtil:Redis工具类
    
    
    
    
    
备注:
    1.swagger访问路径
     http://localhost:8080/swagger-ui.html
     
    2.spring-boot-starter-aop:加入AOP,才能在完成shiro认证后,访问功能时授权