package com.house.hero.shiroConfig;

import com.house.hero.common.bean.User;
import com.house.hero.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User)principalCollection.getPrimaryPrincipal();
        Integer userId = user.getId();

        List<String> permsList;
            permsList = userInfoService.queryAllPerms(userId);
        //用户权限列表
        Set<String> permsSet = permsList.stream().parallel()
                .filter(StringUtils::isNotBlank)
                .map(String::trim)
                .map(s -> s.split(","))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("ShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userInfoService.findByUsername(username);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

}