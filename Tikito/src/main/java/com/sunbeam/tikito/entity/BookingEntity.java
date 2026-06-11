package com.sunbeam.tikito.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bookings")
public class BookingEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private UserEntity user;
	
	//@Column(nullable=false)
	//private Show show;
	
	@Column(nullable=false)
	private int totalAmt;
	
	@Column(nullable=false)
	private boolean paymentStatus;
	
	LocalDate createdAt;
	LocalDate updatedAt;
	
}
