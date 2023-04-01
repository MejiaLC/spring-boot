package com.taller.dos.queries.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.ProductsEntity;

@Repository
public interface ProductsQueryRepository extends JpaRepository<ProductsEntity, Integer> {

}
