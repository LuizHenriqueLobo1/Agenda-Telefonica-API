package ifba.edu.br.agendatelefonicaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifba.edu.br.agendatelefonicaapi.models.Numero;

public interface NumeroRepository extends JpaRepository<Numero, Long> {
	public Numero findById(long id);
}
