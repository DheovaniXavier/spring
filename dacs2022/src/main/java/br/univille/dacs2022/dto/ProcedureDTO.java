package br.univille.dacs2022.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProcedureDTO {

    private long id;

    @NotBlank(message = "Insert a valid title.")
    @NotNull
    private String title;

    @NotBlank(message = "Insert a valid description.")
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
