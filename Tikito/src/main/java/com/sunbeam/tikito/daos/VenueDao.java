package com.sunbeam.tikito.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.VenueEntity;

//changed Integer to Long
public interface VenueDao extends JpaRepository<VenueEntity, Long>  {

}
