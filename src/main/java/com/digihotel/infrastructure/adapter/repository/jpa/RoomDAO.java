package com.digihotel.infrastructure.adapter.repository.jpa;

import com.digihotel.infrastructure.adapter.entity.RoomEntity;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO
{
    List<RoomEntity> findAll() throws SQLException;
    RoomEntity findById();
    void save(RoomEntity room);
    void update(RoomEntity room);
    void delete(Long id);
}