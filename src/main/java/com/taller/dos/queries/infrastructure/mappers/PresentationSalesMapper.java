package com.taller.dos.queries.infrastructure.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.taller.dos.commons.entities.SalesEntity;
import com.taller.dos.queries.infrastructure.dto.SalesPresentationDto;

@Component
public class PresentationSalesMapper {

	public SalesPresentationDto entityToDto(SalesEntity entity) {
		return SalesPresentationDto.builder()
				.states(entity.getStates())
				.flete(entity.getFlete())
				.productsEntity(entity.getProductsEntity())
				.build();
	}
	
	public List<SalesPresentationDto> entitiesToDto(List<SalesEntity> entities){
		return entities.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());
	}
}
