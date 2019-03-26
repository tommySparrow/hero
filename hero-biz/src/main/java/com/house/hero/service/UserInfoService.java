package com.house.hero.service;

import com.house.hero.common.bean.User;
import com.house.hero.mapper.UserMapper;
import com.house.hero.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/3/25
 * @ Description：
 * @ throws
 */
@Service
public class UserInfoService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public User findByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public List<String> queryAllPerms(Integer userId) {
    return userRoleMapper.queryAllPerms(userId);
    }
}
