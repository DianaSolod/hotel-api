package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Schema(description = "Request for creating a hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequestDto {

    @Schema(description = "Hotel name", example = "DoubleTree by Hilton Minsk", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String name;

    @Schema(description = "Hotel description", example = "The DoubleTree by Hilton Hotel Minsk offers luxurious rooms...")
    String description;

    @Schema(description = "Hotel brand", example = "Hilton", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String brand;

    @Schema(description = "Hotel address")
    @NotNull
    @Valid
    AddressDto address;

    @Schema(description = "Hotel contact information")
    @NotNull
    @Valid
    ContactsDto contacts;

    @Schema(description = "Check-in and check-out information")
    @NotNull
    @Valid
    ArrivalTimeDto arrivalTime;
}