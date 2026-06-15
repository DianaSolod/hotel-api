package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelSearchDto {

    @Schema(description = "Hotel name", example = "Hilton")
    String name;

    @Schema(description = "Hotel brand", example = "Hilton")
    String brand;

    @Schema(description = "City", example = "Minsk")
    String city;

    @Schema(description = "Country", example = "Belarus")
    String country;

    @Schema(description = "Amenity", example = "Free WiFi")
    String amenities;
}