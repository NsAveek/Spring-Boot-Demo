package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @Setter
    @Getter
    @Column(name = "email")
    private String email;

    @Setter
    @Getter
    @Column(name = "age")
    private  String age;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
