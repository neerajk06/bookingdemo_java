package net.kumar.bookingdemo;

import net.kumar.bookingdemo.entity.HotelBookingModel;
import net.kumar.bookingdemo.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private IBookingRepository bookingRepository;

    @Autowired
    public BookingController(IBookingRepository _bookingRepository){
        this.bookingRepository = _bookingRepository;
    }

@RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<HotelBookingModel> GetAll(){
        return  bookingRepository.findAll();

    }

    @RequestMapping(value = "/affordable/{price}",method = RequestMethod.GET)
    public List<HotelBookingModel> GetAffordable(@PathVariable double price)
    {
      return  bookingRepository.findByPricePerNightLessThan(price);

             // bookings.stream().filter(x->x.getPricePerNight()<=price)
              //  .collect(Collectors.toList());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public List<HotelBookingModel> Create(@RequestBody HotelBookingModel hotelBookingModel){
        bookingRepository.save(hotelBookingModel);
       // bookings.add(hotelBookingModel);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<HotelBookingModel> Delete (@PathVariable long id)
    {
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }
}
