package com.epam.jmp.jabs.module1.repository;

import com.epam.jmp.jabs.module1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}