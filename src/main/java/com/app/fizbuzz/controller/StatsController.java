package com.app.fizbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fizbuzz.config.service.RequestDetailsService;
import com.app.fizbuzz.dto.StatisticsDto;

@RestController
public class StatsController {
	@Autowired
	private RequestDetailsService requestDetailsService;

	@GetMapping("/statistics")
	public ResponseEntity<Object> getStatistics() {
		StatisticsDto statisticsDto = requestDetailsService.getStatistics();
		if (statisticsDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(statisticsDto);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}
