package com.app.fizbuzz.config.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "FIZZ_BUZZ", catalog = "FIZZ_BUZZ", name = "request_details")
public class RequestDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "remote_ip")
	private String remoteIp;
	@Column(name = "request_uri")
	private String requestUri;
	@Column(name = "request_method")
	private String requestMethod;

}
