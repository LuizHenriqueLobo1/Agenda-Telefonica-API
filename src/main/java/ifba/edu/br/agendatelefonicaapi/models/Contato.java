package ifba.edu.br.agendatelefonicaapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Entity(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private List<Numero> numeros = new ArrayList<Numero>();
	
	public Contato(long id, String nome, String email, Endereco endereco, List<Numero> numeros) {
		this.id 	  = id;
		this.nome     = nome;
		this.email    = email;
		this.endereco = endereco;
		this.numeros  = numeros;
	}
	
	public Contato() {
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
