package Ejercicio2;

import java.io.Serializable;

public class DTO implements Serializable {
    public Integer id;
    private String tipoHab;
    private String name;
    private String country;
    private Integer numberOfPerson;
    private Integer days;
    private String pets;
    private String fuma;

    public DTO(Integer id, String tipoHab, String name, String country, Integer numberOfPerson, Integer days, String pets, String fuma) {
        this.id = id;
        this.tipoHab = tipoHab;
        this.name = name;
        this.country = country;
        this.numberOfPerson = numberOfPerson;
        this.days = days;
        this.pets = pets;
        this.fuma = fuma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(Integer numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getFuma() {
        return fuma;
    }

    public void setFuma(String fuma) {
        this.fuma = fuma;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "id=" + id +
                ", tipoHab='" + tipoHab + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", numberOfPerson=" + numberOfPerson +
                ", days=" + days +
                ", pets=" + pets +
                ", fuma='" + fuma + '\'' +
                '}';
    }
}
