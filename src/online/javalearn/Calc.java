package online.javalearn;

import com.sun.media.sound.InvalidFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    private static Operand a;
    private static Operand b;
    private static TypeOperand type;

//    private static Command command;
    private static String oper;

    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        parseStringCalc(inputString);
        int result;
        switch (oper) {
            case "+":
                result = a.getValue() + b.getValue();
                break;
            case "-":
                result = a.getValue() - b.getValue();
                break;
            case "/":
                result = a.getValue() / b.getValue();
                break;
            case "*":
                result = a.getValue() * b.getValue();
                break;
            default:
                throw new InvalidFormatException("unknown operator");
        }

        System.out.println((type == TypeOperand.Arabic) ? result : RomanNumber.arabicToRoman(result));

        br.close();

    }

    static void parseStringCalc(String s) throws InvalidFormatException {
        String[] strings = s.split(" ");
        if (strings.length != 3) {
            throw new InvalidFormatException("must be: a oper b");
        }

        a = new Operand(strings[0]);
        oper = strings[1];
        b = new Operand(strings[2]);
        if (a.getType() != b.getType()) {
            throw new InvalidFormatException("both operands must be of same type");
        } else type = a.getType();
    }
}
