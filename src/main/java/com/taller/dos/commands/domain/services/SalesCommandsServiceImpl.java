package com.taller.dos.commands.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dos.commands.domain.repositories.ProductsCommandsRepository;
import com.taller.dos.commands.domain.repositories.SalesCommandsRepository;
import com.taller.dos.commands.infrastructure.dto.NewSalesDto;
import com.taller.dos.commands.infrastructure.dto.UpdateSalesDto;
import com.taller.dos.commands.infrastructure.mappers.NewSalesMapper;
import com.taller.dos.commons.entities.ProductsEntity;
import com.taller.dos.commons.entities.SalesEntity;

@Service
public class SalesCommandsServiceImpl implements SalesCommandsService {

	@Autowired
	private SalesCommandsRepository salesCommandsRepository;

	@Autowired
	private ProductsCommandsRepository productsCommandsRepository;

	@Autowired
	private NewSalesMapper newSalesMapper;

	@Override
	public void saveSale(NewSalesDto dto) throws Exception {

		if (salesCommandsRepository.findByCode(dto.getCode()).isPresent()) {
			throw new Exception("El codigo de la venta ingresado ya existe, ingresa otro codigo diferente");
		}

		List<String> validStates = new ArrayList<>();

		validStates.add("EN_PROCESO");
		validStates.add("DESPACHADA");
		validStates.add("CANCELADA");

		List<String> foundState = validStates.stream()
				.filter(state -> state.toLowerCase().equals(dto.getStates().toLowerCase()))
				.collect(Collectors.toList());

		if (foundState.isEmpty()) {
			throw new Exception(
					"El estado ingresado no es permitido, solo debes ingresar los estados: EN_PROCESO, DESPACHADA O CANCELADA");
		}

		Optional<ProductsEntity> product = productsCommandsRepository.findById(dto.getProduct_id().getId());

		if (!product.isPresent()) {
			throw new Exception("El producto con el id: " + dto.getProduct_id().getId() + " no existe");
		}

		Float total_cost = product.get().getPrice() * dto.getQuantity();

		if (total_cost > 100000) {
			dto.setFlete(0f);
		}

		Float iva_19 = (total_cost * 19) / 100;
		Float total_value = iva_19 + dto.getFlete();

		SalesEntity entity = newSalesMapper.dtoToEntity(dto);

		entity.setProductsEntity(new ProductsEntity(dto.getProduct_id().getId()));
		entity.setTotal_cost(total_cost);
		entity.setTotal_value(total_value);

		salesCommandsRepository.save(entity);
	}

	@Override
	public void updateSale(String code, UpdateSalesDto dto) throws Exception {

		if (!salesCommandsRepository.findByCode(code).isPresent()) {
			throw new Exception("El codigo de la venta no existe, no es posible actualizar una venta inexistente");
		}

		List<String> validStates = new ArrayList<>();

		validStates.add("DESPACHADA");
		validStates.add("CANCELADA");
		
		List<String> foundState = validStates.stream()
				.filter(state -> state.toLowerCase().equals(dto.getStates().toLowerCase()))
				.collect(Collectors.toList());

		if (foundState.isEmpty()) {
			throw new Exception(
					"El estado ingresado no es permitido, solo debes ingresar los estados: DESPACHADA O CANCELADA");
		}

		salesCommandsRepository.UpdateProductState(dto.getStates(), code);
	}

}
