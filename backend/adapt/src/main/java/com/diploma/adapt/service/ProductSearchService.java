package com.diploma.adapt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diploma.adapt.dto.ApiResponseDTO;
import com.diploma.adapt.dto.ProductDTO;
import com.diploma.adapt.external.OpenFoodFactsClient;
import com.diploma.adapt.mapper.ExternalProductMapper;

@Service
public class ProductSearchService {
    private final OpenFoodFactsClient openFoodFactsClient;
    private final ExternalProductMapper externalProductMapper;

    public ProductSearchService(OpenFoodFactsClient openFoodFactsClient, ExternalProductMapper externalProductMapper) {
        this.openFoodFactsClient = openFoodFactsClient;
        this.externalProductMapper = externalProductMapper;
    }

    public List<ProductDTO> searchProducts(String query) {
        ApiResponseDTO rawData = openFoodFactsClient.searchProducts(query);

        List<ProductDTO> productDTOs = rawData.products().stream().map(externalProductMapper::toProductDTO).toList();

        return productDTOs;
    }
}