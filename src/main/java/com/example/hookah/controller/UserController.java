package com.example.hookah.controller;

import com.example.hookah.controller.dto.UserDTO;
import com.example.hookah.controller.mapper.UserMapper;
import com.example.hookah.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.hookah.configuration.Constants.API_USERS;
import static com.example.hookah.configuration.Constants.REGISTRATION;

@RestController
@RequestMapping(API_USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final PasswordEncoder encoder;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getAllUsers(@SortDefault(sort = "id") Sort sort) {
        return userMapper.userToUserDTO((userService.getAllUsers(sort)));
    }

    @PostMapping(value = REGISTRATION)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        return userMapper.userToUserDTO(userService.createUser(userMapper.userDtoToUser(userDTO), encoder));
    }

}
