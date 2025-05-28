package com.epam.jmp.jabs.module1.service.impl;

import com.epam.jmp.jabs.module1.dto.ProductDTO;
import com.epam.jmp.jabs.module1.mapper.ProductMapper;
import com.epam.jmp.jabs.module1.repository.ProductRepository;
import com.epam.jmp.jabs.module1.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        return Optional.of(productRepository.findAll())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(modelMapper.mapProductToDTO())
                .toList();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(modelMapper.mapProductToDTO());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        final var model = modelMapper.toEntity(productDTO);
        final var savedProduct = productRepository.save(model);
        return modelMapper.toDTO(savedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDetails) {
        final var product = modelMapper.toEntity(productDetails);
        boolean isProductExist = productRepository.existsById(id);
        if (isProductExist) {
            product.setId(id);
        }

        final var updatedProduct = productRepository.save(product);
        return modelMapper.toDTO(updatedProduct);
    }
}