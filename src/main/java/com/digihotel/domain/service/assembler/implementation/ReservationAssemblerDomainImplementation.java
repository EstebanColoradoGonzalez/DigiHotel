package com.digihotel.domain.service.assembler.implementation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.formatter.FormatDate;
import com.digihotel.domain.model.Reservation;
import com.digihotel.domain.service.assembler.ReservationAssemblerDomain;

public class ReservationAssemblerDomainImplementation implements ReservationAssemblerDomain
{
    private static final ReservationAssemblerDomain INSTANCE = new ReservationAssemblerDomainImplementation();

    private ReservationAssemblerDomainImplementation()
    {

    }

    public static ReservationAssemblerDomain getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public ReservationSummaryDTO assembleDTOFromDomain(Reservation reservation, double price, Long id)
    {
        return new ReservationSummaryDTO(id, FormatDate.getStringDate(reservation.getCheckIn()), FormatDate.getStringDate(reservation.getCheckOut()), price, reservation.getDestination());
    }
}
