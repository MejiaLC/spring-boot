package com.taller.dos.commands.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.ProductsEntity;

@Repository
public interface ProductsCommandsRepository extends JpaRepository<ProductsEntity, Integer> {

}
