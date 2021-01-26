package com.studies.mall.service.impl;

import com.studies.mall.common.consume.TimeConsumeLog;
import com.studies.mall.entity.UserDTO;
import com.studies.mall.mapper.UserMapper;
import com.studies.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @TimeConsumeLog(methodDesc = "queryUserInfo")
    @Override
    public UserDTO queryUserByWorknumber(Integer worknumber) {
        return userMapper.selectByPrimaryKey(worknumber);
    }

    @Override
    public List<UserDTO> queryUserList() {
        return userMapper.selectAll();
    }

}
