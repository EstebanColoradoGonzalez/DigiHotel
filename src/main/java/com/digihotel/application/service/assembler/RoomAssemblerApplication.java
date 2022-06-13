package com.digihotel.application.service.assembler;

import com.digihotel.application.dto.RoomDTO;
import com.digihotel.domain.model.Room;
import java.util.List;

public interface RoomAssemblerApplication extends AssemblerApplication<Room, RoomDTO>
{
    List<Room> assembleDomainsFromDTOs(List<RoomDTO> dtos);
    List<RoomDTO> assembleDTOsFromDomains(List<Room> domains);
}