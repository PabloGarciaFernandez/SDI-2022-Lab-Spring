package com.uniovi.sdi21221008spring.controllers;

import com.uniovi.sdi21221008spring.entities.Profesor;
import com.uniovi.sdi21221008spring.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @RequestMapping("/profesor/editar/{id}")
    public String getEdit(@PathVariable Long id) {

        return "Edit profesor " + profesorService.getProfesor(id).toString();
    }

    @RequestMapping("/profesor/list")
    public String getList() {

        return profesorService.getProfesors().toString();
    }

    @RequestMapping("/profesor/add")
    public String setProfesor() {
        return "Adding Profesor";
    }

    @RequestMapping("/profesor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return profesorService.getProfesor(id).toString();
    }

    @RequestMapping("/profesor/delete/{id}")
    public String delete(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return "Deleting Professor";
    }
}
