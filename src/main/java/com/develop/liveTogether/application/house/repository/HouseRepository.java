package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long>, HouseCustomRepository {
}
