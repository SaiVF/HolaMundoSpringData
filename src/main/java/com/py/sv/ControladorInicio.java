package com.py.sv;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Hola mundo con Thymeleaf";

        var persona = new Persona();
        persona.setNombre("Santiago");
        persona.setApellido("Vargas");
        persona.setEmail("sai19.sv@gmail.com");
        persona.setTelefono("0971621089");

        var persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Perez");
        persona2.setEmail("jperez@gmail.com");
        persona2.setTelefono("0972622029");

//        List<Persona> personas = new ArrayList();
//        var personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);

        var personas = Arrays.asList(persona, persona2);
//        var personas = Arrays.asList();

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo",saludo);
//        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        log.info("ejecutando el controlador Spring MVC");
        return "index";
    }
}