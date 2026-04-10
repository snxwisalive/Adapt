package com.diploma.adapt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiResponseDTO (

    @JsonProperty("products")
    List<ApiProductResponseDTO> products
) {}