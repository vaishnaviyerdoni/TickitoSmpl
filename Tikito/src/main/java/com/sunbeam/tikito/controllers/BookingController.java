package com.sunbeam.tikito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.tikito.dto.TicketBookedDto;
import com.sunbeam.tikito.dto.TicketBookingDto;
import com.sunbeam.tikito.serviceimpl.BookingServiceImpl;
import com.sunbeam.tikito.utils.Resp;

@RestController
@RequestMapping("/tikito/api/booking")
public class BookingController 
{
	@Autowired
	private BookingServiceImpl ser;
	
	@PostMapping
	public Resp<?> bookTicket(@RequestBody TicketBookingDto dto)
	{
		TicketBookedDto ticket = ser.bookTicket(dto);
		return Resp.success(ticket);
	}
}
