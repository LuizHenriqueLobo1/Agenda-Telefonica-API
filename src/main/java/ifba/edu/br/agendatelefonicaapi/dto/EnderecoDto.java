package ifba.edu.br.agendatelefonicaapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import ifba.edu.br.agendatelefonicaapi.models.Endereco;

public class EnderecoDto {

	private long id;
	private String pais;
	private String estado;
	private String cep;
	private String bairro;
	private String logradouro;
	private String numero;
	
	public EnderecoDto(Endereco endereco) {
		this.id  		= endereco.getId();
		this.pais 		= endereco.getPais();
		this.estado 	= endereco.getEstado();
		this.cep 		= endereco.getCep();
		this.bairro 	= endereco.getBairro();
		this.logradouro = endereco.getLogradouro();
		this.numero 	= endereco.getNumero();
	}
	
	public EnderecoDto() {
	}
	
	public static List<EnderecoDto> converter(List<Endereco> enderecos) {
		return enderecos.stream().map(endereco -> new EnderecoDto(endereco)).collect(Collectors.toList());
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
	
	//
}
