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

    static char chs [] = new char[36];

    static int flag = 0;

    static {
        for (int i = 0; i < 10; i++) {
            chs[i] = (char)('0' + i);
        }
        for (int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }
    /**
     * 转换进制的方法
     * @param num           原始数据的字符串形式
     * @param fromRadix     原始数据的进制
     * @param toRadix       目标数据的进制
     * @return              目标数据的字符串形式
     */

    static String transRadix(String num, int fromRadix, int toRadix) {
        // 先转化为10进制类型
        BigInteger tempNumber = new BigInteger(num, fromRadix);
        StringBuilder itemNumber = new StringBuilder();
        // 反复除法进行目标进制转化
        if (tempNumber.compareTo(new BigInteger("0")) == -1) {
            tempNumber = tempNumber.abs();
            flag = 1;
        }
        while (tempNumber.compareTo(new BigInteger("0")) == 1) {
            itemNumber.append(chs[tempNumber.mod(new BigInteger(
                    String.valueOf(toRadix))).intValue()]);
            tempNumber = tempNumber.divide(
                    new BigInteger(String.valueOf(toRadix)));
        }
        if (flag == 0) {
            return itemNumber.reverse().toString();
        }
        else {
            return ('-' + itemNumber.reverse().toString());
        }
    }
}
