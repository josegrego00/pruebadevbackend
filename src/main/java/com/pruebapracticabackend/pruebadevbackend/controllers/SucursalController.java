package com.pruebapracticabackend.pruebadevbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapracticabackend.pruebadevbackend.mapper.ProductoMapper;
import com.pruebapracticabackend.pruebadevbackend.mapper.SucursalMapper;
import com.pruebapracticabackend.pruebadevbackend.models.Sucursal;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.SucursalResponseDTO;
import com.pruebapracticabackend.pruebadevbackend.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "Sucursales", description = "API para gestión de sucursales")
public class SucursalController {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;
    private final SucursalMapper sucursalMapper;

    public SucursalController(ProductoService productoService, ProductoMapper productoMapper,
            SucursalMapper sucursalMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
        this.sucursalMapper = sucursalMapper;
    }

    
    @Operation(summary = "Agregar producto a sucursal")
    @PostMapping("/sucursales/{sucursalId}/productos")
    public ResponseEntity<SucursalResponseDTO> agregarProducto(
            @PathVariable Long sucursalId,
            @Valid @RequestBody ProductoRequestDTO requestDTO) {

        Sucursal sucursalActualizada = productoService.agregarProductoASucursal(
                sucursalId,
                productoMapper.toEntity(requestDTO));

        return ResponseEntity.status(HttpStatus.OK)
                .body(sucursalMapper.toDTO(sucursalActualizada));
    }

    @Operation(summary = "Eliminar producto de sucursal")
    @DeleteMapping("/sucursales/{sucursalId}/productos/{productoId}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long sucursalId,
            @PathVariable Long productoId) {
        productoService.eliminarProducto(sucursalId, productoId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
