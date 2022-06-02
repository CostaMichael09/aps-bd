package apsbanco.service.mapper;

import apsbanco.domain.Exame;
import apsbanco.domain.Medico;
import apsbanco.domain.Paciente;
import apsbanco.service.dto.ExameDTO;
import apsbanco.service.dto.MedicoDTO;
import apsbanco.service.dto.PacienteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Exame} and its DTO {@link ExameDTO}.
 */
@Mapper(componentModel = "spring")
public interface ExameMapper extends EntityMapper<ExameDTO, Exame> {
    @Mapping(target = "medico", source = "medico", qualifiedByName = "medicoNome")
    @Mapping(target = "paciente", source = "paciente", qualifiedByName = "pacienteNome")
    ExameDTO toDto(Exame s);

    @Named("medicoNome")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    MedicoDTO toDtoMedicoNome(Medico medico);

    @Named("pacienteNome")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    PacienteDTO toDtoPacienteNome(Paciente paciente);
}
