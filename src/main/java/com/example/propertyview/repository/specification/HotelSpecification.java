package com.example.propertyview.repository.specification;

import com.example.propertyview.dto.HotelSearchDto;
import com.example.propertyview.entity.Hotel;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Setter
public class HotelSpecification {

    private static final String NAME = "name";
    private static final String BRAND = "brand";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String AMENITIES = "amenities";

    public static Specification<Hotel> withFilter(HotelSearchDto filter) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (Objects.nonNull(filter.getName())) {
                predicate = cb.and(predicate, cb.like(cb.upper(root.get(NAME)), likePattern(filter.getName().toUpperCase())));
            }
            if (Objects.nonNull(filter.getBrand())) {
                predicate = cb.and(predicate, cb.like(cb.upper(root.get(BRAND)), likePattern(filter.getBrand().toUpperCase())));
            }
            if (Objects.nonNull(filter.getCity())) {
                predicate = cb.and(predicate, cb.like(cb.upper(root.get(ADDRESS).get(CITY)), likePattern(filter.getCity().toUpperCase())));
            }
            if (Objects.nonNull(filter.getCountry())) {
                predicate = cb.and(predicate, cb.like(cb.upper(root.get(ADDRESS).get(COUNTRY)), likePattern(filter.getCountry().toUpperCase())));
            }
            if (Objects.nonNull(filter.getAmenities())) {
                Join<Hotel, String> amenitiesJoin = root.join(AMENITIES, JoinType.LEFT);
                predicate = cb.and(predicate, cb.like(cb.upper(amenitiesJoin), likePattern(filter.getAmenities().toUpperCase())));
                query.distinct(true);
            }


            return predicate;
        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}