package com.digihotel.domain.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Hotel
{
    private final int numberStars;
    private List<Room> rooms;

    private Hotel(int numberStars, List<Room> rooms)
    {
        this.numberStars = numberStars;
        setRooms(rooms);
    }

    public static Hotel create(int numberStars, List<Room> rooms)
    {
        return new Hotel(numberStars, rooms);
    }

    private void setRooms(List<Room> rooms)
    {
        int guestsAllowed = calculateNumberGuestsAllowed(this.numberStars);

        rooms.forEach(room ->
        {
            if(room.getNumberGuests() > guestsAllowed)
            {
                throw new IllegalArgumentException("El numero de huéspedes no puede ser mayor o igual que " + guestsAllowed);
            }
        });

        this.rooms = rooms;
    }

    private int calculateNumberGuestsAllowed(int numberStars)
    {
        if(numberStars == 1)
        {
            return 4;
        }
        else if(numberStars == 2)
        {
            return 5;
        }
        else if(numberStars == 3)
        {
            return 6;
        }
        else if(numberStars == 4)
        {
            return 8;
        }

        return 10;
    }
}
