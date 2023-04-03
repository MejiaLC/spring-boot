package com.taller.dos.commands.domain.services;

import com.taller.dos.commands.infrastructure.dto.NewSalesDto;
import com.taller.dos.commands.infrastructure.dto.UpdateSalesDto;

public interface SalesCommandsService {

	void saveSale(NewSalesDto dto) throws Exception;
	
	void updateSale(String code, UpdateSalesDto dto) throws Exception;
}
