package com.tutorial.product.service.impl;

import com.tutorial.product.domain.Product;
import com.tutorial.product.dto.ProductRequestDTO;
import com.tutorial.product.dto.ProductResponseDTO;
import com.tutorial.product.repository.ProductRepository;
import com.tutorial.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} created successfully", product.getId());
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products =  productRepository.findAll();

        return products.stream().map(product -> ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build()).toList();
    }
}
