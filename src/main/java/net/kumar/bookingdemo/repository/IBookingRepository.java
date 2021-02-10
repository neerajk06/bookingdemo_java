package net.kumar.bookingdemo.repository;

import net.kumar.bookingdemo.entity.HotelBookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<HotelBookingModel,Long> {
    // based on this name convension of method and parameter, custom JPQL code will be generated automatically to
    // implement this method.
    List<HotelBookingModel> findByPricePerNightLessThan(double price);
}
