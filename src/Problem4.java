
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Problem4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuffer operatorStr = new StringBuffer(str);
        String[] numbers = new String[100000];
        int count = 0;
        String reg = "([+-]?\\d+)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(operatorStr);
        if (matcher.find()) {
            numbers[count++] = matcher.group();
            operatorStr.replace(matcher.start(), matcher.end(), " ");
            matcher = pattern.matcher(operatorStr);
        }

        // System.out.println(operatorStr);

        // 提取数字并从字符串中删去
        while (matcher.find()) {
            numbers[count++] = matcher.group();
            if ((operatorStr.charAt(matcher.start() - 1) == '+') || (operatorStr.charAt(matcher.start() - 1) == '-')){
                operatorStr.replace(matcher.start(), matcher.end(), " ");
            }
            else {
                operatorStr.replace(matcher.start(), matcher.end(), "+ ");
            }

            // System.out.println(operatorStr);

            matcher = pattern.matcher(operatorStr);
        }

        //System.out.println(operatorStr);
        // 去除所有空格
        String op = operatorStr.toString();
        op = op.replaceAll(" +", "");

        /*
        for (int i = 0; i < count; i++){
            System.out.println(numbers[i]);
        }
        System.out.println(op);
        */

        String number1 = numbers[0];
        for (int i = 1; i < count; i++){
            String number2 = numbers[i];
            BigInteger result = bigIntegerCompute(number1, number2, op.charAt(i-1));
            number1 = result.toString();
        }
        System.out.println(number1);
    }

    public static BigInteger bigIntegerCompute(String number1, String number2, char op){
        BigInteger num1 = new BigInteger(number1);
        BigInteger num2 = new BigInteger(number2);
        if (op == '+'){
            return num1.add(num2);
        }
        else if (op == '-'){
            return num1.subtract(num2);
        }
        else {
            return new BigInteger(String.valueOf(0));
        }
    }
}
