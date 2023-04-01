package com.taller.dos.commands.domain.services;

import com.taller.dos.commands.infrastructure.dto.NewProductsDto;

public interface ProductsCommandsService {
	
	void saveProduct(NewProductsDto newProductDto) throws Exception;
	
	void updateProduct(String code) throws Exception;
}
