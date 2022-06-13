package com.digihotel.application.service.reservation;

import com.digihotel.application.dto.ReservationDTO;
import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.service.reservation.ServiceUpdateReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.digihotel.application.service.assembler.implementation.ReservationAssemblerApplicationImplementation.getReservationAssembler;

@Component
public class ServiceApplicationUpdateReservation
{
    @Autowired
    ServiceUpdateReservation serviceUpdateReservation;

    public ReservationSummaryDTO implement(Long id, ReservationDTO reservation)
    {
        return this.serviceUpdateReservation.implement(id, getReservationAssembler().assembleDomainFromDTO(reservation));
    }
}