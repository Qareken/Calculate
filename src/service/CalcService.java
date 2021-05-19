package service;

import Enumeration.MathematicalSymbol;
import Enumeration.Roman;
import Interface.Converter;

import java.util.regex.Pattern;

public class CalcService implements Converter {
    private final Roman[] roman = Roman.values();
    private final MathematicalSymbol[] mathemacialSymbols = MathematicalSymbol.values();
    public CalcService() {
    }
    @Override
    public String convertArabicNumberToRoman(Integer number) {
        StringBuilder romanic = new StringBuilder();
        Integer num = number;
        Roman[] var4 = this.roman;
        int var5 = var4.length;

        for (Roman item : var4) {
            for (Roman value = item; num >= value.getValueOfRoman(); num = num - value.getValueOfRoman()) {
                romanic.append(value.name());
            }
        }

        return romanic.toString();
    }

    @Override
    public int ConvertRomanToArabic(String number) {
        String romanic = number.toUpperCase();
        int arabicNum = 0;
        int i = 0;

        while(romanic.length() > 0 && i < this.roman.length) {
            Roman sym = this.roman[i];
            if (romanic.startsWith(sym.name())) {
                arabicNum += sym.getValueOfRoman();
                romanic = romanic.substring(sym.name().length());
            } else {
                ++i;
            }
        }

        return arabicNum;
    }

    @Override
    public String DefineOperator(String number) {
        StringBuilder operator = new StringBuilder();
        MathematicalSymbol[] symbols = this.mathemacialSymbols;
        for (MathematicalSymbol symbol : symbols) {
            if (number.contains(symbol.getMathematic())) {
                operator.append(symbol.getMathematic());
            }
        }
        return operator.toString();
    }
    public int ParserToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException var3) {
            return this.ConvertRomanToArabic(str);
        }
    }
    public boolean romanNumber(String str){
        boolean check=false;

        for(Roman romanic:roman){
            if(str.contains(romanic.name())){
                check=true;
                break;
            }
        }

        return check;
    }
    public boolean arabicNumber(String str){
        boolean check=false;
         for(int i=0; i<str.length(); i++){
             char c= str.charAt(i);
             if(c>='0'&&c<='9'){
                 check=true;
                 break;
             }else {
                 check=false;
             }

         }
         return check;

    }
    public Integer calculate(int a , int b, String s) throws Exception{
        switch (s){
            case "*": return a*b;
            case "/": if(b!=0){
                return a/b;
            }
            throw new Exception("can not divide to 0");
            case  "+": return a+b;
            case "-": return a-b;
            default: throw new Exception("Can not execute mathematical operation");

        }
    }
}
