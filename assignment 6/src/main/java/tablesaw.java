import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.Table;
public class tablesaw {
        public static void main(String args[]) {
        Table table;
        try {
            table = Table.read ().csv ("titanic.csv");
            System.out.println("Structure of data :"+ table.structure());
            System.out.println("Summary of data :"+ table.summary ());
            System.out.println("number of missing values:"+ table.missingValueCounts());

        } catch (IOException ex) {
            Logger.getLogger(tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}