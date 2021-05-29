package assiment2;

import java.util.ArrayList;
import java.util.List;
public class country {
    int id;
    String name;
   int numberOfCities;
    List<city> cities ;
            
    public country(int id, String name, int numberOfCities) {
        this.id = id;
        this.name = name;
        this.numberOfCities = numberOfCities;
        this.cities = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }

    public void setNumberOfCities(int numberOfCities) {
        this.numberOfCities = numberOfCities;
    }

    public List<city> getCities() {
        return cities;
    }

    public void setCities(List<city> cities) {
        this.cities = cities;
    }

    
    
}
