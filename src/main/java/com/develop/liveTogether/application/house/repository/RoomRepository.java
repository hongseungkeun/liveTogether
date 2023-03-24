package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
