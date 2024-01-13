package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    boolean existsByName(String name);
}
