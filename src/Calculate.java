import serviceManager.CalcManager;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        CalcManager calcManage = new CalcManager();
        System.out.println(calcManage.getResult(s1));
    }
}
