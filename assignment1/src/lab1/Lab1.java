
package lab1;

import java.util.List;

public class Lab1 {

    public static void main(String[] args) {
        pyramidsDAO pDAO=new pyramidsDAO();
		List<pyramids>pyramids;
        pyramids = pDAO.readPyramidsFromCSV("pyramids.csv");
		
		for(pyramids p:pyramids) {
			System.out.println(p);
    }
    
}
}
