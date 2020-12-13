package edu.ivs.frtrans.forms;

import edu.ivs.frtrans.model.Build;
import edu.ivs.frtrans.model.Drivers;

import java.time.LocalDateTime;
import java.util.Objects;

public class RecordForms {
    private String id = " ";
    private String name = " ";
    private String description = " ";
    private String start = " ";
    private String finish = " ";
    private String drivers = " ";
    private String route = " ";
    private String build = " ";
    private String created_at = " ";
    private String modified_at = " ";

    public RecordForms() {
    }

    public RecordForms(String name, String description, String start, String finish, String drivers, String build) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.drivers = drivers;
        this.build = build;
    }

    public RecordForms(String name, String description, String start, String finish, String drivers, String build, String created_at, String modified_at) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.drivers = drivers;
        this.build = build;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public RecordForms(String id, String name, String description, String start, String finish, String drivers, String build, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.drivers = drivers;
        this.build = build;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordForms that = (RecordForms) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "RecordForms{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", drivers='" + drivers + '\'' +
                ", build='" + build + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }
}
