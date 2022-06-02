package apsbanco.repository;

import apsbanco.domain.Exame;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Exame entity.
 */
@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    default Optional<Exame> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Exame> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Exame> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct exame from Exame exame left join fetch exame.medico left join fetch exame.paciente",
        countQuery = "select count(distinct exame) from Exame exame"
    )
    Page<Exame> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct exame from Exame exame left join fetch exame.medico left join fetch exame.paciente")
    List<Exame> findAllWithToOneRelationships();

    @Query("select exame from Exame exame left join fetch exame.medico left join fetch exame.paciente where exame.id =:id")
    Optional<Exame> findOneWithToOneRelationships(@Param("id") Long id);
}
