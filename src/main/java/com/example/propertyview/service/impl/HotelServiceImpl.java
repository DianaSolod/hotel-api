package com.example.propertyview.service.impl;

import com.example.propertyview.dto.*;
import com.example.propertyview.entity.Hotel;
import com.example.propertyview.enums.HistogramParam;
import com.example.propertyview.exception.ResourceNotFoundException;
import com.example.propertyview.mapper.HotelMapper;
import com.example.propertyview.repository.HotelRepository;
import com.example.propertyview.repository.specification.HotelSpecification;
import com.example.propertyview.service.HotelService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HotelServiceImpl implements HotelService {

    HotelRepository hotelRepository;
    HotelMapper hotelMapper;

    @Override
    public List<HotelShortResponseDto> getAll() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toShortDto)
                .toList();
    }

    @Override
    public HotelResponseDto getById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
        return hotelMapper.toDto(hotel);
    }

    @Override
    public List<HotelShortResponseDto> search(HotelSearchDto filter) {
        return hotelRepository.findAll(HotelSpecification.withFilter(filter)).stream()
                .map(hotelMapper::toShortDto)
                .toList();
    }

    @Override
    @Transactional
    public HotelShortResponseDto addHotel(HotelRequestDto dto){
        Hotel hotel = hotelRepository.save(hotelMapper.toEntity(dto));
        return hotelMapper.toShortDto(hotel);
    }

    @Override
    @Transactional
    public void addAmenities(Long id, List<String> amenities){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
        hotel.getAmenities().addAll(amenities);
        hotelRepository.save(hotel);
    }

    @Override
    public Map<String, Long> getHistogram(HistogramParam param) {

        List<HistogramProjection> result = switch (param) {
            case BRAND -> hotelRepository.getBrandHistogram();
            case CITY -> hotelRepository.getCityHistogram();
            case COUNTRY -> hotelRepository.getCountryHistogram();
            case AMENITIES -> hotelRepository.getAmenitiesHistogram();
        };

        return result.stream()
                .collect(Collectors.toMap(
                        HistogramProjection::getValue,
                        HistogramProjection::getCount
                ));
    }
}
