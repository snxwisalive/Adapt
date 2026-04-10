package com.diploma.adapt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiProductNutrimentsResponseDTO (

    @JsonProperty("energy-kcal_100g")
    Double calories,

    @JsonProperty("proteins_100g")
    Double protein,

    @JsonProperty("fat_100g")
    Double fat,

    @JsonProperty("carbohydrates_100g")
    Double carbs
) {}