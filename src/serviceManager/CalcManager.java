package serviceManager;

import service.CalcService;

public class CalcManager {
    private final CalcService calcService = new CalcService();

    public CalcManager() {
    }

    public Object getResult(String str) throws Exception {
        if (this.calcService.romanNumber(str) && this.calcService.arabicNumber(str)) {
            throw new RuntimeException("Please enter the same type number");
        } else {

            String symbolOperate = this.calcService.DefineOperator(str);
            String text = str.replace(symbolOperate, " ");
            String[] numbers = text.split(" ");
            int firstNumber = this.calcService.ParserToInt(numbers[0]);
            int secondNumber = this.calcService.ParserToInt(numbers[1]);
            int sum = this.calcService.calculate(firstNumber, secondNumber, symbolOperate);
            if (this.calcService.romanNumber(str)) {

                return this.calcService.convertArabicNumberToRoman(sum);
            } else {
                return sum;
            }


        }
    }
}