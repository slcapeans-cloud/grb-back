package com.example.grb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        int[] hola = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int j : hola) {
            System.out.println(j);
        }
        return "Hola Mundo";
    }

}
