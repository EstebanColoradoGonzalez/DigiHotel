package com.digihotel.domain.model;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Reservation
{
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final Destination destination;

    private Reservation(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.destination = destination;
    }

    public static Reservation create(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        return new Reservation(checkIn, checkOut, destination);
    }
}