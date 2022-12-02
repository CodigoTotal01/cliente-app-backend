package com.shopexpress.springboot.backend.apirest.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

//!Se generara de manera automatica >
@Entity
@Table(name="clientes") //palabras compuestas se separa con guion
public class Cliente implements Serializable { //para guardar en los atributos de la sesion
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //para base de datos relacionales ideal
    private Long id;

    @Column(name = "nombre") //modificaciones atributos tabla
    private String nombre;

    private String apellido;


    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE) //indicar con que parte exctamente trabajar
    private Date createAt;

    @PrePersist
    public void prePersist(){ //antes que se genere la entiedad
        createAt = new Date();
    }
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
}
