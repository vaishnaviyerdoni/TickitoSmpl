package com.sunbeam.tikito.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="booked_seats")
public class BookedSeatsEntity 
{
	@Id
	@Column(name="booked_seat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookedSeatsId;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingEntity booking;
	
	//@ManyToAny
	//@JoinColumn(name="seat_id")
	//private Seat seat;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
}
