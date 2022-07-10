package br.univille.dacs2022.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProcedureDTO {

    private long id;

    @NotBlank(message = "Insira um título válido.")
    @NotNull
    private String title;

    @NotBlank(message = "Insira uma descrição válida.")
    @NotNull
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
