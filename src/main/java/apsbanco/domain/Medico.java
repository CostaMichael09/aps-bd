package apsbanco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Medico.
 */
@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "crm")
    private Long crm;

    @OneToMany(mappedBy = "medico")
    @JsonIgnoreProperties(value = { "medico", "paciente" }, allowSetters = true)
    private Set<Exame> exames = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Medico id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Medico nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public Medico especialidade(String especialidade) {
        this.setEspecialidade(especialidade);
        return this;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Long getCrm() {
        return this.crm;
    }

    public Medico crm(Long crm) {
        this.setCrm(crm);
        return this;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public Set<Exame> getExames() {
        return this.exames;
    }

    public void setExames(Set<Exame> exames) {
        if (this.exames != null) {
            this.exames.forEach(i -> i.setMedico(null));
        }
        if (exames != null) {
            exames.forEach(i -> i.setMedico(this));
        }
        this.exames = exames;
    }

    public Medico exames(Set<Exame> exames) {
        this.setExames(exames);
        return this;
    }

    public Medico addExame(Exame exame) {
        this.exames.add(exame);
        exame.setMedico(this);
        return this;
    }

    public Medico removeExame(Exame exame) {
        this.exames.remove(exame);
        exame.setMedico(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medico)) {
            return false;
        }
        return id != null && id.equals(((Medico) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Medico{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", especialidade='" + getEspecialidade() + "'" +
            ", crm=" + getCrm() +
            "}";
    }
}
