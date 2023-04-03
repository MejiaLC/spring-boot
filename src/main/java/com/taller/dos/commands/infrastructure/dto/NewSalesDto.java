package com.taller.dos.commands.infrastructure.dto;
import com.taller.dos.commons.entities.ProductsEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewSalesDto {
	
	@NotNull(message = "El campo states debe ser obligatorio")
	private String states;
	
	@Min(value = 10000, message = "El campo flete debe tener un valor minimo de 10000")
	@NotNull(message = "El campo flete debe ser obligatorio")
	private Float flete;
		
	private Float total_cost;
	
	private Float total_value;
	
	@NotNull(message = "El campo code debe ser obligatorio")
	private String code;
	
	private Integer quantity;
		
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductsEntity product_id;
	
	@PrePersist
	public void prePersist() {
		this.flete = 10000f;
		this.quantity = 1;
	}
}
