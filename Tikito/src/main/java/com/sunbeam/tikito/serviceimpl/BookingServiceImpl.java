package com.sunbeam.tikito.serviceimpl;

import org.springframework.stereotype.Service;

import com.sunbeam.tikito.dto.CancelTicketDto;
import com.sunbeam.tikito.dto.TicketBookedDto;
import com.sunbeam.tikito.dto.TicketBookingDto;
import com.sunbeam.tikito.services.BookingService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

	@Override
	public TicketBookedDto bookTicket(TicketBookingDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CancelTicketDto cancalTicket(long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
