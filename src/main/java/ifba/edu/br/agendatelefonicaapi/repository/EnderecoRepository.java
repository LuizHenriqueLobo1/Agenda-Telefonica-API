package ifba.edu.br.agendatelefonicaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifba.edu.br.agendatelefonicaapi.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	public Endereco findById(long id);
}
