package com.api.mercadoria.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.mercadoria.dto.MercadoriaDto;
import com.api.mercadoria.model.Mercadoria;
import com.api.mercadoria.repository.MercadoriaRepository;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {

	@Autowired
	MercadoriaRepository mr;

	// Listando todas as informações da tabela
	@GetMapping
	public List<MercadoriaDto> listar() {
		List<Mercadoria> mercadoria = mr.findAll();
		return MercadoriaDto.converter(mercadoria);
	}

	// Adicionando informação na tabela
	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public Mercadoria adicionar(@RequestBody @Valid Mercadoria mercadoria) {
		return mr.save(mercadoria);
	}

	// Busca informação pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Mercadoria> buscar(@PathVariable long id) {
		Mercadoria mercadoriaEncontrada = mr.findById(id);

		if (mercadoriaEncontrada == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mercadoriaEncontrada);
	}

	// Altera informação, informando o id
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Mercadoria> alterar(@PathVariable long id, @RequestBody @Valid Mercadoria mercadoria) {
		Mercadoria mercadoriaEncontrada = mr.findById(id);

		if (mercadoriaEncontrada == null) {
			ResponseEntity.notFound().build();
		}
		// no método receberemos "mercadoria" que está no parâmetro do método alterar,
		// receberemos "mercadoriaEncontrada" que recebe a informação do banco e
		// ignoraremos o "id", para que ele não seja alterado.
		BeanUtils.copyProperties(mercadoria, mercadoriaEncontrada, "id");

		mercadoriaEncontrada = mr.save(mercadoriaEncontrada);

		return ResponseEntity.ok(mercadoriaEncontrada);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		Mercadoria mercadoriaEncontrada = mr.findById(id);

		if (mercadoriaEncontrada == null) {
			ResponseEntity.notFound().build();
		}
		mr.delete(mercadoriaEncontrada);

		// O noContent ira certificar o sucesso da operação, porém com conteúdo vazio.
		return ResponseEntity.noContent().build();
	}
}
