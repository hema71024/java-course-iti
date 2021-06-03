package assiment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class cityDAO {
     public cityDAO() {
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
    
    public List<city> createCities(List<String> lines)
    {
        List<city> cities = new ArrayList<>();
        for(int i=1 ; i<lines.size();i++ )
        {
            String[] splits = lines.get(i).split(",");
city city = new city(Integer.parseInt(splits[0]),splits[1],splits[2],splits[3],Integer.parseInt(splits[4]),Integer.parseInt(splits[6]),Boolean.parseBoolean(splits[5]));
cities.add(city);
            
        }
        return cities;
    }
}
