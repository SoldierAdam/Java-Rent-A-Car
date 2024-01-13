package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsById(int id);
    boolean existsByName(String name);
}
