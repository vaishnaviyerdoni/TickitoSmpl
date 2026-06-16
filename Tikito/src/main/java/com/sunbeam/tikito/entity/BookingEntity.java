package com.sunbeam.tikito.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.sunbeam.tikito.enums.BookingStatus;
import com.sunbeam.tikito.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@ToString(exclude = "")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bookings")
public class BookingEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id", nullable=false)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="show_id")
	private ShowEntity show;
	
	@OneToMany(mappedBy="booking")
	private List<BookedSeatsEntity> bookedSeats;
	
	@Column(name="total_amt")
	private double totalAmt;
	
	@Enumerated(EnumType.STRING)
	@Column(name="payment_status")
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="booking_status")
	private BookingStatus bookingStatus;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
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
