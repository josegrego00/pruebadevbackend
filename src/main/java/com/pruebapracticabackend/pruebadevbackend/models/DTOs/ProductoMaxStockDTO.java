package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

public class ProductoMaxStockDTO {

    private String sucursal;
    private String producto;
    private Double stock;

    public ProductoMaxStockDTO() {
    }

    public ProductoMaxStockDTO(String sucursal, String producto, Double stock) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.stock = stock;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

}