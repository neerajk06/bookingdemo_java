package net.kumar.bookingdemo;

import net.kumar.bookingdemo.entity.HotelBookingModel;
import net.kumar.bookingdemo.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class BookingViewController {
    private String appMode;
    private IHotelService hotelService;

    @Autowired
    public BookingViewController(Environment environment,IHotelService _hotelService)
    {
        appMode = environment.getProperty("app-mode");
        hotelService = _hotelService;
    }


    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username","Neeraj K");
        model.addAttribute("mode",appMode);
        model.addAttribute("listHotels",hotelService.GetAllHotels());
        return "index";
    }

//    @ModelAttribute("HotelBookingModel")
//    public HotelBookingModel populateHotel()
//    {
//        HotelBookingModel hotelBookingModel = new HotelBookingModel();
//        hotelBookingModel.set
//    }

    @RequestMapping("/newHotelForm")
    public String newHotelForm(Model model)
    {
        HotelBookingModel hotelModel = new HotelBookingModel();
        model.addAttribute("datetime", new Date());
        model.addAttribute("username","Neeraj K");
        model.addAttribute("mode",appMode);
        model.addAttribute("hotel",hotelModel);
        return "new_hotel";
    }

    @RequestMapping(value = "/saveHotel",method = RequestMethod.POST)
    public String saveHotel(@ModelAttribute("hotel") HotelBookingModel hotel){
        hotelService.SaveHotel(hotel);
        return "redirect:/";
    }

    @RequestMapping(value = "/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model)
    {
        HotelBookingModel hotel = hotelService.GetHotelById(id);
        model.addAttribute("datetime", new Date());
        model.addAttribute("username","Neeraj K");
        model.addAttribute("mode",appMode);
        model.addAttribute("hotel",hotel);
        return "update_hotel";
    }

    @RequestMapping(value = "/deleteHotel/{id}")
    public String deleteHotel(@PathVariable(value = "id") long id){
            hotelService.DeleteHotel(id);
            return "redirect:/";
    }

}
