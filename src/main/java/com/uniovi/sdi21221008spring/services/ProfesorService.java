package com.uniovi.sdi21221008spring.services;

import com.uniovi.sdi21221008spring.entities.Profesor;
import com.uniovi.sdi21221008spring.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    private List<Profesor> profesors= new ArrayList<Profesor>();

    @PostConstruct
    public void init(){
        profesors.add(new Profesor("19293","Pablo","Garcia","ingles",1L));
        profesors.add(new Profesor("12213123","Alberto","Garcia","ingles",2L));
    }

    public List<Profesor> getProfesors() {
        return profesors;
    }

    public Profesor getProfesor(Long id) {
        return profesors.stream() .filter(profesor -> profesor.getId().equals(id)).findFirst().get();
    }

    public void addProfesor(Profesor profesor) {
        profesors.add(profesor);
    }

    public void deleteProfesor(Long id) {
        profesors.removeIf(profesor -> profesor.getId().equals(id));
    }
}
