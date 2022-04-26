package ifba.edu.br.agendatelefonicaapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import ifba.edu.br.agendatelefonicaapi.models.Contato;
import ifba.edu.br.agendatelefonicaapi.models.Endereco;
import ifba.edu.br.agendatelefonicaapi.models.Numero;

public class ContatoDto {

	private long id;
	private String nome;
	private String email;
	private Endereco endereco;
	private List<Numero> numeros;

	public ContatoDto(Contato contato) {
		this.id 	  = contato.getId();
		this.nome     = contato.getNome();
		this.email 	  = contato.getEmail();
		this.endereco = contato.getEndereco();
		this.numeros  = contato.getNumeros();
	}

	public ContatoDto() {
	}

	public static List<ContatoDto> converte(List<Contato> contatos) {
		return contatos.stream().map(contato -> new ContatoDto(contato)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}
}
