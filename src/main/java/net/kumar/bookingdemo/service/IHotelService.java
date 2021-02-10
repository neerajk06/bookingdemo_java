package net.kumar.bookingdemo.service;

import net.kumar.bookingdemo.entity.HotelBookingModel;

import java.util.List;

public interface IHotelService {
    List<HotelBookingModel> GetAllHotels();
    void SaveHotel(HotelBookingModel hotel);
    HotelBookingModel GetHotelById(long id);
    void DeleteHotel(long id);
}
