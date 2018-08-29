package com.dhu.dao;

import com.dhu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    User getUserById (int user_id);
    User getUserByLogin(@Param("user_count")String user_count,@Param("user_psw")String user_psw);
    List<User> getUsers();
}
