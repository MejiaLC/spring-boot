package com.taller.dos.queries.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.SalesEntity;

@Repository
public interface SalesQueryRepository extends JpaRepository<SalesEntity, Integer> {
	
	@Query(
			value = "SELECT * FROM VENTAS WHERE states iLIKE '%en_proceso%'",
			nativeQuery = true
		  )
	List<SalesEntity> findAllByStates();
}
