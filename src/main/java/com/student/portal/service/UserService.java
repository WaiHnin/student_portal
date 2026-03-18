package com.student.portal.service;

import com.student.portal.entity.User;

import java.util.Set;

public interface UserService {

    User createNewUser(String username, String password, String roles);
}
