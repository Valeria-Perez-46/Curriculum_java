package com.springboot.springbootproject;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/hola")
    public Map<String, String> obtenerMensaje() {
        // 1. Creamos una estructura de datos vacía (un mapa)
        Map<String, String> respuesta = new HashMap<>();
        
        // 2. Guardamos nuestro dato con una "llave" y un "valor"
        respuesta.put("mensaje", "Hola Mundo desde Spring Boot");
        
        // 3. Al retornar la estructura, Spring Boot la convierte en JSON real
        return respuesta;
    }
}