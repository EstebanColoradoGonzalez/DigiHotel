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
@Table(name = "reservation")
public class ReservationEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="reservation_id_seq")
    @SequenceGenerator(name="reservation_id_seq", sequenceName="reservation_id_seq", allocationSize=1)
    private Long id;
    private String checkIn;
    private String checkOut;
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination")
    private DestinationEntity destination;
}