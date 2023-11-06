package com.java.project.libre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
@Data  @NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Valid
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public User(String Email, String Password){
        this.email=Email;
        this.password=Password;
        this.roles=new HashSet<>();
    }

}
