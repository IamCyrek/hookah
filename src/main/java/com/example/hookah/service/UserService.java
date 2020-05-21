package com.example.hookah.service;

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
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AccountLevelService accountLevelService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User with email '" + email + "' not found."
                )
        );
    }

    public List<User> getAll(Sort sort) {
        List<User> users = userRepository.findAll(sort);
        users.forEach(user -> user.setSmokingTime(user.getSmokingTime() / 3600));
        users.forEach(user ->
                accountLevelService.getAccountLevelByValue(user.getSmokingTime())
                        .ifPresent(accountLevel -> user.setAccountLevelName(accountLevel.getName())));

        return users;
    }

    public User create(User user, PasswordEncoder encoder) {
        user.setId(null);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setIsEnabled(true);
        user.setSmokingTime(0L);

        return userRepository.save(user);
    }

}
