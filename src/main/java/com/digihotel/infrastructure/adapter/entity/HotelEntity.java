package com.digihotel.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class HotelEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="hotel_id_seq")
    @SequenceGenerator(name="hotel_id_seq", sequenceName="hotel_id_seq", allocationSize=1)
    private Long id;
    private int numberStars;
    @OneToMany
    @JoinColumn(name = "hotel")
    private List<RoomEntity> rooms;
}
