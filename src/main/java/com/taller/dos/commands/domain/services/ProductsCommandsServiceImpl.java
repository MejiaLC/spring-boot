package com.taller.dos.commands.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dos.commands.domain.repositories.ProductsCommandsRepository;
import com.taller.dos.commands.infrastructure.dto.NewProductsDto;
import com.taller.dos.commands.infrastructure.mappers.NewProductMapper;
import com.taller.dos.commons.entities.ProductsEntity;

@Service
public class ProductsCommandsServiceImpl implements ProductsCommandsService {
	
	@Autowired
	private ProductsCommandsRepository productsCommandRepository;
	
	@Autowired
	private NewProductMapper newProductMapper;

	@Override
	public void saveProduct(NewProductsDto newProductDto) throws Exception {
	    ProductsEntity entity = newProductMapper.dtoToEntity(newProductDto);
	    
	    productsCommandRepository.save(entity);
	}

	@Override
	public void updateProduct(String code) throws Exception {
		
	}
}
