package apsbanco.service;

import apsbanco.domain.Medico;
import apsbanco.repository.MedicoRepository;
import apsbanco.service.dto.MedicoDTO;
import apsbanco.service.mapper.MedicoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Medico}.
 */
@Service
@Transactional
public class MedicoService {

    private final Logger log = LoggerFactory.getLogger(MedicoService.class);

    private final MedicoRepository medicoRepository;

    private final MedicoMapper medicoMapper;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }

    /**
     * Save a medico.
     *
     * @param medicoDTO the entity to save.
     * @return the persisted entity.
     */
    public MedicoDTO save(MedicoDTO medicoDTO) {
        log.debug("Request to save Medico : {}", medicoDTO);
        Medico medico = medicoMapper.toEntity(medicoDTO);
        medico = medicoRepository.save(medico);
        return medicoMapper.toDto(medico);
    }

    /**
     * Update a medico.
     *
     * @param medicoDTO the entity to save.
     * @return the persisted entity.
     */
    public MedicoDTO update(MedicoDTO medicoDTO) {
        log.debug("Request to save Medico : {}", medicoDTO);
        Medico medico = medicoMapper.toEntity(medicoDTO);
        medico = medicoRepository.save(medico);
        return medicoMapper.toDto(medico);
    }

    /**
     * Partially update a medico.
     *
     * @param medicoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MedicoDTO> partialUpdate(MedicoDTO medicoDTO) {
        log.debug("Request to partially update Medico : {}", medicoDTO);

        return medicoRepository
            .findById(medicoDTO.getId())
            .map(existingMedico -> {
                medicoMapper.partialUpdate(existingMedico, medicoDTO);

                return existingMedico;
            })
            .map(medicoRepository::save)
            .map(medicoMapper::toDto);
    }

    /**
     * Get all the medicos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MedicoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Medicos");
        return medicoRepository.findAll(pageable).map(medicoMapper::toDto);
    }

    /**
     * Get one medico by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MedicoDTO> findOne(Long id) {
        log.debug("Request to get Medico : {}", id);
        return medicoRepository.findById(id).map(medicoMapper::toDto);
    }

    /**
     * Delete the medico by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Medico : {}", id);
        medicoRepository.deleteById(id);
    }
}
