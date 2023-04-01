package com.taller.dos.commands.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dos.commands.domain.repositories.SalesCommandsRepository;
import com.taller.dos.commands.infrastructure.dto.NewSalesDto;

@Service
public class SalesCommandsServiceImpl implements SalesCommandsService {
	
	@Autowired
	private SalesCommandsRepository salesCommandsRepository;

	@Override
	public void saveSale(NewSalesDto dto) throws Exception {
		
	}

	@Override
	public void updateSale() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
