package com.taller.dos.queries.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.dos.queries.domain.services.SalesQueriesService;

import io.reactivex.rxjava3.core.Maybe;

@RestController
@RequestMapping("/api")
public class SalesQueryController {

	@Autowired
	private SalesQueriesService salesQueryService;

	@GetMapping("/list")
	public Maybe<ResponseEntity<?>> findAll() {
		return salesQueryService.findAll().map(list -> new ResponseEntity<>(list, HttpStatus.OK));
	}
	
	@GetMapping("/list_pendings")
	public Maybe<ResponseEntity<?>> findAllByStates() {
		return salesQueryService.findAllByStates().map(list -> new ResponseEntity<>(list, HttpStatus.OK));
	}
}
