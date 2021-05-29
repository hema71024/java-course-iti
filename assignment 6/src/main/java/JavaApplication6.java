
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinery.DataFrame;


public class JavaApplication6 {
    public static void main(String[] args) {
        try {
             DataFrame<Object> df = DataFrame.readCsv("titanic.csv");
            DataFrame<Object> df1 = df.retain("name", "age").dropna().unique("name");
            DataFrame<Object> df2 = df.retain("name", "sex").dropna().unique("name");
            DataFrame<Object> join= df1.join(df2,DataFrame.JoinType.INNER);
            System.out.println("DataFrame After Joining : ");
            System.out.println(join);
            DataFrame<Object> merge=df1.merge(df2, DataFrame.JoinType.LEFT);
            System.out.println("DataFrame After merging : ");
            System.out.println(merge);            
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication6.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
