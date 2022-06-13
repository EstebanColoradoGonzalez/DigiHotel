package com.digihotel.domain.model;

import lombok.Getter;

@Getter
public class Destination
{
    private final String city;
    private final String country;
    private final Hotel hotel;

    private Destination(String city, String country, Hotel hotel)
    {
        this.city = city;
        this.country = country;
        this.hotel = hotel;
    }

    public static Destination create(String city, String country, Hotel hotel)
    {
        return new Destination(city, country, hotel);
    }
}
