package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

import java.util.List;

public class SucursalResponseDTO {

    private Long id;
    private String nombre;
    private FranquiciaResponseDTO nombreFranquicia;
    private List<ProductoResponseDTO> productos;

    public SucursalResponseDTO() {
    }

    public SucursalResponseDTO(String nombre, FranquiciaResponseDTO nombreFranquicia,
            List<ProductoResponseDTO> productos) {
        this.nombre = nombre;
        this.nombreFranquicia = nombreFranquicia;
        this.productos = productos;
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

    public FranquiciaResponseDTO getNombreFranquicia() {
        return nombreFranquicia;
    }

    public void setNombreFranquicia(FranquiciaResponseDTO nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public List<ProductoResponseDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoResponseDTO> productos) {
        this.productos = productos;
    }

}
