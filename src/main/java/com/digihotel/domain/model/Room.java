package com.digihotel.domain.model;

import lombok.Getter;

@Getter
public class Room
{
    private int numberGuests;

    private Room(int numberGuests)
    {
        setNumberGuests(numberGuests);
    }

    public static Room create(int numberGuests)
    {
        return new Room(numberGuests);
    }

    private void setNumberGuests(int numberGuests)
    {
        if(numberGuests <= 0)
        {
            throw new IllegalArgumentException("El numero de huéspedes no puede ser menor o igual que cero");
        }

        this.numberGuests = numberGuests;
    }
}