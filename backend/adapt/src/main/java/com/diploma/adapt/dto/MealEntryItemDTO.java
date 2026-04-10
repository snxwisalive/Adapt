package com.diploma.adapt.dto;

public record MealEntryItemDTO (
    String productName,
    Double amount,
    Double calories,
    Double protein,
    Double fat,
    Double carbs
) {}