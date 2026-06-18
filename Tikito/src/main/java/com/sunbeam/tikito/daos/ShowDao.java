package com.sunbeam.tikito.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.ShowEntity;

public interface ShowDao extends JpaRepository<ShowEntity, Long>{

}
