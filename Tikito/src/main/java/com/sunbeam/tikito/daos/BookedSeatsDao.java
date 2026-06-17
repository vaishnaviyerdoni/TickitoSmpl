package com.sunbeam.tikito.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.tikito.entity.BookedSeatsEntity;

public interface BookedSeatsDao extends JpaRepository<BookedSeatsEntity, Long>
{
	List<BookedSeatsEntity> findByBookingBookingId(int bookingId);

	void deleteByBookingBookingId(int bookingId);

	boolean existsByShowShowIdAndSeatSeatId(int showId, int SeatId);

	List<BookedSeatsEntity> findByShowShowIdAndSeatSeatIdIn(int showId, int seatId);

	int findByShowShowId(int showId);
}
