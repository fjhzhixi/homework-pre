import java.math.BigInteger;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] numbers = str.split("\\s+");
        int fromRadix = Integer.parseInt(numbers[0]);
        BigInteger num1 = new BigInteger(numbers[1], fromRadix);
        str = input.nextLine();
        numbers = str.split("\\s+");
        fromRadix = Integer.parseInt(numbers[0]);
        BigInteger num2 = new BigInteger(numbers[1], fromRadix);
        BigInteger result = num1.add(num2);
        int toRadix = input.nextInt();
        System.out.println(result.toString(toRadix));
    }

    public static String transRadix(String num, int fromRadix, int toRadix) {
        return new BigInteger(num, fromRadix).toString(toRadix);
    }

}
