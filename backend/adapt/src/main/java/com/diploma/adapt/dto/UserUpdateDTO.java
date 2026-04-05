package com.diploma.adapt.dto;

import com.diploma.adapt.model.ActivityLevel;
import com.diploma.adapt.model.Gender;
import com.diploma.adapt.model.Goal;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {

    @NotNull
    @Min(1)
    @Max(120)
    private Integer age;

    @NotNull
    @Min(1)
    @Max(300)
    private Integer height;

    @NotNull
    @Min(1)
    @Max(200)
    private Double weight;

    @NotNull
    private Gender gender;

    @NotNull
    private ActivityLevel activityLevel;

    @NotNull
    private Goal goal;
}