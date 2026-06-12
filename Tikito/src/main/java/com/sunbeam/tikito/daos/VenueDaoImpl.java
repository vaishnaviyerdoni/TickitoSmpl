package com.sunbeam.tikito.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.VenueEntity;

public interface VenueDaoImpl extends JpaRepository<VenueEntity, Integer>  {

}
