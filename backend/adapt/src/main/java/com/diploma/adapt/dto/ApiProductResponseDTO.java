package com.diploma.adapt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiProductResponseDTO (

    @JsonProperty("product_name")
    String productName,

    @JsonProperty("nutriments")
    ApiProductNutrimentsResponseDTO nutriments
) {}