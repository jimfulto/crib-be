package com.globorealtors.crib.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globorealtors.crib.models.Crib;
import com.globorealtors.crib.repositories.CribRepository;

@RestController
@RequestMapping("/api/v1/cribs")
public class CribsController {
	@Autowired
	private CribRepository cribRepository;
	
	
	@GetMapping
	public List<Crib> list() {
		return cribRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Crib crib) {
		cribRepository.save(crib);
	}
	
	@GetMapping("{id}")
	public Crib get(@PathVariable("id") long id) {
		return cribRepository.getOne(id);
	}
}
