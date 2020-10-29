package edu.ivs.frtrans.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Route {
    private String id;
    private String name;
    private String distance;
    private String daysOnTheRoad;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Route() {
    }

    public Route(String name, String distance, String daysOnTheRoad, String description) {
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
    }

    public Route(String id, String name, String distance, String daysOnTheRoad, String description) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
    }

    public Route(String id, String name, String distance, String daysOnTheRoad, String description
            , LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDaysOnTheRoad() {
        return daysOnTheRoad;
    }

    public void setDaysOnTheRoad(String daysOnTheRoad) {
        this.daysOnTheRoad = daysOnTheRoad;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return getId().equals(route.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", daysOnTheRoad='" + daysOnTheRoad + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
