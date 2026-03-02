package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите сумму покупки: ");
        double sum = sc.nextDouble();

        System.out.print("Введите процент скидки: ");
        int discount = sc.nextInt();

        double finalPrice = sum - (sum * discount / 100);

        if(finalPrice < 0) finalPrice = 0;

        System.out.println("Итоговая цена: " + finalPrice);

        sc.close();
    }
}