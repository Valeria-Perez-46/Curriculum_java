package com.springboot.springbootproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.springbootproject.model.Curriculum;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Curriculum_api {

    // Método auxiliar para leer el JSON sin romper la respuesta HTTP
    private Curriculum cargarCurriculumDesdeResource() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Ignora campos del JSON que no coincidan 1:1 con la clase Java para evitar errores 500
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ClassPathResource resource = new ClassPathResource("curriculum.json");
        return mapper.readValue(resource.getInputStream(), Curriculum.class);
    }

    @GetMapping
    public ResponseEntity<?> obtenerCampo() {
        try {
            Curriculum curriculum = cargarCurriculumDesdeResource();
            return ResponseEntity.ok(curriculum);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al leer 'curriculum.json': " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarCampo(@RequestBody Curriculum cambios) {
        try {
            Curriculum curriculum = cargarCurriculumDesdeResource();

            curriculum.setNombre(cambios.getNombre());
            curriculum.setPuesto(cambios.getPuesto());
            curriculum.setPerfil(cambios.getPerfil());
            curriculum.setTelefono(cambios.getTelefono());
            curriculum.setCorreo(cambios.getCorreo());
            curriculum.setSitio(cambios.getSitio());
            curriculum.setHabilidades(cambios.getHabilidades());
            curriculum.setIdiomas(cambios.getIdiomas());
            curriculum.setEducacion(cambios.getEducacion());
            curriculum.setPeriodo1(cambios.getPeriodo1());
            curriculum.setEmpresa1(cambios.getEmpresa1());
            curriculum.setDescripcion1(cambios.getDescripcion1());

            return ResponseEntity.ok(curriculum);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar los datos: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> crearCampo(@RequestBody Curriculum curriculum) {
        List<String> vacios = new ArrayList<>();

        if (curriculum.getNombre() == null || curriculum.getNombre().isBlank()) vacios.add("Nombre");
        if (curriculum.getPuesto() == null || curriculum.getPuesto().isBlank()) vacios.add("Puesto");
        if (curriculum.getPerfil() == null || curriculum.getPerfil().isBlank()) vacios.add("Perfil");
        if (curriculum.getTelefono() == null || curriculum.getTelefono().isBlank()) vacios.add("Teléfono");
        if (curriculum.getCorreo() == null || curriculum.getCorreo().isBlank()) vacios.add("Correo");
        if (curriculum.getSitio() == null || curriculum.getSitio().isBlank()) vacios.add("Sitio web");
        if (curriculum.getHabilidades() == null || curriculum.getHabilidades().isBlank()) vacios.add("Habilidades");
        if (curriculum.getIdiomas() == null || curriculum.getIdiomas().isBlank()) vacios.add("Idiomas");
        if (curriculum.getEducacion() == null || curriculum.getEducacion().isBlank()) vacios.add("Educación");
        if (curriculum.getPeriodo1() == null || curriculum.getPeriodo1().isBlank()) vacios.add("Periodo laboral");
        if (curriculum.getEmpresa1() == null || curriculum.getEmpresa1().isBlank()) vacios.add("Empresa");
        if (curriculum.getDescripcion1() == null || curriculum.getDescripcion1().isBlank()) vacios.add("Descripción de experiencia");

        if (!vacios.isEmpty()) {
            return ResponseEntity.badRequest().body("Los siguientes campos están vacíos:\n- " + String.join("\n- ", vacios));
        }

        return ResponseEntity.ok("Curriculum validado correctamente.");
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarCampo() {
        return ResponseEntity.ok("El registro ha sido procesado.");
    }
}