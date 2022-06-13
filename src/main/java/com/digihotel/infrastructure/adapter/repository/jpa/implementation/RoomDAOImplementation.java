package com.digihotel.infrastructure.adapter.repository.jpa.implementation;

import com.digihotel.domain.model.Room;
import com.digihotel.infrastructure.adapter.entity.RoomEntity;
import com.digihotel.infrastructure.adapter.repository.jpa.RoomDAO;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAOImplementation implements RoomDAO
{
    private Connection connection;

    @Override
    public List<RoomEntity> findAll() throws SQLException
    {
        List<RoomEntity> rooms = new ArrayList<>();

        var SQL = "SELECT id, number_guests, hotel FROM room";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        ResultSet results = preparedStatement.executeQuery();

        while(results.next())
        {
            rooms.add(assembleRooms(results));
        }

        return rooms;
    }

    private RoomEntity assembleRooms(ResultSet results) throws SQLException
    {
        var temp = new RoomEntity();

        temp.setId(results.getLong("id"));
        temp.setNumberGuests(results.getInt("number_guests"));

        return temp;
    }

    @Override
    public RoomEntity findById()
    {
        return null;
    }

    @Override
    public void save(RoomEntity room)
    {

    }

    @Override
    public void update(RoomEntity room)
    {

    }

    @Override
    public void delete(Long id)
    {

    }
}
