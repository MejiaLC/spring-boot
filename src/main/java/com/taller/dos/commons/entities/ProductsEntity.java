package com.taller.dos.commons.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductsEntity {
	
	public ProductsEntity(Integer id) {
		this.id = id;
	}
			
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	private String name;
		
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "products", targetEntity = SalesEntity.class)
	private Set<SalesEntity> salesEntity;*/
	
	private String description;
	
	private Float price;

}
