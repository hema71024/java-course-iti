package assiment1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assiment1 {
    public static void main(String[] args)throws FileNotFoundException {
        PyramidCsvDAO p = new PyramidCsvDAO();
        List<Pyramid> pyramids = p.ReadPyramidsFormCSV("pyramids.csv");
        List<Double> heights = pyramids.stream().filter(pyramid -> pyramid.getHeight_m()>0).
        map(Pyramid::getHeight_m).sorted().collect(Collectors.toList());
        System.out.println("Median of heights ="+ quartiles(heights));
        System.out.println("Lower quartile = "+quartiles(heights.subList(0, heights.size()/2)));
        System.out.println("Upper quartile = "+quartiles(heights.subList(heights.size()/2, heights.size())));
        double sumOfHeights = 0;
        for (double height : heights)
            sumOfHeights += height;
        System.out.println("Average of heights: "+sumOfHeights/heights.size());  
    }

    public static Double quartiles(List<Double> heights){
        int citiesNumber = heights.size();
        double median = citiesNumber % 2 == 0
                ? (heights.get((int) (citiesNumber / 2)) + heights.get((int) (citiesNumber / 2) - 1)) / 2
                : heights.get((int) (citiesNumber / 2));

        return median;
    }
    }