package com.digihotel.infrastructure.service.assembler.implementation;

import com.digihotel.application.dto.HotelDTO;
import com.digihotel.domain.model.Hotel;
import com.digihotel.infrastructure.adapter.entity.HotelEntity;
import com.digihotel.infrastructure.service.assembler.HotelAssemblerInfrastructure;

import static com.digihotel.infrastructure.service.assembler.implementation.RoomAssemblerInfrastructureImplementation.getRoomAssembler;

public class HotelAssemblerInfrastructureImplementation implements HotelAssemblerInfrastructure
{
    private static final HotelAssemblerInfrastructure INSTANCE = new HotelAssemblerInfrastructureImplementation();

    private HotelAssemblerInfrastructureImplementation()
    {

    }

    public static HotelAssemblerInfrastructure getHotelAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Hotel assembleDomainFromEntity(HotelEntity entity)
    {
        return Hotel.create(entity.getNumberStars(), getRoomAssembler().assembleDomainsFromEntities(entity.getRooms()));
    }

    @Override
    public HotelEntity assembleEntityFromDomain(Hotel domain)
    {
        return new HotelEntity(1L, domain.getNumberStars(), getRoomAssembler().assembleEntitiesFromDomains(domain.getRooms()));
    }
}