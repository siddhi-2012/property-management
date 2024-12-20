package com.project.property.management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Entity
@Table(name="PROPERTY_TITLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="PROPERTY_TITLE",nullable=false)
    private String title;
    private String description;
    private Double price;
    private String address;

}
