package net.kumar.bookingdemo;

import net.kumar.bookingdemo.entity.HotelBookingModel;
import net.kumar.bookingdemo.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// this kind of classes implement CommandLineRunner executes when app starts and used to seed data initially.
@Component
public class DatabaseSeeder implements CommandLineRunner {
    private IBookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(IBookingRepository _bookingRepository)
    {
        this.bookingRepository = _bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBookingModel> bookings=new ArrayList<>();

        bookings.add(new HotelBookingModel("Marriot",200.50,3));
        bookings.add(new HotelBookingModel("Ibis",90.50,4));
        bookings.add(new HotelBookingModel("Novotel",140.50,1));

        bookingRepository.saveAll(bookings);
    }
}
