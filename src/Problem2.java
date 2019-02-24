import java.math.BigInteger;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        String str;
        Scanner input = new Scanner(System.in);
        str = input.nextLine();
        String pattern = "^[+-]?\\d+\\s+[+-]?\\d+$";
        if (str.matches(pattern)) {
            String[] numbers = str.split("\\s+");
            BigInteger a = new BigInteger(numbers[0]);
            BigInteger b = new BigInteger(numbers[1]);
            System.out.println(a.add(b));
        }
        else {
            System.out.println("WRONG FORMAT!");
        }
    }
}
