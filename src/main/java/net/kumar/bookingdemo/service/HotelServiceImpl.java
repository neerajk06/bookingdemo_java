package net.kumar.bookingdemo.service;

import net.kumar.bookingdemo.entity.HotelBookingModel;
import net.kumar.bookingdemo.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {
    private IBookingRepository hotelRepoisitory;

    @Autowired
    public HotelServiceImpl(IBookingRepository _hotelRepoisitory)
    {
        hotelRepoisitory = _hotelRepoisitory;
    }

    @Override
    public List<HotelBookingModel> GetAllHotels()
    {
        return hotelRepoisitory.findAll();
    }
    @Override
    public void SaveHotel(HotelBookingModel hotel)
    {
        hotelRepoisitory.save(hotel);
    }
    @Override
    public HotelBookingModel GetHotelById(long id)
    {
       Optional<HotelBookingModel> optional = hotelRepoisitory.findById(id);
       HotelBookingModel hotel = null;
       if(optional.isPresent())
       {
           hotel = optional.get();
       }
       else
       {
           throw new RuntimeException("Hotel not found for id::"+id);
       }
        return hotel;
    }
    @Override
   public void DeleteHotel(long id)
   {
       hotelRepoisitory.deleteById(id);
   }
}
