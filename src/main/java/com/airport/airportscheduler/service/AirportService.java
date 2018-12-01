package com.airport.airportscheduler.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class AirportService {
	
	public Set<Integer> getAllAirportIds(){
		Set<Integer> ids=new HashSet<>();
		IntStream.range(0, 600).forEachOrdered(x->{
			ids.add(x);
		});
		return ids;
	}
	
	public String processEachAirportId(Integer id) {
		try {
			System.out.println("Processing detail each record=" + id);
			return "true";
		}
		catch(Exception e) {
			return "false";
		}
	}

}
