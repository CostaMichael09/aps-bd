package apsbanco.web.rest;

import apsbanco.repository.ExameRepository;
import apsbanco.service.ExameService;
import apsbanco.service.dto.ExameDTO;
import apsbanco.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link apsbanco.domain.Exame}.
 */
@RestController
@RequestMapping("/api")
public class ExameResource {

    private final Logger log = LoggerFactory.getLogger(ExameResource.class);

    private static final String ENTITY_NAME = "exame";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ExameService exameService;

    private final ExameRepository exameRepository;

    public ExameResource(ExameService exameService, ExameRepository exameRepository) {
        this.exameService = exameService;
        this.exameRepository = exameRepository;
    }

    /**
     * {@code POST  /exames} : Create a new exame.
     *
     * @param exameDTO the exameDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new exameDTO, or with status {@code 400 (Bad Request)} if the exame has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/exames")
    public ResponseEntity<ExameDTO> createExame(@RequestBody ExameDTO exameDTO) throws URISyntaxException {
        log.debug("REST request to save Exame : {}", exameDTO);
        if (exameDTO.getId() != null) {
            throw new BadRequestAlertException("A new exame cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ExameDTO result = exameService.save(exameDTO);
        return ResponseEntity
            .created(new URI("/api/exames/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /exames/:id} : Updates an existing exame.
     *
     * @param id the id of the exameDTO to save.
     * @param exameDTO the exameDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated exameDTO,
     * or with status {@code 400 (Bad Request)} if the exameDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the exameDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/exames/{id}")
    public ResponseEntity<ExameDTO> updateExame(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ExameDTO exameDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Exame : {}, {}", id, exameDTO);
        if (exameDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, exameDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!exameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ExameDTO result = exameService.update(exameDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, exameDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /exames/:id} : Partial updates given fields of an existing exame, field will ignore if it is null
     *
     * @param id the id of the exameDTO to save.
     * @param exameDTO the exameDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated exameDTO,
     * or with status {@code 400 (Bad Request)} if the exameDTO is not valid,
     * or with status {@code 404 (Not Found)} if the exameDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the exameDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/exames/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ExameDTO> partialUpdateExame(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ExameDTO exameDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Exame partially : {}, {}", id, exameDTO);
        if (exameDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, exameDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!exameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ExameDTO> result = exameService.partialUpdate(exameDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, exameDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /exames} : get all the exames.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of exames in body.
     */
    @GetMapping("/exames")
    public ResponseEntity<List<ExameDTO>> getAllExames(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        @RequestParam(required = false, defaultValue = "true") boolean eagerload
    ) {
        log.debug("REST request to get a page of Exames");
        Page<ExameDTO> page;
        if (eagerload) {
            page = exameService.findAllWithEagerRelationships(pageable);
        } else {
            page = exameService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /exames/:id} : get the "id" exame.
     *
     * @param id the id of the exameDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the exameDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/exames/{id}")
    public ResponseEntity<ExameDTO> getExame(@PathVariable Long id) {
        log.debug("REST request to get Exame : {}", id);
        Optional<ExameDTO> exameDTO = exameService.findOne(id);
        return ResponseUtil.wrapOrNotFound(exameDTO);
    }

    /**
     * {@code DELETE  /exames/:id} : delete the "id" exame.
     *
     * @param id the id of the exameDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/exames/{id}")
    public ResponseEntity<Void> deleteExame(@PathVariable Long id) {
        log.debug("REST request to delete Exame : {}", id);
        exameService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
