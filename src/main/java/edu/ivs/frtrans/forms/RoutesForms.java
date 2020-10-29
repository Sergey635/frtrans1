package edu.ivs.frtrans.forms;

public class RoutesForms {
    private String id = " ";
    private String name = " ";
    private String distance = " ";
    private String daysOnTheRoad = " ";
    private String description = " ";

    public RoutesForms(String name, String distance, String daysOnTheRoad, String description) {
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
        this.description = description;
    }

    public RoutesForms() {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.daysOnTheRoad = daysOnTheRoad;
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

    @Override
    public String toString() {
        return "RoutesForms{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", daysOnTheRoad='" + daysOnTheRoad + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
