package com.fabricioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricioalves.cursomc.domain.Produto;
import com.fabricioalves.cursomc.repositories.ProdutoRepository;
import com.fabricioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado, Id: "+ id + " Classe: " + Produto.class.getName()));
	}
	
}
