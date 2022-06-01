package apsbanco.service.mapper;

import apsbanco.domain.Medico;
import apsbanco.service.dto.MedicoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Medico} and its DTO {@link MedicoDTO}.
 */
@Mapper(componentModel = "spring")
public interface MedicoMapper extends EntityMapper<MedicoDTO, Medico> {}
