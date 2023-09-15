package com.h2.h2.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/")
    public String showMessage(){
        return "Bienvenido a la Liberia de Libros Online";
    }

    @GetMapping("/user/books")
    public List<String> showBooks(){
        return Arrays.asList("Cien años de soledad", "Moby Dick", "Don Quijote de la Mancha");
    }

    @GetMapping("/admin/books")
    public String addBook(){
        return "Libro agregado!";
    }
}
