package com.diploma.adapt.dto;

import jakarta.validation.constraints.*;

public record MealEntryItemUpdateDTO (

    @NotNull
    @Min(1)
    Double amount
) {}