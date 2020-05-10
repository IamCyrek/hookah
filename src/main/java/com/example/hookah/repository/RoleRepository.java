package com.example.hookah.repository;

import com.example.hookah.model.Role;
import com.example.hookah.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findRoleByName(RoleName name);

}
