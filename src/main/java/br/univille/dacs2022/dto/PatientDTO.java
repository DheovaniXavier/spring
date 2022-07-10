package br.univille.dacs2022.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private long cityId;
    private List<HealthPlanDTO> healthPlan = new ArrayList<>();
    private long healthPlanId;
    
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

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public List<HealthPlanDTO> getPlans() {
        return healthPlan;
    }

    public void setPlans(List<HealthPlanDTO> healthPlan) {
        this.healthPlan = healthPlan;
    }

    public String getHealthPlanNames() {
        String names = "";
        for(HealthPlanDTO plan : this.healthPlan) {
            names += plan.getName() + ", ";
        }

        // Remover o ", " do último nome
        if(!names.equals("") && names.contains(", ")) {
            names = names.substring(0, names.length() - 1);
            names = names.substring(0, names.length() - 1);
        }

        return names;
    }

    public long getHealthPlanId() {
        return healthPlanId;
    }

    public void setHealthPlanId(long healthPlanId) {
        this.healthPlanId = healthPlanId;
    }

}
