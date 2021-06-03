package assiment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class countryDAO { 
      public countryDAO() {
    }
    public List<String> readDataFromCSV(String fileName)
    {
        List<String> lines = new ArrayList<>();
        File f = new File(fileName);
        try {
            lines= Files.readAllLines(f.toPath());
        } catch (IOException ex) {
            Logger.getLogger(cityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
     public List<country> createCities(List<String> lines)
    {
        List<country> countries = new ArrayList<>();
        for(int i=1 ; i<lines.size();i++ )
        {
            String[] splits = lines.get(i).split(",");
            country country = new country(Integer.parseInt(splits[0]), splits[1], Integer.parseInt(splits[2]));
            countries.add(country);
        }
        return countries;
    }
}
