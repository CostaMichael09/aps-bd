package apsbanco.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link apsbanco.domain.Exame} entity.
 */
public class ExameDTO implements Serializable {

    private Long id;

    private String tipo;

    private Instant data;

    private String nomedomedico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getNomedomedico() {
        return nomedomedico;
    }

    public void setNomedomedico(String nomedomedico) {
        this.nomedomedico = nomedomedico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExameDTO)) {
            return false;
        }

        ExameDTO exameDTO = (ExameDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, exameDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ExameDTO{" +
            "id=" + getId() +
            ", tipo='" + getTipo() + "'" +
            ", data='" + getData() + "'" +
            ", nomedomedico='" + getNomedomedico() + "'" +
            "}";
    }
}
