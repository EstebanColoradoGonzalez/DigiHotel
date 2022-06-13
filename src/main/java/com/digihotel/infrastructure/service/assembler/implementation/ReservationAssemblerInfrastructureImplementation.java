package com.digihotel.infrastructure.service.assembler.implementation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.formatter.FormatDate;
import com.digihotel.domain.model.Reservation;
import com.digihotel.infrastructure.adapter.entity.ReservationEntity;
import com.digihotel.infrastructure.service.assembler.ReservationAssemblerInfrastructure;
import static com.digihotel.infrastructure.service.assembler.implementation.DestinationAssemblerInfrastructureImplementation.getDestinationAssembler;

public class ReservationAssemblerInfrastructureImplementation implements ReservationAssemblerInfrastructure
{
    private static final ReservationAssemblerInfrastructure INSTANCE = new ReservationAssemblerInfrastructureImplementation();

    private ReservationAssemblerInfrastructureImplementation()
    {

    }

    public static ReservationAssemblerInfrastructure getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromEntity(ReservationEntity entity)
    {
        return Reservation.create(FormatDate.getDate(entity.getCheckIn()), FormatDate.getDate(entity.getCheckOut()), getDestinationAssembler().assembleDomainFromEntity(entity.getDestination()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomain(Reservation domain)
    {
        return new ReservationEntity(1L, FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), 0.0, getDestinationAssembler().assembleEntityFromDomain(domain.getDestination()));
    }

    @Override
    public ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity)
    {
        return new ReservationSummaryDTO(entity.getId(), entity.getCheckIn(), entity.getCheckOut(), entity.getPrice(), getDestinationAssembler().assembleDomainFromEntity(entity.getDestination()));
    }
}