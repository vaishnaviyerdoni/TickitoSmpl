package com.sunbeam.tikito.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.BookingEntity;

public interface BookingDao extends JpaRepository<BookingEntity, Integer>
{
	List<BookingEntity> findByUserUserId(int userId);
	List<BookingEntity> findByBookingIdAndUserUserId(int bookingId, int userId);
}
