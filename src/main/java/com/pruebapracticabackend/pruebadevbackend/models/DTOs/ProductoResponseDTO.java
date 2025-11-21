package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private Double stock;
    private SucursalResponseDTO sucursal;

    public ProductoResponseDTO() {
    }

    public ProductoResponseDTO(String nombre, Double stock, SucursalResponseDTO sucursal) {
        this.nombre = nombre;
        this.stock = stock;
        this.sucursal = sucursal;
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

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public SucursalResponseDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalResponseDTO sucursal) {
        this.sucursal = sucursal;
    }

}
