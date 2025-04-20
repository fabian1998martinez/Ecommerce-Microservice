package com.fabianmartinez.customer.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El numero de documento no puede ser vacio")
    @Size(min = 8,max = 8,message = "El tamaño del numero de documento es 8")
    @Column(name = "number_Id",unique = true,length = 8,nullable = false)
    private String numberId;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Column(name = "firs_name",nullable = false)
    private String firsName;

    @NotEmpty(message = "El apellido no puede estar vacio")
    @Column(name = "last_name",nullable = false)
    private String lastName;


    @NotEmpty(message = "este campo no puede estar vacio")
    @Email(message = "no es una direccion bien formado")
    @Column(unique = true,nullable = false)
    private String email;


    @NotEmpty(message = "la region no puede de ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;

    private String state;


}
