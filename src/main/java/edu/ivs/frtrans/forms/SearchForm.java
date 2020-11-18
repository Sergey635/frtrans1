package edu.ivs.frtrans.forms;

public class SearchForm {
    private String name;

    public SearchForm(String name) {
        this.name = name;
    }

    public SearchForm() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerchForm{" +
                "name='" + name + '\'' +
                '}';
    }
}
