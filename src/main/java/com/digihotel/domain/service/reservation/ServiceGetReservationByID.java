package com.digihotel.domain.service.reservation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.port.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetReservationByID
{
    @Autowired
    ReservationRepository reservationRepository;

    public ReservationSummaryDTO implement(Long id)
    {
        var reservation = this.reservationRepository.getById(id);

        if(reservation == null)
        {
            throw new IllegalArgumentException("No existe ninguna reservación con el ID " + id);
        }

        return reservation;
    }
}