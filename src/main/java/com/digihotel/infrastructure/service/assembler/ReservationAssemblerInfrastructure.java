package com.digihotel.infrastructure.service.assembler;

import com.digihotel.application.dto.ReservationDTO;
import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;
import com.digihotel.infrastructure.adapter.entity.ReservationEntity;

public interface ReservationAssemblerInfrastructure extends AssemblerInfrastructure<Reservation, ReservationEntity>
{
    ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity);
}