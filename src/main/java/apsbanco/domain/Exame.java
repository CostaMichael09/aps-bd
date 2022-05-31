package apsbanco.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

/**
 * A Exame.
 */
@Entity
@Table(name = "exame")
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "data")
    private Instant data;

    @Column(name = "nomedomedico")
    private String nomedomedico;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Exame id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Exame tipo(String tipo) {
        this.setTipo(tipo);
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getData() {
        return this.data;
    }

    public Exame data(Instant data) {
        this.setData(data);
        return this;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getNomedomedico() {
        return this.nomedomedico;
    }

    public Exame nomedomedico(String nomedomedico) {
        this.setNomedomedico(nomedomedico);
        return this;
    }

    public void setNomedomedico(String nomedomedico) {
        this.nomedomedico = nomedomedico;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Exame)) {
            return false;
        }
        return id != null && id.equals(((Exame) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Exame{" +
            "id=" + getId() +
            ", tipo='" + getTipo() + "'" +
            ", data='" + getData() + "'" +
            ", nomedomedico='" + getNomedomedico() + "'" +
            "}";
    }
}
