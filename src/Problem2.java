import java.math.BigInteger;
import java.util.Scanner;

public class Problem2 {
    /*public static void main(String[] args) {
        BigInteger a, b;
        a = new BigInteger("0");
        b = new BigInteger("0");
        Scanner input = new Scanner(System.in);
        if (input.hasNextBigInteger()) {
            a = input.nextBigInteger();
        } else {
            System.out.println("WRONG FORMAT!");
            System.exit(0);
        }
        if (input.hasNextBigInteger()) {
            b = input.nextBigInteger();
        } else {
            System.out.println("WRONG FORMAT!");
            System.exit(0);
        }
        if (input.hasNext()) {
            System.out.println("WRONG FORMAT!");
            System.exit(0);
        }
        System.out.println(a.add(b));
    }*/

    public static void main(String[] args){
        String str;
        Scanner input = new Scanner(System.in);
        str = input.nextLine();
        String pattern = "^[+-]?\\d+\\s+[+-]?\\d+$";
        if (str.matches(pattern)){
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
