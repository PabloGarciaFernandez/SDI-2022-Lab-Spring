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

    @RequestMapping("/professor/editar/{id}")
    public String getEdit(@PathVariable Long id) {

        return "Edit professor " + profesorService.getProfesor(id).toString();
    }

    @RequestMapping("/professor/list")
    public String getList() {

        return profesorService.getProfesors().toString();
    }

    @RequestMapping("/professor/add")
    public String setProfesor() {
        return "Adding Professor";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return profesorService.getProfesor(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String delete(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return "Deleting Professor";
    }
}
