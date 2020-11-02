package online.javalearn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumber {

    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumber> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumber e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static int romanToArabic(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null");
        }

        String romanNumber = s.toUpperCase();
        int result = 0;

        List<RomanNumber> romanNumerals = RomanNumber.getReverseSortedValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumerals.size())) {
            RomanNumber symbol = romanNumerals.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(s + " cannot be converted to a Roman Number");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumber> romanNumerals = RomanNumber.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumber currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}