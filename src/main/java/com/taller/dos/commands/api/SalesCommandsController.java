package com.taller.dos.commands.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.dos.commands.domain.services.SalesCommandsService;
import com.taller.dos.commands.infrastructure.dto.NewSalesDto;
import com.taller.dos.commands.infrastructure.dto.UpdateSalesDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SalesCommandsController {

	@Autowired
	private SalesCommandsService salesCommandsService;

	@PostMapping("/sale")
	public ResponseEntity<?> saveSale(@Valid @RequestBody NewSalesDto dto, BindingResult result) {

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error:" + " " + error.getDefaultMessage()).toList();
			
			response.put("Errors", errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			salesCommandsService.saveSale(dto);
			return new ResponseEntity<>("Venta guardada con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/sale/{code}")
	public ResponseEntity<?> updateSale(@Valid @RequestBody UpdateSalesDto dto, BindingResult result, @PathVariable String code){
		
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error:" + " " + error.getDefaultMessage()).toList();
			
			response.put("Errors", errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			salesCommandsService.updateSale(code, dto);
			return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
