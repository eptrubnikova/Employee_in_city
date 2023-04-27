package model;

import java.util.Objects;

public class City {

    private final int id;
    private String city_name;

    public City(int id, String city_name) {
        this.id = id;
        this.city_name = city_name;
    }

    public City(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(city_name, city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city_name);
    }

    @Override
    public String toString() {
        return "город " + city_name;
    }
}