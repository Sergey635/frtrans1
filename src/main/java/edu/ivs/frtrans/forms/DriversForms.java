package edu.ivs.frtrans.forms;

public class DriversForms {
    private String id = " ";
    private String name = " ";
    private String phone = " ";
    private String experience = " ";
    private String description = " ";
    private String created_at = " ";
    private String modified_at = " ";

    public DriversForms() {
    }

    public DriversForms(String name, String description, String created_at, String modified_at) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public DriversForms(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public DriversForms(String id, String name, String description
            , String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
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
        return "DriversForms{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", experience='" + experience + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }
}
