package com.example.hookah.service;

import com.example.hookah.model.RoleName;
import com.example.hookah.model.User;
import com.example.hookah.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User with email '" + email + "' not found."
                )
        );
    }

    public List<User> getAllUsers(Sort sort) {
        return userRepository.findAll(sort);
    }

    public User createUser(User user, PasswordEncoder encoder) {
        user.setId(null);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setIsEnabled(true);
        user.setRoleSet(new HashSet<>(Collections.singletonList(roleService.findRoleByName(RoleName.ROLE_USER))));

        return userRepository.save(user);
    }

}
