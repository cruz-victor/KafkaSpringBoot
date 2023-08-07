package com.ubicuosoft.postgres.repository;

import com.ubicuosoft.postgres.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Métodos personalizados, si los necesitas
}