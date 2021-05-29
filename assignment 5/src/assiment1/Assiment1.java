package assiment1;

import java.io.FileNotFoundException;
import java.util.List;

public class Assiment1 {
    public static void main(String[] args)throws FileNotFoundException {
         
  PyramidCsvDAO pyrmd_csv_reader = new PyramidCsvDAO();
        List<Pyramid> pyramids = pyrmd_csv_reader.readPyramidsFromCSV("pyramids.csv");
        System.out.println(String.format("%-15s | %-50s | %-14s | %-10s", "Pharaoh", "Modern Name", "Site", "Height"));
        for(Pyramid p: pyramids) {
            
            System.out.println(String.format("%-15s | %-50s | %-14s | %-10s", p.getPharaoh(), p.getModernName(), p.getSite(), p.getHeight_m()));
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }
}
    }