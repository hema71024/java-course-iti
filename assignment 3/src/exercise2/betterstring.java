
package exercise2;

import java.util.function.BiPredicate;

public class betterstring {
       static String betterString(String str1, String str2, BiPredicate<String, String> bp) {
if(bp.test(str1, str2))
           return str1;
       else
           return str2;


    }
    
    static boolean isLetter(String str1) {
      str1 = str1.replaceAll("\\s+","");
      for(int i=0; i<str1.length(); i++){
            if(Character.isLetter(str1.charAt(i)) == false){
                return false;}
        }
        return true; 
    }
    }
