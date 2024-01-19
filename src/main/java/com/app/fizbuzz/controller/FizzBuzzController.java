package com.app.fizbuzz.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fizbuzz.dto.RequestDto;
import com.app.fizbuzz.service.FizzBuzzService;

@RestController
@RequestMapping("/api/v1")
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService fizzBuzzService;

	@GetMapping("/status")
	public String checkStatus() {
		return "app running";
	}

	@PostMapping("/generate-sequence")
	public ResponseEntity<HashMap<String, String>> generateSequence(@RequestBody RequestDto requestDto) {
		HashMap<String, String> resultMap = new HashMap<>();
		try {
			if (requestDto != null) {
				String result = fizzBuzzService.getStringData(requestDto);
				if (result != null && !result.equals("")) {
					resultMap.put("result", result);
				} else {
					resultMap.put("error", "error occured");
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultMap);
				}

				return ResponseEntity.status(HttpStatus.OK).body(resultMap);

			} else {
				resultMap.put("error", "bad request");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMap);
			}
		} catch (Exception e) {
			resultMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
