package com.digihotel.application.service.reservation;

import com.digihotel.domain.service.reservation.ServiceDeleteReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteReservation
{
    @Autowired
    ServiceDeleteReservation serviceDeleteReservation;

    public void implement(Long id)
    {
        this.serviceDeleteReservation.implement(id);
    }
}