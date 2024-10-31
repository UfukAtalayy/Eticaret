package com.example.eticaret.Mapper;

import com.example.eticaret.DTO.UserDTO;
import com.example.eticaret.Entity.User;

public class UserMapper {

    // User entity'sinden UserDTO'ya dönüşüm
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), user.getRole(), user.getPassword());
    }

    // UserDTO'dan User entity'sine dönüşüm
    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
}
