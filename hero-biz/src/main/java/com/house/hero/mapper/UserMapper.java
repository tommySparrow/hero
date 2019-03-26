package com.house.hero.mapper;

import com.github.abel533.mapper.Mapper;
import com.house.hero.common.bean.User;

public interface UserMapper extends Mapper<User> {
    User selectUserByUsername(String username);
}