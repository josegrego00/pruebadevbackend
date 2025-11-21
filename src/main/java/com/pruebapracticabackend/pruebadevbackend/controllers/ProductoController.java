package com.pruebapracticabackend.pruebadevbackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapracticabackend.pruebadevbackend.mapper.ProductoMapper;
import com.pruebapracticabackend.pruebadevbackend.models.Producto;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoResponseDTO;
import com.pruebapracticabackend.pruebadevbackend.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    @Autowired
    public ProductoController(ProductoService productoService, ProductoMapper productoMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }

    
    @Operation(summary = "Actualizar stock de producto")
    @PutMapping("/productos/{productoId}/stock")
    public ResponseEntity<ProductoResponseDTO> modificarStock(
            @PathVariable Long productoId,
            @RequestBody ProductoRequestDTO requestDTO) {

        Producto productoActualizado = productoService.actualizarStock(
                productoId,
                requestDTO);

        return ResponseEntity.ok(productoMapper.toDTO(productoActualizado));
    }
}
