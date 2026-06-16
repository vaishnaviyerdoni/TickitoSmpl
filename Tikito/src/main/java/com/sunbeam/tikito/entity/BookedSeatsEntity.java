package com.sunbeam.tikito.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "")
@Table(name="booked_seats",
	   uniqueConstraints = 
	   {
			@UniqueConstraint(name = "uk_show_seat",
							  columnNames = {"show_id", "seat_id"})
	   })
public class BookedSeatsEntity 
{
	@Id
	@Column(name="booked_seat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookedSeatsId;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private BookingEntity booking;
	
	@ManyToOne
	@JoinColumn(name="seat_id")
	private SeatEntity seat;
	
	@ManyToOne
	@JoinColumn(name="show_id")
	private ShowEntity show;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
