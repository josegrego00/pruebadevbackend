package com.pruebapracticabackend.pruebadevbackend.mapper;

import org.springframework.stereotype.Component;

import com.pruebapracticabackend.pruebadevbackend.models.Producto;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoResponseDTO;

@Component
public class ProductoMapper {
    
    public Producto toEntity(ProductoRequestDTO dto) {
        Producto entity = new Producto();
        entity.setNombreProducto(dto.getNombre());
        entity.setStock(dto.getStock());
        return entity;
    }
    
    public ProductoResponseDTO toDTO(Producto entity) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombreProducto());
        dto.setStock(entity.getStock());
        dto.setSucursal(null); // solo el ID
        return dto;
    }
}