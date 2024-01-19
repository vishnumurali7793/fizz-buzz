package com.app.fizbuzz.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.fizbuzz.config.entities.RequestDetails;
import com.app.fizbuzz.config.entities.repo.RequestDetailsRepository;
import com.app.fizbuzz.config.service.RequestDetailsService;
import com.app.fizbuzz.dto.StatisticsDto;

@Service
@Transactional(readOnly = true)
public class RequestDetailsServiceImpl implements RequestDetailsService {

	@Autowired
	RequestDetailsRepository requestDetailsRepository;
	
	StatisticsDto statisticsDto;

	@Override
	@Transactional(readOnly = false)
	public boolean saveRequestDetails(RequestDetails requestDetails) {
		if (requestDetails != null) {
			if (requestDetailsRepository.save(requestDetails) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public StatisticsDto getStatistics() {
		Pageable pageable = PageRequest.of(0, 1);
		List<Object[]> resultArray = requestDetailsRepository.findUriAndCountByRequest(pageable);
		if (resultArray != null && resultArray.size() > 0) {
			statisticsDto = new StatisticsDto();
			resultArray.stream().forEach(stat -> {
				statisticsDto.setMostUsedRequest(String.valueOf(stat[0]));
				statisticsDto.setMostUsedRequestCount(Integer.valueOf(stat[1].toString()));
			});
		}
		return statisticsDto;
	}

}
