package com.uniovi.sdi21221008spring.repositories;

import com.uniovi.sdi21221008spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
