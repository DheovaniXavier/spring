package br.univille.dacs2022.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class PatientDTO {

    private long id;

    @NotBlank(message = "O campo não pode ser deixado em branco")
    @NotNull
    private String name;

    @Pattern(
        regexp = "MASC|FEM",
        flags = Pattern.Flag.CANON_EQ,
        message = "Valor inválido, utilize MASC ou FEM"
    )
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private CityDTO city;
    private long cidadeId;
    
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(long cidadeId) {
        this.cidadeId = cidadeId;
    }

}
