package com.pruebapracticabackend.pruebadevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebapracticabackend.pruebadevbackend.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
