package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Schema(description = "Check-in and check-out times")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrivalTimeDto {

    @Schema(description = "Check-in time", example = "14:00", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    LocalTime checkIn;

    @Schema(description = "Check-out time", example = "12:00")
    LocalTime checkOut;
}