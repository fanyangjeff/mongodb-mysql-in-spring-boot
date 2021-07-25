package com.mysqlmongo.mapper;

import com.mysqlmongo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * @author Jeff
 * @date 7/25/21 12:38 AM
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * from users")
    List<User> findAll();
}
