package com.digihotel.application.service.assembler.implementation;

import com.digihotel.application.dto.RoomDTO;
import com.digihotel.application.service.assembler.RoomAssemblerApplication;
import com.digihotel.domain.model.Room;
import java.util.List;

public class RoomAssemblerApplicationImplementation implements RoomAssemblerApplication
{
    private static final RoomAssemblerApplication INSTANCE = new RoomAssemblerApplicationImplementation();

    private RoomAssemblerApplicationImplementation()
    {

    }

    public static RoomAssemblerApplication getRoomAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Room assembleDomainFromDTO(RoomDTO dto)
    {
        return Room.create(dto.getNumberGuests());
    }

    @Override
    public RoomDTO assembleDTOFromDomain(Room domain)
    {
        return new RoomDTO(domain.getNumberGuests());
    }

    @Override
    public List<Room> assembleDomainsFromDTOs(List<RoomDTO> dtos)
    {
        return dtos.stream().map(getRoomAssembler()::assembleDomainFromDTO).toList();
    }

    @Override
    public List<RoomDTO> assembleDTOsFromDomains(List<Room> domains)
    {
        return domains.stream().map(getRoomAssembler()::assembleDTOFromDomain).toList();
    }
}