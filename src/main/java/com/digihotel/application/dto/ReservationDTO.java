package com.digihotel.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO
{
    private String checkIn;
    private String checkOut;
    private DestinationDTO destination;
}