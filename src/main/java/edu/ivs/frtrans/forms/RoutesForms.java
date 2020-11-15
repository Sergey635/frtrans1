package edu.ivs.frtrans.forms;

import java.util.Objects;

public class RoutesForms {
    private String id = " ";
    private String name = " ";
    private String distance = " ";
    private String daysOnTheRoad = " ";
    private String description = " ";
    private String pay = " ";
    private String created_at = " ";
    private String modified_at = " ";

    public RoutesForms() {
    }

    public RoutesForms(String name, String distance, String daysOnTheRoad, String description, String pay) {
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
        this.pay = pay;
    }

    public RoutesForms(String id, String name, String distance, String daysOnTheRoad, String description, String pay) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
        this.pay = pay;
    }

    public RoutesForms(String name, String distance, String daysOnTheRoad, String description, String pay, String created_at, String modified_at) {
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
        this.pay = pay;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public RoutesForms(String id, String name, String distance, String daysOnTheRoad, String description, String pay, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
        this.pay = pay;
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "RoutesForms{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", daysOnTheRoad='" + daysOnTheRoad + '\'' +
                ", description='" + description + '\'' +
                ", pay='" + pay + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutesForms that = (RoutesForms) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
