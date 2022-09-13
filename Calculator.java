import java.util.Scanner;

public class Calculator {

    static boolean rNumber;
    static boolean aNumber;

    public static void main(String[] args) throws NumberException {
        String LogicOp;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] operanda = str.split("\\W");
        for (String s : operanda) {
            if (s.equals("I") || s.equals("II") || s.equals("III") || s.equals("IV") || s.equals("V") || s.equals("VI") ||
                    s.equals("VII") || s.equals("VIII") || s.equals("IX") || s.equals("X")) {
                rNumber = true;
            } else {
                aNumber = true;
            }
        }
        String[] operator = str.split("\\w");
        LogicOp = operator[operator.length - 1];
        if (operanda.length < 2) {
            throw new NumberException("т.к. строка не является математической операцией");
        } else if (operanda.length > 2) {
            throw new NumberException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int firstNumber = Integer.parseInt(String.valueOf(operandaRnInAn(operanda[0])));
        int secondNumber = Integer.parseInt(String.valueOf(operandaRnInAn(operanda[1])));
        if (firstNumber > 10 || secondNumber > 10) {
            throw new NumberException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }
        if (rNumber && aNumber) {
            throw new NumberException("т.к. используются одновременно разные системы счисления");
        } else if (!rNumber && aNumber) {
            int result = calc(firstNumber, secondNumber, LogicOp);
            System.out.println(result);
        } else if (rNumber && !aNumber) {
            int result = calc(firstNumber, secondNumber, LogicOp);
            System.out.println(convertNumber(result - 1));
        }
    }

    static int calc(int n1, int n2, String operator) {

        return switch (operator) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> 0;
        };
    }

    static int operandaRnInAn(String operanda) throws NumberException {
        try {
            return switch (operanda) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> Integer.parseInt(operanda);
            };
        } catch (NumberFormatException e) {
            throw new NumberException("Неверный формат данных");
        }
    }

    static String convertNumber(int result) throws NumberException {
        try {
            String[] romNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII",
                    "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                    "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            return romNumber[result];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NumberException("т.к. в римской системе нет отрицательных чисел");
        }
    }

}
class NumberException extends Exception {
    public NumberException(String description) {
        super(description);
    }
}

