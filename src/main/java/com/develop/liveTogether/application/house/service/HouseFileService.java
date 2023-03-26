package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.HouseFile;
import com.develop.liveTogether.application.house.repository.HouseFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class HouseFileService {

    private final HouseFileRepository houseFileRepository;

    public HouseFileService(HouseFileRepository houseFileRepository) {
        this.houseFileRepository = houseFileRepository;
    }

    private static final String FILE_PATH = System.getProperty("user.dir") + "\\upload";
    @Transactional
    public void saveFile(List<MultipartFile> multipartFiles, House house){
        for (MultipartFile multipartFile : multipartFiles) {
            saveFile(multipartFile, house);
        }
    }

    @Transactional
    public void saveFile(MultipartFile multipartFile, House house){
        if(!multipartFile.isEmpty()) {
            String houseFileNameOriginal = multipartFile.getOriginalFilename();
            String houseFileName = UUID.randomUUID() + "." + extractExt(houseFileNameOriginal);

            String file = FILE_PATH + File.separator + houseFileName;

//            File file1 = new File(file);

            Path path = Paths.get(file).toAbsolutePath();

            try {
//                multipartFile.transferTo(file1);
                multipartFile.transferTo(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            HouseFile houseFile = HouseFile.builder()
                    .houseFileName(houseFileName)
                    .houseFileNameOriginal(houseFileNameOriginal)
                    .house(house)
                    .build();

            houseFileRepository.save(houseFile);
        }
    }

    private String getFilePath(String filename) { return FILE_PATH + filename; }

    private String extractExt(String houseFileNameOriginal) {
        int pos = houseFileNameOriginal.lastIndexOf(".");
        return houseFileNameOriginal.substring(pos + 1);
    }
}
