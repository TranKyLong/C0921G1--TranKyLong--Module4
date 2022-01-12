package app.reponsitory;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorReponsitoryImpl implements ICalculatorReponsitory {
    @Override
    public String calculate(String num1, String num2, String operator) {

        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

            switch (operator) {
                case "+":
                    return String.valueOf(number1 + number2);
                case "-":
                    return String.valueOf(number1 - number2);
                case "*":
                    return String.valueOf(number1 * number2);
                case "/":
                    return String.valueOf(number1 / number2);
                default:
                    return "NO RESULT";
            }
        } catch (Exception e) {
            return "MATH ERROR";
        }
    }

}
