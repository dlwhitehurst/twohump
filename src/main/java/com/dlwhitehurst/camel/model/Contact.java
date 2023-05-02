package com.dlwhitehurst.camel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "contacts", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "ct_name")
    private String name;
    @NotBlank
    @Column(name = "ct_email")
    private String email;
}
