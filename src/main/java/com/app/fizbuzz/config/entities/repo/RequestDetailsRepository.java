package com.app.fizbuzz.config.entities.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.fizbuzz.config.entities.RequestDetails;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Long> {

	@Query("SELECT rd.requestUri, COUNT(rd.requestUri) FROM RequestDetails rd GROUP BY rd.requestUri ORDER BY COUNT(rd) DESC")
	List<Object[]> findUriAndCountByRequest(Pageable pageable);

}
