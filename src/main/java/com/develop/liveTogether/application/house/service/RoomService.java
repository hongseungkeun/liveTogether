package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;
import com.develop.liveTogether.application.house.dto.RoomRequest;
import com.develop.liveTogether.application.house.exception.FileNotExistException;
import com.develop.liveTogether.application.house.repository.RoomRepository;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import com.develop.liveTogether.global.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public void saveRoom(List<RoomRequest> rooms, House house, List<MultipartFile> files) {
        List<String> roomFiles = saveFile(files);

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i).toEntity(house, roomFiles.get(i));
            roomRepository.save(room);
        }
    }

    @Transactional
    public void deleteRooms(Long houseNumber) {
        List<Room> rooms = findRooms(houseNumber);
        deleteFile(rooms);

        roomRepository.deleteAllByHouse_HouseNumber(houseNumber);
    }

    private List<Room> findRooms(Long houseNumber){
        return roomRepository.findAllByHouse_HouseNumber(houseNumber);
    }

    private List<String> saveFile(List<MultipartFile> files){
        List<String> roomFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            roomFiles.add(saveFile(file));
        }
        return roomFiles;
    }

    private String saveFile(MultipartFile file){
        if(file.isEmpty()) {
            throw new FileNotExistException(ErrorCode.FILE_NOT_EXIST);
        }
        String houseFileNameOriginal = file.getOriginalFilename();
        String houseFileName = UUID.randomUUID() + "." + FileUtil.extractExt(houseFileNameOriginal);

        Path path = Paths.get(FileUtil.getFilePath(houseFileName)).toAbsolutePath();

        try {
            file.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return houseFileName;
    }

    private void deleteFile(List<Room> rooms) {
        for (Room room : rooms) {
            deleteFile(room);
        }
    }

    private void deleteFile(Room room) {
        File file = new File(FileUtil.getFilePath(room.getRoomImg()));

        if(file.exists()){
            file.delete();
        }
    }
}
