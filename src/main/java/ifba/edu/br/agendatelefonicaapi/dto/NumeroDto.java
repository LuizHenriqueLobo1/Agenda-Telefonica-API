package ifba.edu.br.agendatelefonicaapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import ifba.edu.br.agendatelefonicaapi.models.Categoria;
import ifba.edu.br.agendatelefonicaapi.models.Numero;

public class NumeroDto {

	private long id;
	private Categoria categoria;
	private String numero;

	public NumeroDto(Numero numero) {
		this.id 	   = numero.getId();
		this.categoria = numero.getCategoria();
		this.numero    = numero.getNumero();
	}

	public NumeroDto() {
	}

	public static List<NumeroDto> converte(List<Numero> numeros) {
		return numeros.stream().map(numero -> new NumeroDto(numero)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
