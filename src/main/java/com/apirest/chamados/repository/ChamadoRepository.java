package com.apirest.chamados.repository;

import java.util.List;

import com.apirest.chamados.model.Chamado;
import com.apirest.chamados.model.Tecnico;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

    public List<Chamado> findAll(Specification<Chamado> and, Sort sort);

    @Query(value = "SELECT COUNT(*) FROM chamado c inner join tecnico t on t.id = c.id_tecnico where c.id_tecnico = :idTecnico and c.status_chamado = :status and t.ativo = true", nativeQuery = true)
    public Long countByStatusAndIdTecnico(@Param("status") Integer status, @Param("idTecnico") Long idUTecnico);

    @Query(value = "SELECT COUNT(*) FROM chamado c inner join usuario u on u.id = c.id_usuario where c.id_usuario = :idUsuario and c.status_chamado = :status and u.ativo = true", nativeQuery = true)
    public Long countByStatusAndIdUsuario(@Param("status") Integer status, @Param("idUsuario") Long idUsuario);

    public Tecnico findByIdUsuario(@Param("id") Long id);
}
