package com.mabo.user_microservice.services;

import com.mabo.user_microservice.entities.Role;
import com.mabo.user_microservice.entities.User;

public interface UserService {
    User findbyUserName(String username);
    User save(User user);
    Role addRole(Role role);
    User addRoleToUser(String user, String role);
}
