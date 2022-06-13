package com.digihotel.application.service.reservation;

import com.digihotel.application.dto.ReservationDTO;
import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.service.reservation.ServiceSaveReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.digihotel.application.service.assembler.implementation.ReservationAssemblerApplicationImplementation.getReservationAssembler;

@Component
public class ServiceApplicationSaveReservation
{
    @Autowired
    ServiceSaveReservation serviceSaveReservation;

    public ReservationSummaryDTO implement(ReservationDTO reservation)
    {
        return this.serviceSaveReservation.implement(getReservationAssembler().assembleDomainFromDTO(reservation));
    }
}
