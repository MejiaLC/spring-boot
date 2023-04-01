package com.taller.dos.commands.infrastructure.dto;

import com.taller.dos.commands.domain.vo.SaleState;
import com.taller.dos.commons.entities.ProductsEntity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewSalesDto {
	
	@Enumerated(EnumType.STRING)
	private SaleState states;
	
	@NotBlank(message = "El campo flete debe ser obligatorio")
	private Float flete;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductsEntity productsEntity;
	
	@PrePersist
	public void prePersist() {
		this.flete = 10000f;
	}
}
