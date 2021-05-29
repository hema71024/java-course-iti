package assiment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Assiment2 {

    public static void main(String[] args) throws IOException {
        cityDAO cityDAO = new cityDAO();
        List<String> citiesLines = cityDAO.readDataFromCSV("city.csv");
        List<city> cities = cityDAO.createCities(citiesLines);
        countryDAO countryDAO = new countryDAO();
        List<String> countryLines = countryDAO.readDataFromCSV("country.csv");
        List<country> countries = countryDAO.createCities(countryLines);

        for (country co : countries) {
            int code = co.getId();
            List<city> citiesincountrys = new ArrayList<>();
            for (city ci : cities) {
                if (code == ci.getCountry_id()) {
                    citiesincountrys.add(ci);
                }
            }
            co.setCities(citiesincountrys);
        }

        Map<Integer, List<city>> cmap = new HashMap<>();
        for (country c : countries) {
            cmap.put(c.id, c.cities);
        }

        cmap.forEach((k, v)
                -> System.out.println(k + " " + v));
        countries.forEach(country -> {
            OptionalInt max = country.cities.stream().mapToInt(city ->city.getPopultion()).max();
            System.out.println("Hight population is " + max + " in " + country.getName());
        });
        Map<String, List<city>> ccmap
                = cities.stream().collect(groupingBy(c -> c.getContinent(), toList()));
        ccmap.forEach((k, v) -> {
            System.out.println("Continent is " + k + " and Highest population city is " + v.stream().mapToInt(c -> c.getPopultion()).max().orElse(0));
        });
        OptionalInt max = cities.stream().filter(c -> c.isCapital())
                .mapToInt(p -> p.getPopultion()).max();
        System.out.println("Highest population in the capital is " + max);
    }

}