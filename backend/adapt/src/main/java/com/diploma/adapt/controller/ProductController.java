package com.diploma.adapt.controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diploma.adapt.dto.ProductCreateDTO;
import com.diploma.adapt.dto.ProductDTO;
import com.diploma.adapt.dto.ProductUpdateDTO;
import com.diploma.adapt.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public List<ProductDTO> searchProduct(@RequestParam String query) {
        return productService.searchProduct(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody @Valid ProductCreateDTO dto, Principal principal) {
        return productService.createProduct(dto, principal.getName());
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody @Valid ProductUpdateDTO dto, @PathVariable UUID id, Principal principal) {
        return productService.updateProduct(dto, id, principal.getName());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable UUID id, Principal principal) {
        productService.deleteProduct(id, principal.getName());
    }
}