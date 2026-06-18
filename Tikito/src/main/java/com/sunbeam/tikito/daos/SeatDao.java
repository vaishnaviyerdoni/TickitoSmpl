package com.sunbeam.tikito.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.SeatEntity;

public interface SeatDao extends JpaRepository<SeatEntity,Long> {

}
