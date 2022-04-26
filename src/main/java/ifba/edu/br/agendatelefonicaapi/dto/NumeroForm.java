package ifba.edu.br.agendatelefonicaapi.dto;

import ifba.edu.br.agendatelefonicaapi.models.Categoria;
import ifba.edu.br.agendatelefonicaapi.models.Numero;
import ifba.edu.br.agendatelefonicaapi.repository.NumeroRepository;

public class NumeroForm {

	private long id;
	private Categoria categoria;
	private String numero;
	
	public NumeroForm(Numero numero) {
		this.id 	   = numero.getId();
		this.categoria = numero.getCategoria();
		this.numero    = numero.getNumero();
	}
	
	public NumeroForm() {
	}
	
	public Numero atualiza(long id, NumeroRepository repository) {
		Numero numero = repository.getById(id);
		numero.setCategoria(this.categoria);
		numero.setNumero(this.numero);
		return numero;
	}
	
	public long getId() {
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
