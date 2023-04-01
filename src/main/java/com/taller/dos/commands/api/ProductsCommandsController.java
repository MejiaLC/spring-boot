package com.taller.dos.commands.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.dos.commands.domain.services.ProductsCommandsService;
import com.taller.dos.commands.infrastructure.dto.NewProductsDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductsCommandsController {
	
	@Autowired
	private ProductsCommandsService productService;

	@PostMapping("/product")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody NewProductsDto newProductsDto, BindingResult result){
		
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error:" + error.getDefaultMessage()).toList();
			
			response.put("Errors", errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			productService.saveProduct(newProductsDto);
			return new ResponseEntity<>("Exito al guardar un producto", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
