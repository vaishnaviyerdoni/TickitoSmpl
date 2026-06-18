package com.sunbeam.tikito.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sunbeam.tikito.daos.BookedSeatsDao;
import com.sunbeam.tikito.daos.BookingDao;
import com.sunbeam.tikito.daos.SeatDao;
import com.sunbeam.tikito.daos.ShowDao;
import com.sunbeam.tikito.daos.UserDao;
import com.sunbeam.tikito.dto.BookedSeatDto;
import com.sunbeam.tikito.dto.CancelTicketDto;
import com.sunbeam.tikito.dto.TicketBookedDto;
import com.sunbeam.tikito.dto.TicketBookingDto;
import com.sunbeam.tikito.entity.UserEntity;
import com.sunbeam.tikito.enums.BookingStatus;
import com.sunbeam.tikito.enums.PaymentStatus;
import com.sunbeam.tikito.exceptions.InvalidSeatsException;
import com.sunbeam.tikito.exceptions.ShowNotFoundException;
import com.sunbeam.tikito.exceptions.UserNotFoundException;
import com.sunbeam.tikito.services.BookingService;
import com.sunbeam.tikito.entity.BookedSeatsEntity;
import com.sunbeam.tikito.entity.BookingEntity;
import com.sunbeam.tikito.entity.SeatEntity;
import com.sunbeam.tikito.entity.ShowEntity;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {
	
	private UserDao userDao;
	private ShowDao showDao;
	private SeatDao seatDao;
	private BookedSeatsDao bookedSeatDao;
	private BookingDao bookingDao;
	
	public BookingServiceImpl(UserDao userDao, ShowDao showDao, SeatDao seatDao, BookedSeatsDao bookedSeatDao, BookingDao bookingDao)
	{
		this.userDao = userDao;
		this.showDao = showDao;
		this.seatDao = seatDao;
		this.bookedSeatDao = bookedSeatDao;
		this.bookingDao = bookingDao;
	}

	@Override
	public TicketBookedDto bookTicket(TicketBookingDto dto) 
	{
		TicketBookedDto ticket = new TicketBookedDto();
		
		Optional<UserEntity> userOptional = userDao.findById(dto.getUserId());
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("User cannot be found");
		}
		else
		{
			UserEntity user = userOptional.get();
			Optional<ShowEntity> showOptional = showDao.findById(dto.getShowId());
			if(!showOptional.isPresent())
			{
				throw new ShowNotFoundException("Show is not Available");
			}
			else
			{
				ShowEntity show = showOptional.get();
				long venueId = show.getVenue().getVenueId();
				
				List<SeatEntity> seats = seatDao.findBySeatIdIn(dto.getSeatIds());
				if(seats.size() != dto.getSeatIds().size())
				{
					throw new InvalidSeatsException("seats are invalid");
				}
				else
				{
					for(SeatEntity s : seats)
					{
						if(s.getVenue().getVenueId() != venueId)
						{
							throw new InvalidSeatsException("seats are invalid");
						}
					}
					
					List<BookedSeatsEntity> bookedSeats = bookedSeatDao.findByShowShowIdAndSeatSeatIdIn(dto.getShowId(), dto.getSeatIds());
					if(!bookedSeats.isEmpty())
					{
						throw new InvalidSeatsException("seats are already booked");
					}
					
					Double totalAmt = show.getPrice() * seats.size();
					List<BookedSeatsEntity> newBookingSeats = new ArrayList<>();
					
 					BookingEntity booking = new BookingEntity(null, user, show , new ArrayList<>(), totalAmt, PaymentStatus.PAID, BookingStatus.SUCCESS);
					
 					for(SeatEntity s : seats)
 					{
 						BookedSeatsEntity bs = new BookedSeatsEntity(null, booking, s, show);
 						newBookingSeats.add(bs);
 					}
 					
 					try
 					{
 						booking.setBookedSeats(newBookingSeats);
 	 					BookingEntity newBooking = bookingDao.save(booking);
 	 					
 	 					List<String> seatNums = new ArrayList<>();
 	 					List<BookedSeatsEntity> newSeatsBooked = bookedSeatDao.saveAll(newBookingSeats);
 	 					
 	 					for(BookedSeatsEntity bs : newSeatsBooked)
 	 					{
 	 						seatNums.add(bs.getSeat().getSeatNo());
 	 					}
 	 					
 	 					ticket = new TicketBookedDto(newBooking.getBookingId(), show.getShowId(), seatNums, totalAmt, PaymentStatus.PAID, BookingStatus.SUCCESS);
 					}
 					catch(DataIntegrityViolationException e)
 					{
 						throw new InvalidSeatsException("seat are already booked");
 					}
				}
			}
		}
		
		return ticket;
	}

	@Override
	public CancelTicketDto cancalTicket(long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
