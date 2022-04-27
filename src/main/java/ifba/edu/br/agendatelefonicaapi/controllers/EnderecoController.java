package ifba.edu.br.agendatelefonicaapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import ifba.edu.br.agendatelefonicaapi.models.Endereco;
import ifba.edu.br.agendatelefonicaapi.dto.EnderecoDto;
import ifba.edu.br.agendatelefonicaapi.dto.EnderecoForm;
import ifba.edu.br.agendatelefonicaapi.repository.ContatoRepository;
import ifba.edu.br.agendatelefonicaapi.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoRepository repository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping
	public List<EnderecoDto> listarEnderecos() {
		return EnderecoDto.converter(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
		repository.save(endereco);
		return new ResponseEntity<Endereco>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public EnderecoDto pegarContato(@PathVariable long id) {
		return new EnderecoDto(repository.findById(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Endereco> atualizar(@PathVariable long id, @RequestBody EnderecoForm formEndereco){
		formEndereco.atualiza(id, repository);
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Endereco> deletar(@PathVariable long id) {
		List<Contato> contatos = contatoRepository.findAll().stream().filter(contato -> contato.getEndereco().getId() == id).collect(Collectors.toList());
		contatos.get(0).setEndereco(null);
		repository.deleteById(id);
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
}
