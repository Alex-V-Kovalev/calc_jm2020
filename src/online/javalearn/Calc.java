package online.javalearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    private static Operand a;
    private static Operand b;
    private static TypeOperand type;

    private static Command command;

    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        parseStringCalc(inputString);


        br.close();

    }

    static void parseStringCalc(String s) {

    }
}
