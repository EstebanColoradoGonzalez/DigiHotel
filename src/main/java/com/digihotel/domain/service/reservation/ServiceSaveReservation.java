package com.digihotel.domain.service.reservation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;
import com.digihotel.domain.port.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.digihotel.domain.service.assembler.implementation.ReservationAssemblerDomainImplementation.getReservationAssembler;

@Service
public class ServiceSaveReservation
{
    @Autowired
    ServiceCalculatePrice serviceCalculatePrice;
    @Autowired
    ReservationRepository reservationRepository;

    public ReservationSummaryDTO implement(Reservation reservation)
    {
        var price = this.serviceCalculatePrice.implement(reservation.getDestination().getHotel().getNumberStars(), reservation.getDestination().getHotel().getRooms(), reservation.getCheckIn(), reservation.getCheckOut());

        var id = this.reservationRepository.save(reservation, price);

        return getReservationAssembler().assembleDTOFromDomain(reservation, price, id);
    }
}