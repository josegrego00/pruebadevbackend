package com.pruebapracticabackend.pruebadevbackend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreSucursal;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    @JsonIgnore
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal")
    private List<Producto> listaProductosOfertados;

    public Sucursal() {
    }

    public Sucursal(String nombreSucursal, Franquicia franquicia, List<Producto> listaProductosOfertados) {
        this.nombreSucursal = nombreSucursal;
        this.franquicia = franquicia;
        this.listaProductosOfertados = listaProductosOfertados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public List<Producto> getListaProductosOfertados() {
        return listaProductosOfertados;
    }

    public void setListaProductosOfertados(List<Producto> listaProductosOfertados) {
        this.listaProductosOfertados = listaProductosOfertados;
    }

}
