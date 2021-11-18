package com.farima.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "projet")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String entrepreneur;
    private String besoin;
/*    @OneToMany
    private List<Project> projects;*/

//    @ManyToOne
//    private User userId;
    @ManyToOne
    private User userId;

}
