package edu.ivs.frtrans.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Drivers {
    private String id;
    private String name;
    private String phone;
    private String adres;
    private LocalDate expirience;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Drivers() {
    }

    public Drivers(String name, String phone, String adres, LocalDate expirience, String description
            , LocalDateTime created_at, LocalDateTime modified_at) {
        this.name = name;
        this.phone = phone;
        this.adres = adres;
        this.expirience = expirience;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Drivers(String id, String name, String phone, String adres, LocalDate expirience, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adres = adres;
        this.expirience = expirience;
        this.description = description;
    }

    public Drivers(String name, String phone, String adres, LocalDate expirience, String description) {
        this.name = name;
        this.phone = phone;
        this.adres = adres;
        this.expirience = expirience;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public LocalDate getExpirience() {
        return expirience;
    }

    public void setExpirience(LocalDate expirience) {
        this.expirience = expirience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adres='" + adres + '\'' +
                ", expirience=" + expirience +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drivers drivers = (Drivers) o;
        return getId().equals(drivers.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

