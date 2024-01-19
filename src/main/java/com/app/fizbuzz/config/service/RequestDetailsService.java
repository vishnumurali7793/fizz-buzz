package com.app.fizbuzz.config.service;

import com.app.fizbuzz.config.entities.RequestDetails;
import com.app.fizbuzz.dto.StatisticsDto;

public interface RequestDetailsService {

	boolean saveRequestDetails(RequestDetails requestDetails);

	StatisticsDto getStatistics();

}
