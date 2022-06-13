package com.digihotel.domain.service.reservation;

import com.digihotel.domain.port.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteReservation
{
    @Autowired
    ReservationRepository reservationRepository;

    public void implement(Long id)
    {
        if(this.reservationRepository.getById(id) == null)
        {
            throw new IllegalArgumentException("No existe ninguna reservación con el ID " + id);
        }

        this.reservationRepository.delete(id);
    }
}