package com.java.project.libre.entities;

import com.java.project.libre.enumeratin.role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private role role;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> users=new HashSet<>();
}
