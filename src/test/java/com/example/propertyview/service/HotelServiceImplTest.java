package com.example.propertyview.service;

import com.example.propertyview.dto.HotelRequestDto;
import com.example.propertyview.dto.HotelResponseDto;
import com.example.propertyview.dto.HotelShortResponseDto;
import com.example.propertyview.entity.Hotel;
import com.example.propertyview.exception.ResourceNotFoundException;
import com.example.propertyview.mapper.HotelMapper;
import com.example.propertyview.repository.HotelRepository;
import com.example.propertyview.service.impl.HotelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private HotelMapper hotelMapper;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Test
    void shouldReturnHotelById() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);

        HotelResponseDto dto = new HotelResponseDto();
        dto.setId(1L);

        when(hotelRepository.findById(1L))
                .thenReturn(Optional.of(hotel));

        when(hotelMapper.toDto(hotel))
                .thenReturn(dto);

        HotelResponseDto result = hotelService.getById(1L);

        assertEquals(1L, result.getId());

        verify(hotelRepository).findById(1L);
        verify(hotelMapper).toDto(hotel);
    }

    @Test
    void shouldThrowExceptionWhenHotelNotFound() {

        when(hotelRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> hotelService.getById(1L)
        );
    }

    @Test
    void shouldCreateHotel() {

        HotelRequestDto request = new HotelRequestDto();

        Hotel entity = new Hotel();
        Hotel saved = new Hotel();
        saved.setId(1L);

        HotelShortResponseDto response = new HotelShortResponseDto();
        response.setId(1L);

        when(hotelMapper.toEntity(request))
                .thenReturn(entity);

        when(hotelRepository.save(entity))
                .thenReturn(saved);

        when(hotelMapper.toShortDto(saved))
                .thenReturn(response);

        HotelShortResponseDto result = hotelService.addHotel(request);

        assertEquals(1L, result.getId());

        verify(hotelRepository).save(entity);
    }
}