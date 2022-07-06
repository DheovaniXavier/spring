package br.univille.dacs2022.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.univille.dacs2022.entity.Procedure;

public class DoctorDTO {

    private long id;

    @NotBlank(message = "O campo nao pode ser deixado em branco.")
    @NotNull
    @Pattern(
        regexp = "[A-Z]{3,50}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Nome de usuario invalido."
    )
    private String name;

    @Pattern(
        regexp = "[0-9]{1,4}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Valor invalido. Inserir valor entre 1 e 9999"
    )
    private String crm;
    private List<Procedure> procedure;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Procedure> getProcedures() {
        return procedure;
    }

    public void setProcedures(List<Procedure> procedure) {
        this.procedure = procedure;
    }

}
