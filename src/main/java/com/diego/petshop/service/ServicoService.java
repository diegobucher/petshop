package com.diego.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diego.petshop.domain.Servico;
import com.diego.petshop.repository.ServicoRepository;
import com.diego.petshop.service.exceptions.DataIntegrityException;
import com.diego.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;

	public Servico find(Integer id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
	}

	public Servico insert(Servico servico) {
		servico.setId(null);
		return repository.save(servico);
	}

	public Servico update(Servico servico) {
		find(servico.getId());
		return repository.save(servico);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Serviço possui produtos, não é possível deletar!");
		}
	}

	public List<Servico> findAll() {
		return repository.findAll();
	}

}
