package com.pruebapracticabackend.pruebadevbackend.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.pruebapracticabackend.pruebadevbackend.models.Sucursal;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.SucursalRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.SucursalResponseDTO;

@Component
public class SucursalMapper {
    
    public Sucursal toEntity(SucursalRequestDTO dto) {
        Sucursal entity = new Sucursal();
        entity.setNombreSucursal(dto.getNombreSucursal());
        return entity;
    }
    
    public SucursalResponseDTO toDTO(Sucursal entity) {
        SucursalResponseDTO dto = new SucursalResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombreSucursal());
        dto.setProductos(new ArrayList<>()); // vacío inicialmente
        return dto;
    }
}