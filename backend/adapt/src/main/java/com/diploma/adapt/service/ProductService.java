package com.diploma.adapt.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Stream;

import com.diploma.adapt.repository.ProductRepository;
import com.diploma.adapt.repository.UserRepository;
import com.diploma.adapt.dto.ProductCreateDTO;
import com.diploma.adapt.dto.ProductDTO;
import com.diploma.adapt.dto.ProductUpdateDTO;
import com.diploma.adapt.mapper.ProductMapper;
import com.diploma.adapt.model.Product;
import com.diploma.adapt.model.ProductSource;
import com.diploma.adapt.model.User;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserRepository userRepository;
    private final ProductSearchService productSearchService;

    public ProductService (
        ProductRepository productRepository,
        ProductMapper productMapper,
        UserRepository userRepository,
        ProductSearchService productSearchService) {

        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepository = userRepository;
        this.productSearchService = productSearchService;
    }

    public List<ProductDTO> searchProduct(String query) {
        List<ProductDTO> localProducts = productRepository.findByProductNameContainingIgnoreCase(query).stream()
                    .map(productMapper::toProductDTO)
                    .toList();
        
        List<ProductDTO> externalProducts = productSearchService.searchProducts(query);

        return Stream.concat(localProducts.stream(), externalProducts.stream()).toList();
    }

    public ProductDTO createProduct(ProductCreateDTO dto, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));

        Product product = productMapper.toProduct(dto);
        product.setCreatedBy(user);
        
        if (product.getExternalId() != null && !product.getExternalId().isBlank()) {
            product.setSource(ProductSource.EXTERNAL);
        } else {
            product.setSource(ProductSource.CUSTOM);
        }

        Product saved = productRepository.save(product);

        return productMapper.toProductDTO(saved);
    }

    public ProductDTO updateProduct(ProductUpdateDTO dto, UUID id, String username) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));

        if (product.getCreatedBy() == null || !username.equals(product.getCreatedBy().getUsername())) {
            throw new AccessDeniedException("You can update only your products");
        }

        productMapper.updateProductFromDto(dto, product);

        Product saved = productRepository.save(product);

        return productMapper.toProductDTO(saved);
    }

    public void deleteProduct(UUID id, String username) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));

        if (product.getCreatedBy() == null || !username.equals(product.getCreatedBy().getUsername())) {
            throw new AccessDeniedException("You can delete only your products");
        }

        productRepository.delete(product);
    }
}