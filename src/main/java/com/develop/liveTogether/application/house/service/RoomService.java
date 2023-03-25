package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;
import com.develop.liveTogether.application.house.dto.request.RoomRequest;
import com.develop.liveTogether.application.house.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void saveRoom(List<RoomRequest> rooms, House house) {
        for (RoomRequest request : rooms) {
            Room room = request.toEntity(house);
            roomRepository.save(room);
        }
    }
}
