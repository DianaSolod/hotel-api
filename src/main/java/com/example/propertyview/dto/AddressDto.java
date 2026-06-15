package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Schema(description = "Hotel address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {

    @Schema(description = "Building number", example = "9", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    String houseNumber;

    @Schema(description = "Street name", example = "Pobediteley Avenue", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String street;

    @Schema(description = "City", example = "Minsk", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String city;

    @Schema(description = "Country", example = "Belarus", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String country;

    @Schema(description = "Postal code", example = "220004", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String postCode;
}