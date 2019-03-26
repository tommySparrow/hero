package com.house.hero.mapper;

import java.util.List;

public interface UserRoleMapper {

    List<String> queryAllPerms(Integer userId);
}