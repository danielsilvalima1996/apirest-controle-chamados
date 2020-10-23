package com.apirest.chamados.repository;

import java.util.List;

import com.apirest.chamados.model.Chamado;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {

    public List<Chamado> findAll(Specification<Chamado> and, Sort sort);
    
}
