package br.univille.dacs2022.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CityDTO {

    private long id;

    @NotBlank(message = "Insert a valid city name")
    @NotNull
    private String name;

    @NotBlank(message = "Insert a valid state name")
    @NotNull
    @Pattern(
        regexp = "[A-Z]{2}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid state."
    )
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
