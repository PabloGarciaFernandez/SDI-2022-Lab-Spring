package com.uniovi.sdi21221008spring.repositories;

import com.uniovi.sdi21221008spring.entities.Mark;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MarksRepository extends CrudRepository<Mark, Long>{
}
