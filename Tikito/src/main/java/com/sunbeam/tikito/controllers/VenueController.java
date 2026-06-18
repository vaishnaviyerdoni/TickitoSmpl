package com.sunbeam.tikito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.tikito.serviceimpl.VenueService;

@RestController
@RequestMapping("/api/venue")
public class VenueController {
	
	
@Autowired
 private VenueService venueService;




}
