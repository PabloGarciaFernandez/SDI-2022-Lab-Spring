package com.uniovi.sdi21221008spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profesor {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String categoria;

    public Profesor(String dni, String nombre, String apellidos, String categoria, Long id) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.categoria = categoria;
        this.id = id;
    }

    public Profesor(){}

    @Override
    public String toString() {
        return "Profesor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }
}
