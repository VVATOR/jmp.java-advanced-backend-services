package com.epam.jmp.jabs.module1.mapper.impl;

import com.epam.jmp.jabs.module1.dto.ProductDTO;
import com.epam.jmp.jabs.module1.entity.Product;
import com.epam.jmp.jabs.module1.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ModelMapperProductMapper implements ProductMapper {
    private final ModelMapper modelMapper;

    public ModelMapperProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO toDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public Function<ProductDTO, Product> mapDtoToProduct() {
        return product -> modelMapper.map(product, Product.class);
    }

    public Function<Product, ProductDTO> mapProductToDTO() {
        return product -> modelMapper.map(product, ProductDTO.class);
    }
}