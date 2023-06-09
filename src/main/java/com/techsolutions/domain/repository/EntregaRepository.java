package com.techsolutions.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techsolutions.domain.Model.Entrega;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
