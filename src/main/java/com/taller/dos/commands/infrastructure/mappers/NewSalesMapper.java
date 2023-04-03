package com.taller.dos.commands.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.taller.dos.commands.infrastructure.dto.NewSalesDto;
import com.taller.dos.commons.entities.SalesEntity;

@Component
public class NewSalesMapper {

	public SalesEntity dtoToEntity(NewSalesDto dto) {
		return SalesEntity.builder()
				.states(dto.getStates())
				.flete(dto.getFlete())
				.productsEntity(dto.getProduct_id())
				.quantity(dto.getQuantity())
				.code(dto.getCode())
				.total_cost(dto.getTotal_cost())
				.total_value(dto.getTotal_value())
				.build();
	}
}
