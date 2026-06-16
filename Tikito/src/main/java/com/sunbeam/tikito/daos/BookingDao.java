package com.sunbeam.tikito.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.BookingEntity;

public interface BookingDao extends JpaRepository<BookingEntity, Integer>
{

}
