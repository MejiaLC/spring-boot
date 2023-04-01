package com.taller.dos.queries.domain.services;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;

public interface ProductsQueryService {
	Maybe<?> findAll();
}
