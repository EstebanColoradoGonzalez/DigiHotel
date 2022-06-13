package com.digihotel.application.service.assembler.implementation;

import com.digihotel.application.dto.HotelDTO;
import com.digihotel.application.service.assembler.HotelAssemblerApplication;
import com.digihotel.domain.model.Hotel;
import static com.digihotel.application.service.assembler.implementation.RoomAssemblerApplicationImplementation.getRoomAssembler;

public class HotelAssemblerApplicationImplementation implements HotelAssemblerApplication
{
    private static final HotelAssemblerApplication INSTANCE = new HotelAssemblerApplicationImplementation();

    private HotelAssemblerApplicationImplementation()
    {

    }

    public static HotelAssemblerApplication getHotelAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Hotel assembleDomainFromDTO(HotelDTO dto)
    {
        return Hotel.create(dto.getNumberStars(), getRoomAssembler().assembleDomainsFromDTOs(dto.getRooms()));
    }

    @Override
    public HotelDTO assembleDTOFromDomain(Hotel domain)
    {
        return new HotelDTO(domain.getNumberStars(), getRoomAssembler().assembleDTOsFromDomains(domain.getRooms()));
    }
}