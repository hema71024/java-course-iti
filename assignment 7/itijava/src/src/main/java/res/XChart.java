package res;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class XChart 
{
    public static void main( String[] args ) throws IOException
    {
     XChart x = new XChart ();
        List<TitanicPassenger> allPassengers = x.getPassengersFromJsonFile ();
        x.graphPassengerGender(allPassengers);
                    System.in.read();

        x.graphPassengerClass (allPassengers);
                    System.in.read();

        x.graphPassengersurvived(allPassengers);
                    System.in.read();

        x.graphPassengerAges(allPassengers);

    }
    public List<TitanicPassenger> getPassengersFromJsonFile() {
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
        ObjectMapper objectMapper = new ObjectMapper ();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream ("titanic_csv.json")) {
            allPassengers = objectMapper.readValue (input, new TypeReference<List<TitanicPassenger>> () {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return allPassengers;
    }

    public void graphPassengerAges(List<TitanicPassenger> passengerList) {
        List<Float> pAges = passengerList.stream ().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList ());
        List<String> pNames = passengerList.stream ().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList ());
        String[] names = new String[pNames.size ()];
        Float ages[] = new Float[pAges.size ()];
        ages = pAges.toArray (ages);
        names = pNames.toArray (names);
        CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Age Histogram").xAxisTitle ("Names").yAxisTitle ("Age").build ();
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        chart.addSeries ("Passenger's Ages", pNames, pAges);
        new SwingWrapper (chart).displayChart ();
    }

    public void graphPassengerClass(List<TitanicPassenger> passengerList) {
        Map<String, Long> result =
                passengerList.stream ().collect (
                        Collectors.groupingBy (
                                TitanicPassenger::getPclass, Collectors.counting ()
                        )
                );
        PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("First Class", result.get ("1"));
        chart.addSeries ("Second Class", result.get ("2"));
        chart.addSeries ("Third Class", result.get ("3"));
        new SwingWrapper (chart).displayChart ();
    }
    public void graphPassengerGender(List<TitanicPassenger> passengerList) {
        Map<String, Long> results =
                passengerList.stream ().collect (
                        Collectors.groupingBy (
                                TitanicPassenger::getSex, Collectors.counting ()
                        )
                );
        PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("male ", results.get ("male"));
        chart.addSeries ("female", results.get ("female"));
        new SwingWrapper (chart).displayChart ();

        System.out.print(results);


    }
        public void graphPassengersurvived(List<TitanicPassenger> passengerList) {
        Map<String, Long> results =
                passengerList.stream ().collect (
                        Collectors.groupingBy (
                                TitanicPassenger::getSurvived, Collectors.counting ()
                        )
                );
        PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("survived ", results.get ("1"));
        chart.addSeries ("un survived", results.get ("0"));
        new SwingWrapper (chart).displayChart ();

        System.out.print(results);


    }
}
