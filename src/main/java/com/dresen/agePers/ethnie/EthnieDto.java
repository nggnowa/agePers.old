package com.dresen.agePers.ethnie;


import jakarta.validation.constraints.NotBlank;

public record EthnieDto(
        Long id,
        @NotBlank
        String nom
) {

}
