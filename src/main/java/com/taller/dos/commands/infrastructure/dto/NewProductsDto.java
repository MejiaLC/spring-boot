package com.taller.dos.commands.infrastructure.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewProductsDto {
	
	@NotBlank(message = "El codigo del producto es obligatorio")
	private String code;
	
	@NotBlank(message = "El nombre del producto es obligatorio")
	private String name;
	
	@NotBlank(message = "La descripción del producto es obligatoria")
	private String description;
	
	private Float price;
}
