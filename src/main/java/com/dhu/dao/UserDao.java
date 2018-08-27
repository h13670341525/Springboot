package com.dhu.dao;

import com.dhu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getUserById (int user_id);
    User getUserByLogin(@Param("user_id")int user_id,@Param("user_name")String user_name);
    List<User> getUsers();
}
