package com.diego.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diego.petshop.domain.Pessoa;
import com.diego.petshop.repository.PessoaRepository;
import com.diego.petshop.service.exceptions.DataIntegrityException;
import com.diego.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	public Pessoa insert(Pessoa pessoa) {
		pessoa.setId(null);
		return repository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		find(pessoa.getId());
		return repository.save(pessoa);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pessoa não pode ser deletada!");
		}
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

}
