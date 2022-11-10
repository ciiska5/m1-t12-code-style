import java.net.URI;
import java.util.Scanner;
import java.io.IOException;

public class DepositCalculator {
    double calculateComplexPercent (double amount, double yearRate, int depositPeriod ) {
        double interest = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round (interest, 2);
    }

    double calculateSimplePercent (double amount,double yearRate, int depositPeriod) {
        return round (amount + amount * yearRrate * depositPeriod, 2);
    }

    double round (double value,int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateInterest() {
        int period;
        int action;
        int amount;
        Scanner abcdef = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = abcdef.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();

        double finalSum = 0;
        if (action == 1) {
            finalSum = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            finalSum = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateInterest();
    }
}
