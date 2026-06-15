package com.example.propertyview.service;

import com.example.propertyview.dto.HotelRequestDto;
import com.example.propertyview.dto.HotelResponseDto;
import com.example.propertyview.dto.HotelSearchDto;
import com.example.propertyview.dto.HotelShortResponseDto;
import com.example.propertyview.enums.HistogramParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface HotelService {
    List<HotelShortResponseDto> getAll();

    HotelResponseDto getById(Long id);

    List<HotelShortResponseDto> search(HotelSearchDto filter);

    HotelShortResponseDto addHotel(HotelRequestDto dto);

    @Transactional
    void addAmenities(Long id, List<String> amenities);

    Map<String, Long> getHistogram(HistogramParam param);
}
