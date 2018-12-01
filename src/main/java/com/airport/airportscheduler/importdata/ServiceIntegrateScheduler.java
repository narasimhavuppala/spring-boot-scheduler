package com.airport.airportscheduler.importdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.airport.airportscheduler.repo.AirportDao;
import com.airport.airportscheduler.service.AirportService;

@Component
public class ServiceIntegrateScheduler {

	@Autowired
	AirportService airportService;
	
	@Autowired
	AirportDao airportDao;

	@Scheduled(cron = "${serviceintegration.cron.expression}")
	public void processDetails() {
		// Retrieve All ids around 600
		Set<Integer> airportIds = airportService.getAllAirportIds();
		List<String> detailRecords=new ArrayList<>();
		airportIds.stream().forEach(x -> {
			detailRecords.add(airportService.processEachAirportId(x));
		});
		// push it to database
		detailRecords.forEach(x->{
			airportDao.persistRecord(x);
		});
	}

}
