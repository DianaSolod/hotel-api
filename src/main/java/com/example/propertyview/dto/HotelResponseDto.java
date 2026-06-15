package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Schema(description = "Detailed hotel information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponseDto {

    @Schema(description = "Hotel identifier", example = "1")
    Long id;

    @Schema(description = "Hotel name", example = "DoubleTree by Hilton Minsk")
    String name;

    @Schema(description = "Hotel description", example = "The DoubleTree by Hilton Hotel Minsk offers luxurious rooms...")
    String description;

    @Schema(description = "Hotel brand", example = "Hilton")
    String brand;

    @Schema(description = "Hotel address")
    AddressDto address;

    @Schema(description = "Hotel contact information")
    ContactsDto contacts;

    @Schema(description = "Check-in and check-out information")
    ArrivalTimeDto arrivalTime;

    @Schema(description = "Hotel amenities")
    Set<String> amenities;
}