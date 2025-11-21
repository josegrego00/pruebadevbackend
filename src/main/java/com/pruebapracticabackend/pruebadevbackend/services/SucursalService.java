package com.pruebapracticabackend.pruebadevbackend.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebapracticabackend.pruebadevbackend.models.Franquicia;
import com.pruebapracticabackend.pruebadevbackend.models.Producto;
import com.pruebapracticabackend.pruebadevbackend.models.Sucursal;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoMaxStockDTO;
import com.pruebapracticabackend.pruebadevbackend.repositories.FranquiciaRepository;
import com.pruebapracticabackend.pruebadevbackend.repositories.SucursalRepository;

@Service
public class SucursalService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    private static final Logger logger = LoggerFactory.getLogger(SucursalService.class);

    @Autowired
    public SucursalService(FranquiciaRepository franquiciaRepository,
            SucursalRepository sucursalRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public Franquicia agregarSucursalAFranquicia(Long franquiciaId, Sucursal sucursal) {
        logger.info("Agregando sucursal {} a franquicia {}", sucursal.getNombreSucursal(), franquiciaId);
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        // Asignar relación
        sucursal.setFranquicia(franquicia);

        // GUARDAR la sucursal primero
        Sucursal sucursalGuardada = sucursalRepository.save(sucursal);

        // Agregar a la lista
        franquicia.getListaSucursales().add(sucursalGuardada);

        return franquiciaRepository.save(franquicia);
    }

}