package com.pruebapracticabackend.pruebadevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebapracticabackend.pruebadevbackend.models.Franquicia;

public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {

    boolean existsByNombreFranquicia(String nombreFranquicia);

}
