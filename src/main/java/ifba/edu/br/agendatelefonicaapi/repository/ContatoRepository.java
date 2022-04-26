package ifba.edu.br.agendatelefonicaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifba.edu.br.agendatelefonicaapi.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	public Contato findById(long id);
}
