package online.javalearn;

public class Operand {
    int value;
    TypeOperand type;

//    public Operand(int value, TypeOperand type) {
//        this.value = value;
//        this.type = type;
//    }

    public Operand(String s) {
        if (isArabic(s)) {
            this.value = Integer.parseInt(s);
            this.type = TypeOperand.Arabic;
        } else if (isRoman(s)) {
            this.value = RomanNumber.romanToArabic(s);
            this.type = TypeOperand.Roman;
        }
    }

    private static boolean isRoman(String s) {
        for (char c :
                s.toLowerCase().toCharArray()) {
            if (c != 'i' && c != 'v' && c != 'x') return false;
        }
        return true;
    }

    private static boolean isArabic(String s) {
        char[] c = s.toCharArray();

        int len = s.length();
        char firstChar = c[0];
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar != '-' && firstChar != '+')
                throw new NumberFormatException(s);

            if (len == 1) // Cannot have lone "+" or "-"
                throw new NumberFormatException(s);
        }
        for (int i = 1; i < len; i++) {
            if (c[i] < '0' || c[i] > '9')
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type == TypeOperand.Arabic ? Integer.toString(value) : RomanNumber.arabicToRoman(value);
    }
}
