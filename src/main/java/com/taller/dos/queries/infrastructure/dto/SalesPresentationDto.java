package com.taller.dos.queries.infrastructure.dto;

import com.taller.dos.commands.domain.vo.SaleState;
import com.taller.dos.commons.entities.ProductsEntity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SalesPresentationDto {
	
	@Enumerated(EnumType.STRING)
	private SaleState states;
	
	private Float flete;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductsEntity productsEntity;
}
