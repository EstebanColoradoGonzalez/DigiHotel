package com.digihotel.infrastructure.adapter.repository.jpa;

import com.digihotel.infrastructure.adapter.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationDAO extends JpaRepository<DestinationEntity, Long>
{

}