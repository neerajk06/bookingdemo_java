package net.kumar.bookingdemo.entity;

import javax.persistence.*;

// to add persistency, we need to make this class with @Entity, so now it is part of domain model
@Entity
@Table(name = "hotelmain")
public class HotelBookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "price_pernight")
    private double pricePerNight;
    @Column(name = "number_days")
    private int numberOfNights;

    public void setId(long id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public long getId() {
        return id;
    }
    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }
    public HotelBookingModel()
    {}

    public HotelBookingModel(String hotelName, double pricePerNight, int numberOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
    }

    public double GetTotalPrice(){
        return pricePerNight*numberOfNights;
    }
}
