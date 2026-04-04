package com.diploma.adapt.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDTO {
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}