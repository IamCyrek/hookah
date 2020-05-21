package com.example.hookah.controller.mapper;

import com.example.hookah.controller.dto.UserDTO;
import com.example.hookah.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "password", ignore = true),
    })
    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);

    @Mappings({
            @Mapping(target = "roles", ignore = true),
            @Mapping(target = "administratorHookahHistories", ignore = true),
            @Mapping(target = "visitorHookahHistories", ignore = true),
            @Mapping(target = "chats", ignore = true),
            @Mapping(target = "restaurantReviews", ignore = true),
            @Mapping(target = "favouriteRestaurants", ignore = true),
    })
    User userDTOToUser(UserDTO userDTO);

    List<User> userDTOsToUsers(List<UserDTO> userDTOs);

}
