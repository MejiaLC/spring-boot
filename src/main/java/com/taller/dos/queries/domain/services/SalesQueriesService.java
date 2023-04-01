package com.taller.dos.queries.domain.services;

import java.util.List;

import com.taller.dos.queries.infrastructure.dto.SalesPresentationDto;

import io.reactivex.rxjava3.core.Maybe;

public interface SalesQueriesService {

	Maybe<List<SalesPresentationDto>> findAll();
}
