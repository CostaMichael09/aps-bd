package apsbanco.service.mapper;

import apsbanco.domain.Exame;
import apsbanco.service.dto.ExameDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Exame} and its DTO {@link ExameDTO}.
 */
@Mapper(componentModel = "spring")
public interface ExameMapper extends EntityMapper<ExameDTO, Exame> {}
