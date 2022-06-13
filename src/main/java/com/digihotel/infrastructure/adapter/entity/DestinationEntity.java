package com.digihotel.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destination")
public class DestinationEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="destination_id_seq")
    @SequenceGenerator(name="destination_id_seq", sequenceName="destination_id_seq", allocationSize=1)
    private Long id;
    private String city;
    private String country;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel")
    private HotelEntity hotel;
}
