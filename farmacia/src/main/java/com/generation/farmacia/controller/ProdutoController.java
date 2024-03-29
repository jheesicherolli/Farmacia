package com.generation.farmacia.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.ProdutoModel;
import com.generation.farmacia.repository.ProdutoRepository;

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> buscarTodosDados(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> trazerId (@PathVariable long id){
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/consumidor/{consumidor}")
	public ResponseEntity<List<ProdutoModel>> trazerconsumidor (@PathVariable String consumidor){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(consumidor));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> adicionarproduto (@Valid @RequestBody ProdutoModel produto ){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
 } 
	@PutMapping
	public ResponseEntity<ProdutoModel> atualizarproduto (@Valid @RequestBody ProdutoModel produto){
		return ResponseEntity.ok(repository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void deletarId (@PathVariable long id) {
		repository.deleteById(id);
	}
}


