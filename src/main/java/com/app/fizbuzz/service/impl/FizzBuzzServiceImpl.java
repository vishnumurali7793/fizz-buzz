package com.app.fizbuzz.service.impl;

import org.springframework.stereotype.Service;

import com.app.fizbuzz.dto.RequestDto;
import com.app.fizbuzz.service.FizzBuzzService;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Override
	public String getStringData(RequestDto requestDto) {
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 1; i <= requestDto.getLimit(); i++) {
			if (i % requestDto.getInt1() == 0 && i % requestDto.getInt2() == 0) {
				stringBuilder.append(requestDto.getStr1()).append(requestDto.getStr2());
			} else if (i % requestDto.getInt1() == 0) {
				stringBuilder.append(requestDto.getStr1());
			} else if (i % requestDto.getInt2() == 0) {
				stringBuilder.append(requestDto.getStr2());
			} else {
				stringBuilder.append(String.valueOf(i));
			}
			stringBuilder.append(",");

		}
		return stringBuilder.toString();
	}

}
