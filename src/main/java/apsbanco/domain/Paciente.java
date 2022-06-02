package apsbanco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Paciente.
 */
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnoreProperties(value = { "medico", "paciente" }, allowSetters = true)
    private Set<Exame> exames = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Paciente id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Paciente nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public Paciente cpf(Long cpf) {
        this.setCpf(cpf);
        return this;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Paciente telefone(String telefone) {
        this.setTelefone(telefone);
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Exame> getExames() {
        return this.exames;
    }

    public void setExames(Set<Exame> exames) {
        if (this.exames != null) {
            this.exames.forEach(i -> i.setPaciente(null));
        }
        if (exames != null) {
            exames.forEach(i -> i.setPaciente(this));
        }
        this.exames = exames;
    }

    public Paciente exames(Set<Exame> exames) {
        this.setExames(exames);
        return this;
    }

    public Paciente addExame(Exame exame) {
        this.exames.add(exame);
        exame.setPaciente(this);
        return this;
    }

    public Paciente removeExame(Exame exame) {
        this.exames.remove(exame);
        exame.setPaciente(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Paciente)) {
            return false;
        }
        return id != null && id.equals(((Paciente) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Paciente{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", cpf=" + getCpf() +
            ", telefone='" + getTelefone() + "'" +
            "}";
    }
}
