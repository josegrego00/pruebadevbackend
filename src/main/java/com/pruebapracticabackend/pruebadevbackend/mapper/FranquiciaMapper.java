package com.pruebapracticabackend.pruebadevbackend.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.pruebapracticabackend.pruebadevbackend.models.Franquicia;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.FranquiciaRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.FranquiciaResponseDTO;

@Component
public class FranquiciaMapper {
    
    public Franquicia toEntity(FranquiciaRequestDTO requestDTO) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombreFranquicia(requestDTO.getNombreFanquicia());
        return franquicia;
    }
    
    public FranquiciaResponseDTO toDTO(Franquicia entity) {
        FranquiciaResponseDTO dto = new FranquiciaResponseDTO();
        dto.setId(entity.getId());
        dto.setNombreFranquicia(entity.getNombreFranquicia());
        dto.setListaSucursales(new ArrayList<>());
        return dto;
    }
}