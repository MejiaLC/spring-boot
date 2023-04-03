package com.taller.dos.queries.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taller.dos.commons.entities.ProductsEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesPresentationDto {
	
	private String states;
	
	private Float flete;
	
	private String code;
	
	private Float total_cost;
	
	private Float total_value;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties(value = {"SalesPresentationDto", "hibernateLazyInitializer"})
	private ProductsEntity products;
}
