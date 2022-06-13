package com.digihotel.infrastructure.adapter.repository.implementation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;
import com.digihotel.domain.port.ReservationRepository;
import com.digihotel.infrastructure.adapter.repository.jpa.DestinationDAO;
import com.digihotel.infrastructure.adapter.repository.jpa.HotelDAO;
import com.digihotel.infrastructure.adapter.repository.jpa.ReservationDAO;
import com.digihotel.infrastructure.adapter.repository.jpa.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.digihotel.infrastructure.service.assembler.implementation.ReservationAssemblerInfrastructureImplementation.getReservationAssembler;

@Repository
public class ReservationRepositoryImplementation implements ReservationRepository
{
    @Autowired
    ReservationDAO reservationDAO;
    @Autowired
    DestinationDAO destinationDAO;
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    RoomDAO roomDAO;

    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        return this.reservationDAO.findById(id).map(getReservationAssembler()::assembleDTOFromEntity).orElse(null);
    }

    @Override
    public Long save(Reservation reservation, double price)
    {
        var entity = getReservationAssembler().assembleEntityFromDomain(reservation);

        var reservations = this.reservationDAO.findAll();
        var destinations = this.destinationDAO.findAll();
        var hotels = this.hotelDAO.findAll();
        var rooms = this.roomDAO.findAll();

        var reservationId = 1L;
        var destinationId = 1L;
        var hotelId = 1L;
        var roomId = 1L;

        if(!reservations.isEmpty())
        {
            reservationId = reservations.get(reservations.size() - 1).getId() + 1;
        }

        if(!destinations.isEmpty())
        {
            destinationId = this.destinationDAO.findAll().get(this.destinationDAO.findAll().size() - 1).getId() + 1;
        }

        if(!hotels.isEmpty())
        {
            hotelId = this.hotelDAO.findAll().get(this.hotelDAO.findAll().size() - 1).getId() + 1;
        }

        if(!rooms.isEmpty())
        {
            roomId = this.roomDAO.findAll().get(this.roomDAO.findAll().size() - 1).getId();
        }

        entity.setId(reservationId);
        entity.setPrice(price);
        entity.getDestination().setId(destinationId);
        entity.getDestination().getHotel().setId(hotelId);

        for(int i = 0; i < entity.getDestination().getHotel().getRooms().size(); i++)
        {
            entity.getDestination().getHotel().getRooms().get(i).setId(roomId++);
        }

        entity.getDestination().getHotel().getRooms().forEach(room ->
        {
            this.roomDAO.save(room);
        });

        this.hotelDAO.save(entity.getDestination().getHotel());
        this.destinationDAO.save(entity.getDestination());

        return this.reservationDAO.save(entity).getId();
    }

    @Override
    public Long update(Reservation reservation, double price, Long id)
    {
        var entity = getReservationAssembler().assembleEntityFromDomain(reservation);
        var reservationConsulted = this.reservationDAO.findById(id).orElse(null);

        var rooms = this.roomDAO.findAll();
        var hotels = this.hotelDAO.findAll();
        var hotelId = 1L;
        var roomId = 1L;

        if(!hotels.isEmpty())
        {
            hotelId = this.hotelDAO.findAll().get(this.hotelDAO.findAll().size() - 1).getId();
        }

        entity.getDestination().getHotel().setId(hotelId);

        if(!rooms.isEmpty())
        {
            roomId = this.roomDAO.findAll().get(this.roomDAO.findAll().size() - 1).getId();
        }

        for(int i = 0; i < entity.getDestination().getHotel().getRooms().size(); i++)
        {
            entity.getDestination().getHotel().getRooms().get(i).setId(roomId++);
        }

        entity.getDestination().getHotel().getRooms().forEach(room ->
        {
            this.roomDAO.save(room);
        });

        entity.setPrice(price);
        entity.setId(id);

        return this.reservationDAO.save(entity).getId();
    }

    @Override
    public void delete(Long id)
    {
        var entity = this.reservationDAO.findById(id).orElse(null);

        if(entity != null)
        {
            entity.getDestination().getHotel().getRooms().forEach(room -> this.roomDAO.deleteById(room.getId()));
            this.hotelDAO.deleteById(entity.getDestination().getHotel().getId());
            this.destinationDAO.deleteById(entity.getDestination().getId());
        }

        this.reservationDAO.deleteById(id);
    }
}
