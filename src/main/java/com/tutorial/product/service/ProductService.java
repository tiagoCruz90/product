package com.tutorial.product.service;

import com.tutorial.product.dto.ProductRequestDTO;
import com.tutorial.product.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();
}
