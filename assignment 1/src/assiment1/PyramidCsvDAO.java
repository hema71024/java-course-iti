package assiment1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
class PyramidCsvDAO {
    public List<Pyramid>readPyramidsFromCSV(String fileName) {
	
	File pyramids_file=new File(fileName);
	List<String>lines=new ArrayList();
	List<Pyramid> allPyramids=new ArrayList<>();
	
	try {
		lines=Files.readAllLines(pyramids_file.toPath());
		for (int i=1 ;i<lines.size();i++) {
			allPyramids.add(createPyramid(lines.get(i)));
		}	
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return allPyramids;
	
}

private Pyramid createPyramid(String line) {
  String[] fields=line.split(",");
  double height=Double.NaN;
  if(!"".equals(fields[7]))
   height=Double.parseDouble( fields[7]);
  return new Pyramid(fields[0], fields[2], fields[4], height);
}
}
