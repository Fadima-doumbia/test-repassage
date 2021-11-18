package com.farima.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
/*    @ManyToOne
    private Long userId ;
    private User userId ;
    @OneToMany
    List<Project> projects = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Project> projects;*/
    
@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
private Set<Project> projects = new HashSet<>();

}
