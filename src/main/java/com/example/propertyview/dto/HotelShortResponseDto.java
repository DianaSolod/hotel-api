package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Schema(description = "Short hotel information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelShortResponseDto {

    @Schema(description = "Hotel identifier", example = "1")
    Long id;

    @Schema(description = "Hotel name", example = "DoubleTree by Hilton Minsk")
    String name;

    @Schema(description = "Hotel description", example = "The DoubleTree by Hilton Hotel Minsk offers luxurious rooms...")
    String description;

    @Schema(description = "Full hotel address", example = "9 Pobediteley Avenue, Minsk, 220004, Belarus")
    String address;

    @Schema(description = "Phone number", example = "+375 17 309-80-00")
    String phone;
}