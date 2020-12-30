package com.api.mercadoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.mercadoria.model.Mercadoria;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long>{
	Mercadoria findById(long id);
}
