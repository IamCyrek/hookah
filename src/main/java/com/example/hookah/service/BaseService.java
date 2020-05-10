package com.example.hookah.service;

import com.example.hookah.model.RoleName;
import com.example.hookah.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public interface BaseService {

    default Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    default User getCurrentUser() {
        return (User) getAuthentication().getPrincipal();
    }

    default boolean hasUserRole(RoleName roleName) {
        for (GrantedAuthority authority : getAuthentication().getAuthorities())
            if (authority.getAuthority().equals(roleName.toString()))
                return true;

        return false;
    }
}
