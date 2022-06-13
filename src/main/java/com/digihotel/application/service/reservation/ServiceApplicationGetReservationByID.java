package com.digihotel.application.service.reservation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.port.ReservationRepository;
import com.digihotel.domain.service.reservation.ServiceGetReservationByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetReservationByID
{
    @Autowired
    ServiceGetReservationByID serviceGetReservationByID;

    public ReservationSummaryDTO implement(Long id)
    {
        return this.serviceGetReservationByID.implement(id);
    }
}