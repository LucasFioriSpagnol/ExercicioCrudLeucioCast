package com.crud.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.model.Usuario;
import com.crud.spring.repository.ListaRepository;
import com.crud.spring.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ListaRepository lista;

	@RequestMapping(value = "/usuario/{nome}/idade/{idade}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String salvarUsuario(@PathVariable String nome, @PathVariable int idade) {

		Usuario usuario = new Usuario();

		usuario.setNome(nome);

		usuario.setIdade(idade);

		usuarioRepository.save(usuario);

		return "Salvo o usuario " + nome + " idade " + idade;

	}

	@RequestMapping(value = "/usuario/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarTodos() {

		return lista.findAll();

	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Integer id) {

		usuarioRepository.deleteById(id);

		return new ResponseEntity<String>("Usuario " + id + " deletado", HttpStatus.OK);

	}

}