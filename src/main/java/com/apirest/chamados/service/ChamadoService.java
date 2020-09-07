package com.apirest.chamados.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.apirest.chamados.model.Chamado;
import com.apirest.chamados.repository.ChamadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Chamado> findAll() throws Exception {
		// List<Regra> regra = new ArrayList<>();
		// regra = repository.findAll(where(RegraSpecification.idRegra(id))
		// .and(RegraSpecification.descricaoRegra(descricao)).and(RegraSpecification.ativoRegra(ativo)));
		// if (regra.size() == 0) {
		// throw new Exception("Não há dados");
		// }
		// return regra;
		var novo = this.repository.findAll();
		novo.forEach(item -> item.getIdUsuario().setSenha(""));
		return novo;
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
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está fechado, não pode ser alterado");
		} else if (nova.get().getStatusChamado() == 4) {
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
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " já foi finalizado");
		} else if (nova.get().getStatusChamado() == 4) {
			throw new Exception("Chamado com o id " + chamado.getId() + " está inderifido, não pode ser alterado");
		} else if (chamado.getIdTecnico() == null) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não tem técnico, impossível finalizar");
		}
		chamado.setStatusChamado(2);
		chamado.setDataFechamento(new Date());
		return this.salvarChamado(chamado);
	}

	public Chamado indefiridoChamado(Chamado chamado) throws Exception {
		var nova = this.repository.findById(chamado.getId());
		if (!nova.isPresent()) {
			throw new Exception("Chamado com o id " + chamado.getId() + " não encontrado, impossíve atualizar");
		} else if (nova.get().getStatusChamado() == 3) {
			throw new Exception("Chamado com o id " + chamado.getId() + " já foi finalizado, não pode ser alterado");
		} else if (nova.get().getStatusChamado() == 4) {
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
}
