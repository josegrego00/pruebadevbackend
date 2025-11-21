package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductoRequestDTO {
    
    @NotBlank
    private String nombre;
    private Double stock;
    private Long sucursalId;
    
    public ProductoRequestDTO() {
    }

    public ProductoRequestDTO(@NotBlank String nombre, Double stock, Long sucursalId) {
        this.nombre = nombre;
        this.stock = stock;
        this.sucursalId = sucursalId;
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
    public Long getSucursalId() {
        return sucursalId;
    }
    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }

    
   
}
