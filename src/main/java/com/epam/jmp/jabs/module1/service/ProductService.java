package com.epam.jmp.jabs.module1.service;

import com.epam.jmp.jabs.module1.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();

    Optional<ProductDTO> findById(Long id);

    ProductDTO save(ProductDTO product);

    void delete(Long id);

    ProductDTO update(Long id, ProductDTO productDetails);
}