package apsbanco.service;

import apsbanco.domain.Exame;
import apsbanco.repository.ExameRepository;
import apsbanco.service.dto.ExameDTO;
import apsbanco.service.mapper.ExameMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Exame}.
 */
@Service
@Transactional
public class ExameService {

    private final Logger log = LoggerFactory.getLogger(ExameService.class);

    private final ExameRepository exameRepository;

    private final ExameMapper exameMapper;

    public ExameService(ExameRepository exameRepository, ExameMapper exameMapper) {
        this.exameRepository = exameRepository;
        this.exameMapper = exameMapper;
    }

    /**
     * Save a exame.
     *
     * @param exameDTO the entity to save.
     * @return the persisted entity.
     */
    public ExameDTO save(ExameDTO exameDTO) {
        log.debug("Request to save Exame : {}", exameDTO);
        Exame exame = exameMapper.toEntity(exameDTO);
        exame = exameRepository.save(exame);
        return exameMapper.toDto(exame);
    }

    /**
     * Update a exame.
     *
     * @param exameDTO the entity to save.
     * @return the persisted entity.
     */
    public ExameDTO update(ExameDTO exameDTO) {
        log.debug("Request to save Exame : {}", exameDTO);
        Exame exame = exameMapper.toEntity(exameDTO);
        exame = exameRepository.save(exame);
        return exameMapper.toDto(exame);
    }

    /**
     * Partially update a exame.
     *
     * @param exameDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ExameDTO> partialUpdate(ExameDTO exameDTO) {
        log.debug("Request to partially update Exame : {}", exameDTO);

        return exameRepository
            .findById(exameDTO.getId())
            .map(existingExame -> {
                exameMapper.partialUpdate(existingExame, exameDTO);

                return existingExame;
            })
            .map(exameRepository::save)
            .map(exameMapper::toDto);
    }

    /**
     * Get all the exames.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ExameDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Exames");
        return exameRepository.findAll(pageable).map(exameMapper::toDto);
    }

    /**
     * Get one exame by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ExameDTO> findOne(Long id) {
        log.debug("Request to get Exame : {}", id);
        return exameRepository.findById(id).map(exameMapper::toDto);
    }

    /**
     * Delete the exame by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Exame : {}", id);
        exameRepository.deleteById(id);
    }
}
