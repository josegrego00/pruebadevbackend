package com.pruebapracticabackend.pruebadevbackend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebapracticabackend.pruebadevbackend.models.Franquicia;
import com.pruebapracticabackend.pruebadevbackend.repositories.FranquiciaRepository;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    private static final Logger logger = LoggerFactory.getLogger(SucursalService.class);

    @Autowired
    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;

    }

    public Franquicia buscarFranquiciasPorId(Long id) {
        return franquiciaRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe la Franquicia"));
    }

    public Franquicia crearFranquicia(Franquicia franquicia) {
        logger.info("Creando franquicia: {}", franquicia.getNombreFranquicia());
        if (franquiciaRepository.existsByNombreFranquicia(franquicia.getNombreFranquicia())) {
            throw new RuntimeException("Franquicia ya Existe.");
        }

        logger.debug("Franquicia creada..");
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia actualizarFranquicia(Long id, Franquicia franquiciaActualizada) {

        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró franquicia a actualizar"));

        franquicia.setListaSucursales(franquiciaActualizada.getListaSucursales());
        franquicia.setNombreFranquicia(franquiciaActualizada.getNombreFranquicia());

        return franquiciaRepository.save(franquicia);
    }

    public void borrarFranquicia(Long id) {

        franquiciaRepository.deleteById(id);
    }

    public List<Franquicia> listarFranquicias() {
        return franquiciaRepository.findAll();
    }

    public Franquicia actualizarNombreFranquicia(Long franquiciaId, String nuevoNombre) {
        logger.info("Actualizando nombre de Franquicia");
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        franquicia.setNombreFranquicia(nuevoNombre);
        return franquiciaRepository.save(franquicia);
    }
}
