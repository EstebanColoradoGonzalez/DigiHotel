package com.digihotel.domain.port;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;

public interface ReservationRepository
{
    ReservationSummaryDTO getById(Long id);
    Long save(Reservation reservation, double price);
    Long update(Reservation reservation, double price, Long id);
    void delete(Long id);
}