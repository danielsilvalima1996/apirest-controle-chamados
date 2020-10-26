package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.apirest.chamados.config.JwtTokenUtil;
import com.apirest.chamados.model.Chamado;
import com.apirest.chamados.model.Home;
import com.apirest.chamados.model.Tecnico;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.ChamadoRepository;
import com.apirest.chamados.specification.ChamadoSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TipoChamadoService tipoChamadoService;

	@Autowired
	private SubTipoChamadoService subTipoChamadoService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private TecnicoService tecnicoService;

	public List<Chamado> findAll(
		Long id, 
		Long idUsuario, 
		Integer statusChamado,
		Long idTipoChamado,
		Long idSubtipoChamado,
		Long idTecnico,
		String descricao) throws Exception {
		List<Chamado> chamado = new ArrayList<>();
		chamado = this.repository.findAll(
			where(
				ChamadoSpecification.descricaoChamado(descricao)
				.and(ChamadoSpecification.idChamado(id))
				.and(ChamadoSpecification.idUsuarioChamado(idUsuario))
				.and(ChamadoSpecification.statusChamadoChamado(statusChamado))
				.and(ChamadoSpecification.idTipoChamadoChamado(idTipoChamado))
				.and(ChamadoSpecification.idSubtipoChamadoChamado(idSubtipoChamado))
				.and(ChamadoSpecification.idTecnicoChamado(idTecnico))
			), Sort.by(Direction.DESC, "modificado")
		);

		if (chamado.size() == 0) {
			throw new Exception("Não há dados");
		}
		chamado.forEach(item -> item.getIdUsuario().setSenha(""));
		return chamado;
	}

	public Optional<Chamado> findById(Long id) throws Exception {
		var chamado = repository.findById(id);
		if (!chamado.isPresent()) {
			throw new Exception("Chamado com o id " + id + " não encontrado");
		}
		chamado.get().getIdUsuario().setSenha("");
		return chamado;
	}

	public Chamado createChamado(Chamado chamado) throws Exception {
		var usuario = this.usuarioService.findById(chamado.getIdUsuario().getId());
		var tipoChamado = this.tipoChamadoService.findById(chamado.getIdTipoChamado().getId());
		var subTipoChamado = this.subTipoChamadoService.findById(chamado.getIdSubtipoChamado().getId());
		if (usuario == null || tipoChamado == null || subTipoChamado == null) {
			throw new Exception("Falta informação");
		}
		chamado.setDataAbertura(new Date());
		chamado.setStatusChamado(0);
		var novo = this.repository.save(chamado);
		novo.getIdUsuario().setSenha("");
		return novo;
	}

	public Chamado alterChamado(Chamado chamado) throws Exception {
		var nova = this.repository.findById(chamado.getId());
		if (!nova.isPresent()) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não encontrado, impossíve atualizar");
		} else if (nova.get().getStatusChamado() == 2) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está fechado, não pode ser alterado");
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está inderifido, não pode ser alterado");
		}
		Integer status = (chamado.getIdTecnico() == null) ? 0 : 1;
		chamado.setStatusChamado(status);
		return this.salvarChamado(chamado);
	}

	public Chamado finalizaChamado(Chamado chamado) throws Exception {
		var nova = this.repository.findById(chamado.getId());
		if (!nova.isPresent()) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não encontrado, impossíve atualizar");
		} else if (nova.get().getStatusChamado() == 2) {
			throw new Exception("Chamado com o id " + chamado.getId() + " já foi finalizado");
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está inderifido, não pode ser alterado");
		} else if (chamado.getIdTecnico() == null) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não tem técnico, impossível finalizar");
		}
		chamado.setStatusChamado(2);
		chamado.setDataFechamento(new Date());
		return this.salvarChamado(chamado);
	}

	public Chamado indeferidoChamado(Chamado chamado) throws Exception {
		var nova = this.repository.findById(chamado.getId());
		if (!nova.isPresent()) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não encontrado, impossíve atualizar");
		} else if (nova.get().getStatusChamado() == 2) {
			throw new Exception("Chamado com o id " + chamado.getId() + " já foi finalizado, não pode ser alterado");
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está inderifido");
		}
		chamado.setStatusChamado(3);
		chamado.setDataFechamento(new Date());
		return this.salvarChamado(chamado);
	}

	private Chamado salvarChamado(Chamado chamado) {
		var novo = this.repository.save(chamado);
		novo.getIdUsuario().setSenha("");
		return novo;
	}

	public void deleteChamado(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Chamado com o id " + id + " não encontrado, impossível excluir");
		}
		this.repository.deleteById(id);
	}

	public List<Home> findHome() {
		List<Home> home = new ArrayList<Home>();
		String email;
		String jwtToken;
		final String requestTokenHeader = this.request.getHeader("Authorization");
		jwtToken = requestTokenHeader.substring(7);
		email = jwtTokenUtil.getUsernameFromToken(jwtToken);
		Usuario usuario = this.usuarioService.findByEmail(email);
		Tecnico tecnico = this.tecnicoService.findByIdUsuario(usuario.getId());
		if (tecnico != null) {
			home.add(new Home("Em Aberto", 0, "color-08", this.repository.countByStatusAndIdTecnico(0, tecnico.getId())));
			home.add(new Home("Em Análise", 1, "color-01", this.repository.countByStatusAndIdTecnico(1, tecnico.getId())));
			home.add(new Home("Fechado", 2, "color-11", this.repository.countByStatusAndIdTecnico(2, tecnico.getId())));
			home.add(new Home("Indeferido", 3, "color-07", this.repository.countByStatusAndIdTecnico(3, tecnico.getId())));
		} else {
			home.add(new Home("Em Aberto", 0, "color-08", this.repository.countByStatusAndIdUsuario(0, usuario.getId())));
			home.add(new Home("Em Análise", 1, "color-01", this.repository.countByStatusAndIdUsuario(1, usuario.getId())));
			home.add(new Home("Fechado", 2, "color-11", this.repository.countByStatusAndIdUsuario(2, usuario.getId())));
			home.add(new Home("Indeferido", 3, "color-07", this.repository.countByStatusAndIdUsuario(3, usuario.getId())));
		}

		return home;
	}

}
