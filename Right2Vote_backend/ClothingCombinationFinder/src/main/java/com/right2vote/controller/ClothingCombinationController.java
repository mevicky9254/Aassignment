package com.right2vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.right2vote.service.ClothingCombinationService;

@RestController
@CrossOrigin(origins="*")
public class ClothingCombinationController {
	
	@Autowired
	private ClothingCombinationService cService;
	
	
	@GetMapping("/combination")
	public ResponseEntity<List<String>>getCombination(@RequestParam("budget") Double budget) throws Exception{
		 
		List<String> resultList=cService.getCombinations(budget);
		
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}

}
