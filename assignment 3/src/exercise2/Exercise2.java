package exercise2;
public class Exercise2 {
    public static void main(String[] args) {
     String a = "my name is ahmed";
     String b = "world cup 2022";
        
        String result = betterstring.betterString(a, b, (st1,st2) -> st1.length() > st2.length());
        System.out.println(result);
        System.out.println(betterstring.isLetter(a));
        System.out.println(betterstring.isLetter(b));
    }
}
