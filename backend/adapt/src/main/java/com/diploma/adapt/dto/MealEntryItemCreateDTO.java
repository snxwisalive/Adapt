package com.diploma.adapt.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

import com.diploma.adapt.model.MealType;

public record MealEntryItemCreateDTO (

    @NotNull
    UUID productId,

    @NotNull
    @Min(1)
    Double amount,

    @NotNull
    LocalDate date,

    @NotNull
    MealType mealType
) {}