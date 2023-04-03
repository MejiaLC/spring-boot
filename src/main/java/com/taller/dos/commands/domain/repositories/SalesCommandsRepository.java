package com.taller.dos.commands.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.SalesEntity;

import jakarta.transaction.Transactional;

@Repository
public interface SalesCommandsRepository extends JpaRepository<SalesEntity, Integer> {

	Optional<SalesEntity> findByCode(String code);
	
	@Transactional
	@Modifying
	@Query(
			value = "UPDATE VENTAS SET states = ? WHERE code = ?",
			nativeQuery = true
		  )
	void UpdateProductState(String states, String code);
}
