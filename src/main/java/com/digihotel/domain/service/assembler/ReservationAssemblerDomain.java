package com.digihotel.domain.service.assembler;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;

public interface ReservationAssemblerDomain
{
    ReservationSummaryDTO assembleDTOFromDomain(Reservation reservation, double price, Long id);
}