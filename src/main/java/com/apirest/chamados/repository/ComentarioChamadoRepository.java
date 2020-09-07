package com.apirest.chamados.repository;

import com.apirest.chamados.model.ComentarioChamado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioChamadoRepository extends JpaRepository<ComentarioChamado,Long> {
    
}
