package com.sunbeam.tikito.services;

import com.sunbeam.tikito.dto.CancelTicketDto;
import com.sunbeam.tikito.dto.TicketBookedDto;
import com.sunbeam.tikito.dto.TicketBookingDto;

public interface BookingService
{
	TicketBookedDto bookTicket(TicketBookingDto dto);
	CancelTicketDto cancalTicket(long bookingId);
}
