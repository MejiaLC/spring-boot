package com.taller.dos.queries.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.SalesEntity;
import com.taller.dos.queries.infrastructure.dto.SalesPresentationDto;

@Repository
public interface SalesQueryRepository extends JpaRepository<SalesEntity, Integer> {

	@Query(
			value = "SELECT * FROM VENTAS",
			nativeQuery = true)
	SalesPresentationDto findAllJoin();
}
