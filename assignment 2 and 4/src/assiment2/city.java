package assiment2;
public class city {
      int id;
     String name;
     String continent;
     String Surface_Area;
     int popultion;
     int country_id;
     boolean capital;
        
   private country country;
   
    public city(int id, String name, String continent, String Surface_Area, int popultion, int country_id, boolean capital) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.Surface_Area = Surface_Area;
        this.popultion = popultion;
        this.country_id = country_id;
        this.capital = capital;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getSurface_Area() {
        return Surface_Area;
    }

    public void setSurface_Area(String Surface_Area) {
        this.Surface_Area = Surface_Area;
    }

    public int getPopultion() {
        return popultion;
    }

    public void setPopultion(int popultion) {
        this.popultion = popultion;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public country getCountry() {
        return country;
    }

    public void setCountry(country country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Id: "+id+", Name: "+name +", Population: "+ popultion;
    }
    
}
