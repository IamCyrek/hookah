package com.example.hookah.service;

import com.example.hookah.model.Role;
import com.example.hookah.model.RoleName;
import com.example.hookah.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findRoleByName(RoleName roleName) {
        Optional<Role> optionalRole = roleRepository.findRoleByName(roleName);
        if (!optionalRole.isPresent()) {
            //TODO: throw exception
        }

        return optionalRole.get();
    }

}
