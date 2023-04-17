package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHouse_HouseNumber(Long houseNumber);
    List<Room> deleteAllByHouse_HouseNumber(Long houseNumber);
}
