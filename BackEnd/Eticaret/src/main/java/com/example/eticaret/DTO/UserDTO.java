package com.example.eticaret.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UserDTO {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Password is required")
    private String password;

    //Constructor
    public UserDTO() {
    }
    public UserDTO(String username,String email,String role,String password) {
        this.username=username;
        this.email=email;
        this.role=role;
        this.password=password;
    }

    //Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
