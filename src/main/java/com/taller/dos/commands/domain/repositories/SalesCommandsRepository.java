package com.taller.dos.commands.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.dos.commons.entities.SalesEntity;

@Repository
public interface SalesCommandsRepository extends JpaRepository<SalesEntity, Integer> {

}
