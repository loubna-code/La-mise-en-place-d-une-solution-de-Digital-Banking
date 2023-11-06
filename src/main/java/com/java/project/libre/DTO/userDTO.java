package com.java.project.libre.DTO;

import com.java.project.libre.entities.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {

    @Valid
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    private Set<String> roles = new HashSet<>();
    public userDTO(String Email, String Password){
        this.email=Email;
        this.password=Password;
        this.roles=new HashSet<>();
    }


}
