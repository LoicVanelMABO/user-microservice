package com.mabo.user_microservice.services;

import com.mabo.user_microservice.entities.Role;
import com.mabo.user_microservice.entities.User;
import com.mabo.user_microservice.repositories.RoleRepository;
import com.mabo.user_microservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Transactional qui commit tous les changement d'objet
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findbyUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String user, String role) {
        Role role1 = roleRepository.findByRole(role);
        User user1 = findbyUserName(user);
        user1.getRoles().add(role1);

        return userRepository.save(user1);
    }
}
