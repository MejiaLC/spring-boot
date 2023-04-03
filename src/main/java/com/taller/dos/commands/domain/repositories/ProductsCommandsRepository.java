package com.taller.dos.commands.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.ProductsEntity;

@Repository
public interface ProductsCommandsRepository extends JpaRepository<ProductsEntity, Integer> {

	Optional<ProductsEntity> findById(Integer id);
}
