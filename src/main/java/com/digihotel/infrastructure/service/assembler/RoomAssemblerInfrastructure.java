package com.digihotel.infrastructure.service.assembler;

import com.digihotel.domain.model.Room;
import com.digihotel.infrastructure.adapter.entity.RoomEntity;

import java.util.List;

public interface RoomAssemblerInfrastructure extends AssemblerInfrastructure<Room, RoomEntity>
{
    List<Room> assembleDomainsFromEntities(List<RoomEntity> entities);
    List<RoomEntity> assembleEntitiesFromDomains(List<Room> domains);
}