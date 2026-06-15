package com.example.propertyview.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Schema(description = "Hotel contact information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactsDto {

    @Schema(description = "Phone number", example = "+375 17 309-80-00", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    String phone;

    @Schema(description = "Email address", example = "doubletreeminsk.info@hilton.com", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Email
    String email;
}