package ifba.edu.br.agendatelefonicaapi.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ifba.edu.br.agendatelefonicaapi.models.Numero;
import ifba.edu.br.agendatelefonicaapi.dto.NumeroDto;
import ifba.edu.br.agendatelefonicaapi.dto.NumeroForm;
import ifba.edu.br.agendatelefonicaapi.repository.NumeroRepository;

@RestController
@RequestMapping("/numeros")
public class NumeroController {

	@Autowired
	public NumeroRepository repository;

	@GetMapping
	public List<NumeroDto> listarContatos() {
		return NumeroDto.converte(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<Numero> criarContato(@RequestBody Numero numero) {
		repository.save(numero);
		return new ResponseEntity<Numero>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public NumeroDto pegarContato(@PathVariable long id) {
		return new NumeroDto(repository.findById(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Numero> atualizar(@PathVariable long id, @RequestBody NumeroForm formNumero){
		formNumero.atualiza(id, repository);
		return new ResponseEntity<Numero>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Numero> deletar(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<Numero>(HttpStatus.OK);
	}
}
