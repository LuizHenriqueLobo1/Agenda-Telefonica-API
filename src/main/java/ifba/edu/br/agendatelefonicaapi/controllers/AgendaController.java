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

import ifba.edu.br.agendatelefonicaapi.models.Contato;
import ifba.edu.br.agendatelefonicaapi.dto.ContatoDto;
import ifba.edu.br.agendatelefonicaapi.dto.ContatoForm;
import ifba.edu.br.agendatelefonicaapi.repository.ContatoRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	public ContatoRepository repository;
	
	@GetMapping
	public List<ContatoDto> listarContatos() {
		return ContatoDto.converte(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
		repository.save(contato);
		return new ResponseEntity<Contato>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ContatoDto pegarContato(@PathVariable long id) {
		return new ContatoDto(repository.findById(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Contato> atualizar(@PathVariable long id, @RequestBody ContatoForm formContato) {
		formContato.atualiza(id, repository);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Contato> deletar(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}
}
