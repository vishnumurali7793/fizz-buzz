package com.app.fizbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.fizbuzz.controller.FizzBuzzController;
import com.app.fizbuzz.dto.RequestDto;
import com.app.fizbuzz.service.FizzBuzzService;

@SpringBootTest
class FizzBuzzApplicationTests {

	@Autowired
	private FizzBuzzController fizzBuzzController;
	@Autowired
	private FizzBuzzService fizzBuzzService;

	private RequestDto requestDto;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAppStatus() {
		String result = fizzBuzzController.checkStatus();
		assertEquals("app running", result);

	}

	@Test
	public void testGetStringData() {
		requestDto = new RequestDto(3, 5, 15, "fizz", "buzz");
		String result = fizzBuzzService.getStringData(requestDto);
		String expectedResult = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,";
		assertEquals(expectedResult, result);

	}

}
