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
import com.pruebapracticabackend.pruebadevbackend.models.DTOs.ProductoRequestDTO;
import com.pruebapracticabackend.pruebadevbackend.repositories.FranquiciaRepository;
import com.pruebapracticabackend.pruebadevbackend.repositories.ProductoRepository;
import com.pruebapracticabackend.pruebadevbackend.repositories.SucursalRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    public ProductoService(ProductoRepository productoRepository, SucursalRepository sucursalRepository,
            FranquiciaRepository franquiciaRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
        this.franquiciaRepository = franquiciaRepository;
    }

    public Sucursal agregarProductoASucursal(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        producto.setSucursal(sucursal);
        Producto productoGuardado = productoRepository.save(producto);
        sucursal.getListaProductosOfertados().add(productoGuardado);

        return sucursalRepository.save(sucursal);
    }

    public Sucursal eliminarProducto(Long sucursalId, Long productoId) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Verificar que el producto pertenece a la sucursal
        if (!producto.getSucursal().getId().equals(sucursalId)) {
            throw new RuntimeException("El producto no pertenece a esta sucursal");
        }

        // Eliminar el producto
        productoRepository.delete(producto);

        // Actualizar la lista (opcional, para consistencia)
        sucursal.getListaProductosOfertados().removeIf(p -> p.getId().equals(productoId));

        return sucursal;
    }

    public Producto actualizarStock(Long productoId, ProductoRequestDTO nuevoStock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setStock(nuevoStock.getStock());
        return productoRepository.save(producto);
    }

    public List<ProductoMaxStockDTO> productosMaxStockPorSucursal(Long franquiciaId) {

        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        List<ProductoMaxStockDTO> resultado = new ArrayList<>();

        for (Sucursal sucursal : franquicia.getListaSucursales()) {
            Producto productoMaxStock = null;
            double maxStock = -1;

            for (Producto producto : sucursal.getListaProductosOfertados()) {
                if (producto.getStock() > maxStock) {
                    maxStock = producto.getStock();
                    productoMaxStock = producto;
                }
            }

            ProductoMaxStockDTO dto = new ProductoMaxStockDTO();
            dto.setSucursal(sucursal.getNombreSucursal());
            dto.setProducto(productoMaxStock != null ? productoMaxStock.getNombreProducto() : "Sin productos");
            dto.setStock(productoMaxStock != null ? productoMaxStock.getStock() : 0);
            logger.info("Actualizando stock del producto ");
            resultado.add(dto);
        }

        return resultado;
    }
}