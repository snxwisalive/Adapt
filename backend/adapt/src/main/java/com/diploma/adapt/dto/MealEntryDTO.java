package com.diploma.adapt.dto;

import java.util.List;

import com.diploma.adapt.model.MealType;

public record MealEntryDTO (
    Double calories,
    Double protein,
    Double fat,
    Double carbs,
    MealType mealType,
    List<MealEntryItemDTO> product
) {}