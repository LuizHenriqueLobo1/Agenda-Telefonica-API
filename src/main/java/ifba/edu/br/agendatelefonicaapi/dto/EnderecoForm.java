package ifba.edu.br.agendatelefonicaapi.dto;

import ifba.edu.br.agendatelefonicaapi.models.Endereco;
import ifba.edu.br.agendatelefonicaapi.repository.EnderecoRepository;

public class EnderecoForm {

	private long id;
	private String pais;
	private String estado;
	private String cep;
	private String bairro;
	private String logradouro;
	private String numero;
	
	public EnderecoForm(Endereco endereco) {
		this.id  		= endereco.getId();
		this.pais 		= endereco.getPais();
		this.estado 	= endereco.getEstado();
		this.cep 		= endereco.getCep();
		this.bairro 	= endereco.getBairro();
		this.logradouro = endereco.getLogradouro();
		this.numero 	= endereco.getNumero();
	}
	
	public EnderecoForm() {
	}
	
	public Endereco atualiza(long id, EnderecoRepository repository) {
		Endereco endereco = repository.getById(id);
		endereco.setPais(this.pais);
		endereco.setEstado(this.estado);
		endereco.setCep(this.cep);
		endereco.setBairro(this.bairro);
		endereco.setLogradouro(this.logradouro);
		endereco.setNumero(this.numero);
		return endereco;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
