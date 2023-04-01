package com.taller.dos.commons.entities;

import com.taller.dos.commands.domain.vo.SaleState;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventas")
public class SalesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private SaleState states;
	
	private Float flete;
	
	private Integer quantity;
	
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductsEntity productsEntity;
}
