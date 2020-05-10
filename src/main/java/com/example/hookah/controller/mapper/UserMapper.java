package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.UserDTO;
import com.example.hookah.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(target = "password", ignore = true),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "isEnabled", target = "isEnabled")
    })
    @Named("userToUserDTO")
    UserDTO userToUserDTO(User user);

    @IterableMapping(qualifiedByName = "userToUserDTO")
    List<UserDTO> userToUserDTO(List<User> users);


    @Mappings({
            @Mapping(source = "userDTO.id", target = "id"),
            @Mapping(source = "userDTO.name", target = "name"),
            @Mapping(source = "userDTO.email", target = "email"),
            @Mapping(source = "userDTO.password", target = "password"),
            @Mapping(source = "userDTO.isEnabled", target = "isEnabled"),
            @Mapping(target = "roleSet", ignore = true)
    })
    User userDtoToUser(UserDTO userDTO);

}
