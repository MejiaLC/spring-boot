package com.taller.dos.queries.infrastructure;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductsPresentationDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private Integer quantity;
	
	private Float price;
}
