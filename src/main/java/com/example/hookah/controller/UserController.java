package com.example.hookah.controller;

import com.example.hookah.configuration.JwtTokenUtil;
import com.example.hookah.controller.dto.UserDTO;
import com.example.hookah.controller.mapper.UserMapper;
import com.example.hookah.model.JwtRequest;
import com.example.hookah.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.hookah.configuration.Constants.*;

@RestController
@RequestMapping(API_USERS)
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    private final PasswordEncoder encoder;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getAll(@SortDefault(sort = "id") Sort sort) {
        return userMapper.usersToUserDTOs((userService.getAll(sort)));
    }

    @PostMapping(value = REGISTRATION)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        return userMapper.userToUserDTO(userService.create(userMapper.userDTOToUser(userDTO), encoder));
    }

    @PostMapping(value = AUTHENTICATION)
    public String createAuthenticationToken(@RequestBody JwtRequest request) /*throws Exception*/ {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetails userDetails = userService.loadUserByUsername(request.getEmail());

        return jwtTokenUtil.generateToken(userDetails);
    }

}
