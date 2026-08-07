package com.springboot.springbootproject.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.springbootproject.model.Curriculum;


@RestController
@RequestMapping("/curriculum")
@CrossOrigin(origins = "*")

public class Curriculum_api {

    @GetMapping
    public Curriculum obtenerCampo() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Reads the curriculum.json file from the src/main/resources folder
        InputStream input = getClass()
                .getClassLoader() // busca archivos dentro del proyecto
                .getResourceAsStream("curriculum.json"); // se recibe el archivo a leer

        if (input == null) {
            throw new IOException("File 'curriculum.json' not found in resources.");
        }

        return mapper.readValue(input, Curriculum.class); //lee el contenido del archivo, el archivo que acabo de leer
        // luego manda el contenido a la clase
    }

    @PutMapping
    //Los datos que se envian desde el body de la peticion deben convertirse en un objeto tipo Curriculum
    public Curriculum editarCampo(@RequestBody Curriculum cambios) throws IOException {

        Curriculum curriculum = obtenerCampo();

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

        // de objetos java a json
        ObjectMapper mapper = new ObjectMapper();
    
        // Con "src/main/resources/curriculum.json" le decimos a Java que busque el archivo real en tu disco duro
        java.io.File file = new java.io.File("src/main/resources/curriculum.json");
    
        // Guardamos los cambios físicamente escribiendo en el archivo
        mapper.writeValue(file, curriculum);

        return curriculum;
    }

    @PostMapping()
    public String crearCampo(@RequestBody Curriculum curriculum) throws IOException {
    
    // Creamos una lista para guardar los nombres de los campos vacíos
        List<String> vacios = new ArrayList<>();

    // 2. Revisamos cada campo
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

    // Si la lista tiene elementos, significa que faltaron campos
        if (!vacios.isEmpty()) {
            return "Los siguientes campos están vacíos:\n- " + String.join("\n- ", vacios);
        }

    // Si todo está lleno, guardamos el archivo
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/curriculum.json");
        mapper.writeValue(file, curriculum);

        return "Curriculum guardado correctamente.";
        }

    @DeleteMapping
    public String eliminarCampo() {

        // Con "src/main/resources/curriculum.json" le decimos a Java que busque el archivo real en tu disco duro
        java.io.File file = new java.io.File("src/main/resources/curriculum.json");

        if(file.exists()){
            if(file.delete()){
                return "El curriculum ha sido eliminado exitosamente";
            }
        }else{
            return "No se pudo eliminar el archivo";
        }

        return "No hay curriculum para eliminar";
    }
    
}