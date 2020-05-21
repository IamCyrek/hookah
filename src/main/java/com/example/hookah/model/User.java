package com.example.hookah.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@Table(schema = "public")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(min = 3, max = 63)
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8, max = 63)
    private String password;

    @Column(nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @NotNull
    private Boolean isEnabled;

    @Transient
    private String accountLevelName;

    @Column(nullable = false)
    @NotNull
    private Long smokingTime;

    @Column
    private Short preferredPower;

    @Column
    private Short preferredTemperature;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "administrator")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<HookahHistory> administratorHookahHistories = new HashSet<>();

    @OneToMany(mappedBy = "visitor")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<HookahHistory> visitorHookahHistories = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<Chat> chats = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<RestaurantReview> restaurantReviews = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Set<FavouriteRestaurant> favouriteRestaurants = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles)
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));

        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
