package com.digihotel.infrastructure.adapter.repository.implementation;

import com.digihotel.domain.dto.ReservationSummaryDTO;
import com.digihotel.domain.model.Reservation;
import com.digihotel.domain.port.ReservationRepository;
import com.digihotel.infrastructure.adapter.entity.ReservationEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepositoryPostgreSQL implements ReservationRepository
{
    private DataSource dataSource;
    private Connection connection;

    public ReservationRepositoryPostgreSQL(DataSource dataSource, Connection connection)
    {
        this.dataSource = dataSource;
        this.connection = connection;
    }

    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        var reservation = new ReservationEntity();
        List<Object> params = new ArrayList<>();

        var SQL = "SELECT id, check_in, check_out, price, destination where id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setLong(1, id);

            try(ResultSet results = preparedStatement.executeQuery())
            {
                while(results.next())
                {
                    reservation = assembleReservation(results);
                }
            }
            catch(SQLException excepcion)
            {
                throw new SudokuDatosExcepcion("Se ha presentado problemas tratando de recuperar los datos de la consulta de las celdas por region");
            }
        }
        catch(SQLException excepcion)
        {
            throw new SudokuDatosExcepcion("Se ha presentado problemas preparando la consulta de datos de las celdas por region");
        }
        catch(SudokuDatosExcepcion excepcion)
        {
            throw excepcion;
        }
        catch(Exception excepcion)
        {
            throw new SudokuDatosExcepcion("Se ha presentado problemas inesperados consultando la informaci�n de las celdas por region");
        }

        return null;
    }

    private ReservationEntity assembleReservation(ResultSet results)
    {
        try
        {
            var temp = new ReservationEntity();

            temp.setId();

            temp.setCodigo(resultados.getInt("codigo"));
            temp.setCelda(resultados.getInt("celda"));
            temp.setRegion(resultados.getInt("region"));

            return celdasPorRegionTemporal;
        }
        catch (SQLException excepcion)
        {
            throw new SudokuDatosExcepcion("Se ha presentado un problema tratando de recuperar los datos de una celda por region");
        }
    }

    @Override
    public Long save(Reservation reservation, double price)
    {
        return null;
    }

    @Override
    public Long update(Reservation reservation, double price, Long id)
    {
        return null;
    }

    @Override
    public void delete(Long id)
    {

    }
}