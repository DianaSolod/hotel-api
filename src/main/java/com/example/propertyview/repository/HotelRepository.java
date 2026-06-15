package com.example.propertyview.repository;

import com.example.propertyview.dto.HistogramProjection;
import com.example.propertyview.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {

    @Query("""
                select h.brand as value,
                       count(h) as count
                from Hotel h
                group by h.brand
            """)
    List<HistogramProjection> getBrandHistogram();

    @Query("""
                select h.address.city as value,
                       count(h) as count
                from Hotel h
                group by h.address.city
            """)
    List<HistogramProjection> getCityHistogram();

    @Query("""
                select h.address.country as value,
                       count(h) as count
                from Hotel h
                group by h.address.country
            """)
    List<HistogramProjection> getCountryHistogram();

    @Query("""
                select a as value,
                       count(a) as count
                from Hotel h
                join h.amenities a
                group by a
            """)
    List<HistogramProjection> getAmenitiesHistogram();
}