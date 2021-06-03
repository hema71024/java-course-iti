package assiment1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
class PyramidCsvDAO {
    
    public List<Pyramid> readPyramidsFormCSV;
    File pyramidsFile;

    public PyramidCsvDAO() {
        this.readPyramidsFormCSV = new ArrayList<Pyramid>();
    }

    public List<Pyramid> ReadPyramidsFormCSV(String fileName) {
        pyramidsFile = new File(fileName);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(pyramidsFile.toPath());
        } catch (Exception e) {
            System.out.println("An issue happened while reading pyramids file: " + e);
        }
        for (int lineIdx = 1; lineIdx < lines.size(); lineIdx++) {
            String line = lines.get(lineIdx);
            String[] data = line.split(",");
            readPyramidsFormCSV.add(createPyramid(data));
        }
        return readPyramidsFormCSV;
    }

    public Pyramid createPyramid(String[] metadata) {
        Pyramid pyramid = new Pyramid(metadata[0], metadata[2], metadata[4],
                metadata[7].equals("") ? 0 : Double.parseDouble(metadata[7]));
        return pyramid;
    }

}
