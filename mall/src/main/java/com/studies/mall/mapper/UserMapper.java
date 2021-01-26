package com.studies.mall.mapper;

import com.studies.mall.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer worknumber);

    int insert(UserDTO record);

    UserDTO selectByPrimaryKey(Integer worknumber);

    List<UserDTO> selectAll();

    int updateByPrimaryKey(UserDTO record);
}