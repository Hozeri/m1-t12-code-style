import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double complexPercent = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(complexPercent, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositIncome() {
        int depositPeriod;
        int depositType;
        int amount;
        double income = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            income = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            income = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositIncome();
    }
}
