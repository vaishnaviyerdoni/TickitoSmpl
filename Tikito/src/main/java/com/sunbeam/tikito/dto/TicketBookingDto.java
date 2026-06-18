package com.sunbeam.tikito.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//request dto
public class TicketBookingDto
{
	private Long userId;
	private Long showId;
	private List<Long> seatIds; 
}
