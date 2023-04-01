package com.taller.dos.queries.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.SalesEntity;

@Repository
public interface SalesQueryRepository extends JpaRepository<SalesEntity, Integer> {

}
