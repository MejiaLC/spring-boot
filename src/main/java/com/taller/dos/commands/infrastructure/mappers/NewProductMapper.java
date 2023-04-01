package com.taller.dos.commands.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.taller.dos.commands.infrastructure.dto.NewProductsDto;
import com.taller.dos.commons.entities.ProductsEntity;

@Component
public class NewProductMapper {

	public ProductsEntity dtoToEntity(NewProductsDto dto) {
		return ProductsEntity.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.description(dto.getDescription())
				.price(dto.getPrice())
				.build();
	}
}
