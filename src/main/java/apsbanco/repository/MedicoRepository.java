package apsbanco.repository;

import apsbanco.domain.Medico;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Medico entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {}
