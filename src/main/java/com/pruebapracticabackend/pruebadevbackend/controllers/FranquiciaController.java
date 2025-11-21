package com.pruebapracticabackend.pruebadevbackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapracticabackend.pruebadevbackend.mapper.FranquiciaMapper;
import com.pruebapracticabackend.pruebadevbackend.mapper.SucursalMapper;
import com.pruebapracticabackend.pruebadevbackend.models.Franquicia;
import com.pruebapracticabackend.pruebadevbackend.models.Sucursal;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.FranquiciaRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.FranquiciaResponseDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoMaxStockDTO;
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.SucursalRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.services.FranquiciaService;
import com.pruebapracticabackend.pruebadevbackend.services.ProductoService;
import com.pruebapracticabackend.pruebadevbackend.services.SucursalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@Tag(name = "Franquicias", description = "API para gestión de franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;
    private final SucursalService sucursalService;
    private final FranquiciaMapper franquiciaMapper;
    private final SucursalMapper sucursalMapper;
    private final ProductoService productoService;

    @Autowired
    public FranquiciaController(FranquiciaService franquiciaService, FranquiciaMapper franquiciaMapper,
            SucursalService sucursalService, SucursalMapper sucursalMapper, ProductoService productoService) {
        this.franquiciaService = franquiciaService;
        this.franquiciaMapper = franquiciaMapper;
        this.sucursalService = sucursalService;
        this.sucursalMapper = sucursalMapper;
        this.productoService = productoService;
    }

    @Operation(summary = "Obtener todas las franquicias")
    @GetMapping("/franquicias")
    public ResponseEntity<List<Franquicia>> listaFranquicias() {
        List<Franquicia> listfFranquicias = franquiciaService.listarFranquicias();
        return ResponseEntity.status(HttpStatus.OK).body(listfFranquicias);
    }

    @Operation(summary = "Crear nueva franquicia")
    @PostMapping("/franquicias")
    public ResponseEntity<FranquiciaResponseDTO> crearFranquicia(
            @Valid @RequestBody FranquiciaRequestDTO FranquiciaRequestDTO) {
        Franquicia nuevaFranquicia = franquiciaService.crearFranquicia(franquiciaMapper.toEntity(FranquiciaRequestDTO));
        FranquiciaResponseDTO responseDTO = franquiciaMapper.toDTO(nuevaFranquicia);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Agregar sucursal a franquicia")
    @PostMapping("/franquicias/{franquiciaId}/sucursales")
    public ResponseEntity<FranquiciaResponseDTO> agregarSucursal(@PathVariable Long franquiciaId,
            @Valid @RequestBody SucursalRequestDTO requestDTO) {

        Franquicia franquiciaActualizada = sucursalService.agregarSucursalAFranquicia(
                franquiciaId,
                sucursalMapper.toEntity(requestDTO));

        return ResponseEntity.status(HttpStatus.OK)
                .body(franquiciaMapper.toDTO(franquiciaActualizada));
    }

    @Operation(summary = "Obtener productos con máximo stock por sucursal")
    @GetMapping("/franquicias/{franquiciaId}/mstock")
    public ResponseEntity<List<ProductoMaxStockDTO>> getProductosMaxStock(
            @PathVariable Long franquiciaId) {

        List<ProductoMaxStockDTO> resultado = productoService.productosMaxStockPorSucursal(franquiciaId);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Actualizar nombre de franquicia")
    @PatchMapping("/franquicias/{franquiciaId}/nombre")
    public ResponseEntity<FranquiciaResponseDTO> actualizarNombreFranquicia(
            @PathVariable Long franquiciaId,
            @Valid @RequestBody Map<String, String> request) {

        String nuevoNombre = request.get("nuevoNombre");
        Franquicia franquiciaActualizada = franquiciaService.actualizarNombreFranquicia(franquiciaId, nuevoNombre);
        FranquiciaResponseDTO responseDTO = franquiciaMapper.toDTO(franquiciaActualizada);

        return ResponseEntity.ok(responseDTO);
    }

}
