package com.shopexpress.springboot.backend.apirest.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

//!Se generara de manera automatica >
@Entity
@Table(name="clientes") //palabras compuestas se separa con guion
public class Cliente implements Serializable { //para guardar en los atributos de la sesion
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //para base de datos relacionales ideal
    private Long id;

    @NotEmpty(message = "No puede estar vacio") //pom
    @Size(min = 3, max = 12, message = "El nombre debe tener una dimencion entre 3 y 12")
    @Column(nullable = false) //modificaciones atributos tabla
    private String nombre;

    @NotEmpty(message = "No puede estar vacio")
    private String apellido;

    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No es una direccion de correo valida")
    @Column(nullable = false, unique = false) //email unico
    private String email;

    @Column(name = "create_at")
    @NotNull//porque es objeto
    @Temporal(TemporalType.DATE) //indicar con que parte exctamente trabajar
    private Date createAt;


    private String foto; // foto siempre en cadena

//    @PrePersist
//    public void prePersist(){ //antes que se genere la entiedad
//        createAt = new Date();
//    }
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
