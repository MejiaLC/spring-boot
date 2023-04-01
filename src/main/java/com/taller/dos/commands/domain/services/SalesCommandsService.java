package com.taller.dos.commands.domain.services;

import com.taller.dos.commands.infrastructure.dto.NewSalesDto;

public interface SalesCommandsService {

	void saveSale(NewSalesDto dto) throws Exception;
	
	void updateSale() throws Exception;
}
