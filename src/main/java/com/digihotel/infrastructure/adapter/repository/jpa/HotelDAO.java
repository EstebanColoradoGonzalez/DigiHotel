package com.digihotel.infrastructure.adapter.repository.jpa;

import com.digihotel.infrastructure.adapter.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO extends JpaRepository<HotelEntity, Long>
{

}