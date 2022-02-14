package com.uniovi.sdi21221008spring.services;

import com.uniovi.sdi21221008spring.entities.Mark;
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

    @PostConstruct
    public void init(){
        profesorRepository.save(new Profesor("19293","Pablo","Garcia","ingles",1L));
        profesorRepository.save(new Profesor("12213123","Alberto","Garcia","ingles",2L));
    }

    public List<Profesor> getProfesors() {
        List<Profesor> profesors = new ArrayList<Profesor>();
        profesorRepository.findAll().forEach(profesors::add);
        return profesors;
    }

    public Profesor getProfesor(Long id) {
        return profesorRepository.findById(id).get();
    }

    public void addProfesor(Profesor profesor) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
