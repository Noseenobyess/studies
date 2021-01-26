package com.studies.mall.service;

import com.studies.mall.entity.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO queryUserByWorknumber(Integer worknumber);

    List<UserDTO> queryUserList();
}
