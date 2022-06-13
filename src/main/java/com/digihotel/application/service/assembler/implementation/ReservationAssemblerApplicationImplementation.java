package com.digihotel.application.service.assembler.implementation;

import com.digihotel.application.dto.ReservationDTO;
import com.digihotel.application.service.assembler.ReservationAssemblerApplication;
import com.digihotel.domain.formatter.FormatDate;
import com.digihotel.domain.model.Reservation;
import static com.digihotel.application.service.assembler.implementation.DestinationAssemblerApplicationImplementation.getDestinationAssembler;

public class ReservationAssemblerApplicationImplementation implements ReservationAssemblerApplication
{
    private static final ReservationAssemblerApplication INSTANCE = new ReservationAssemblerApplicationImplementation();

    private ReservationAssemblerApplicationImplementation()
    {

    }

    public static ReservationAssemblerApplication getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromDTO(ReservationDTO dto)
    {
        return Reservation.create(FormatDate.getDate(dto.getCheckIn()), FormatDate.getDate(dto.getCheckOut()), getDestinationAssembler().assembleDomainFromDTO(dto.getDestination()));
    }

    @Override
    public ReservationDTO assembleDTOFromDomain(Reservation domain)
    {
        return new ReservationDTO(FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), getDestinationAssembler().assembleDTOFromDomain(domain.getDestination()));
    }
}