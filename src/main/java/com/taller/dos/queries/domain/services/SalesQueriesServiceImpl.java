package com.taller.dos.queries.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dos.queries.domain.repositories.SalesQueryRepository;
import com.taller.dos.queries.infrastructure.dto.SalesPresentationDto;
import com.taller.dos.queries.infrastructure.mappers.PresentationSalesMapper;

import io.reactivex.rxjava3.core.Maybe;

@Service
public class SalesQueriesServiceImpl implements SalesQueriesService {
	
	@Autowired
	private SalesQueryRepository salesQueryRepository;
	
	@Autowired
	private PresentationSalesMapper presentationSalesMapper;

	@Override
	public Maybe<List<SalesPresentationDto>> findAll() {		
		return Maybe.just(salesQueryRepository.findAll())
				.switchIfEmpty(Maybe.error(new Exception("No hay ventas para mostrar")))
				.map(list -> presentationSalesMapper.entitiesToDto(list));
	}

	@Override
	public Maybe<List<SalesPresentationDto>> findAllByStates() {
		return Maybe.just(salesQueryRepository.findAllByStates())
				.switchIfEmpty(Maybe.error(new Exception("No hay ventas para mostrar")))
				.map(list -> presentationSalesMapper.entitiesToDto(list));
	}
}
