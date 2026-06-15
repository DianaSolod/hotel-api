package com.example.propertyview.controller;

import com.example.propertyview.dto.HotelRequestDto;
import com.example.propertyview.dto.HotelResponseDto;
import com.example.propertyview.dto.HotelSearchDto;
import com.example.propertyview.dto.HotelShortResponseDto;
import com.example.propertyview.enums.HistogramParam;
import com.example.propertyview.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Hotels", description = "Hotel management API")
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HotelController {

    HotelService hotelService;

    @Operation(summary = "Get all hotels")
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelShortResponseDto>> getAll() {
        return ResponseEntity.ok(hotelService.getAll());
    }

    @Operation(summary = "Get hotel by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel found"),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    @GetMapping("/hotels/{id}")
    public ResponseEntity<HotelResponseDto> getById(
            @Parameter(description = "Hotel id", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok(hotelService.getById(id));
    }

    @Operation(summary = "Search hotels")
    @GetMapping("/search")
    public List<HotelShortResponseDto> search(
            @Parameter(description = "Hotel name", example = "Hilton")
            @ModelAttribute HotelSearchDto filter) {
        return hotelService.search(filter);
    }

    @Operation(summary = "Create hotel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel successfully created"),
            @ApiResponse(responseCode = "400", description = "Data validation error")
    })
    @PostMapping("/hotels")
    public ResponseEntity<HotelShortResponseDto> addHotel(@Valid @RequestBody HotelRequestDto dto){
        return ResponseEntity.ok(hotelService.addHotel(dto));
    }

    @Operation(summary = "Add amenities to hotel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Amenities added"),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    @PostMapping("/hotels/{id}/amenities")
    public void addAmenities(
            @Parameter(description = "Hotel id", example = "1")
            @PathVariable Long id,
            @RequestBody List<String> amenities){
        hotelService.addAmenities(id, amenities);
    }

    @Operation(
            summary = "Get histogram",
            description = "Returns the number of hotels grouped by the specified parameter"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Histogram successfully created"),
            @ApiResponse(responseCode = "400", description = "Wrong parameter")
    })
    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Long>> getHistogram(
            @Parameter(description = "Histogram parameter: brand, city, country, amenities", example = "city")
            @PathVariable String param){
        return ResponseEntity.ok(hotelService.getHistogram(HistogramParam.fromValue(param)));
    }
}
