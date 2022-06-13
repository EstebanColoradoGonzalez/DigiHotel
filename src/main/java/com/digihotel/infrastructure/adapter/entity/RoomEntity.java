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
@Table(name = "room")
public class RoomEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="room_id_seq")
    @SequenceGenerator(name="room_id_seq", sequenceName="room_id_seq", allocationSize=1)
    private Long id;
    private int numberGuests;
}