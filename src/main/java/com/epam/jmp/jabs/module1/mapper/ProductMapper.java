package com.epam.jmp.jabs.module1.mapper;

import com.epam.jmp.jabs.module1.dto.ProductDTO;
import com.epam.jmp.jabs.module1.entity.Product;

import java.util.function.Function;

public interface ProductMapper {
    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    Function<ProductDTO, Product> mapDtoToProduct();

    Function<Product, ProductDTO> mapProductToDTO();
}