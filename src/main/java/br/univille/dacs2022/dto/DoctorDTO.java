package br.univille.dacs2022.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    private List<ProcedureDTO> procedures = new ArrayList<>();
    private long procedureId;

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

    public List<ProcedureDTO> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<ProcedureDTO> procedures) {
        this.procedures = procedures;
    }

    public long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(long procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcTitles() {
        String titles = "";

        for(ProcedureDTO proc : this.procedures) {
            titles += proc.getTitle() + ", ";
        }

        if(!titles.equals("") && titles.contains(", ")) {
            titles = titles.substring(0, titles.length() - 1);
            titles = titles.substring(0, titles.length() - 1);
        }

        return titles;
    }

}
