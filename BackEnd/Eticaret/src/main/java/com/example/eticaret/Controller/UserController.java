package com.example.eticaret.Controller;

import com.example.eticaret.DTO.UserDTO;
import com.example.eticaret.Entity.User;
import com.example.eticaret.Mapper.UserMapper;
import com.example.eticaret.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        // User listesi alınıp DTO'ya çevriliyor
        return userService.getAllUsers().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(u -> ResponseEntity.ok(UserMapper.toDTO(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userService.createUser(user);
        return UserMapper.toDTO(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

