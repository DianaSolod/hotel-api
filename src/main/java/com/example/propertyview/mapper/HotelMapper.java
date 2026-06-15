package com.example.propertyview.mapper;

import com.example.propertyview.dto.HotelRequestDto;
import com.example.propertyview.dto.HotelResponseDto;
import com.example.propertyview.dto.HotelShortResponseDto;
import com.example.propertyview.entity.Address;
import com.example.propertyview.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @Mapping(target = "phone", source = "contacts.phone")
    @Mapping(target = "address", source = "address", qualifiedByName = "mapAddress")
    HotelShortResponseDto toShortDto(Hotel hotel);

    HotelResponseDto toDto(Hotel hotel);

    @Mapping(target = "id", ignore = true)
    Hotel toEntity(HotelRequestDto dto);

    @Named("mapAddress")
    default String mapAddress(Address address) {
        if (address == null) {
            return null;
        }

        return String.format("%d %s, %s, %s, %s", address.getHouseNumber(), address.getStreet(),
                address.getCity(), address.getPostCode(), address.getCountry());
    }
}
