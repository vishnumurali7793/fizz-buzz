package com.app.fizbuzz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
	private Integer int1;
	private Integer int2;
	private Integer limit;
	private String str1;
	private String str2;

}
