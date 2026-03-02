package org.example;
import java.util.Scanner;

public class Main {
    /**
     * Калькулятор скидки на покупку с защитой от некорректного ввода.
     */
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                double purchaseAmount = readPositiveDouble(scanner, "Введите сумму покупки: ");
                int discountPercent = readDiscountPercent(scanner);

                double discountAmount = purchaseAmount * discountPercent / 100.0;
                double finalPrice = Math.max(0, purchaseAmount - discountAmount);

                System.out.printf("Итоговая цена со скидкой %d%%: %.2f%n", discountPercent, finalPrice);
            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе данных.");
            }
        }

        private static double readPositiveDouble(Scanner sc, String prompt) {
            while (true) {
                System.out.print(prompt);
                if (sc.hasNextDouble()) {
                    double value = sc.nextDouble();
                    if (value >= 0) return value;
                    System.out.println("Сумма не может быть отрицательной. Попробуйте снова.");
                } else {
                    System.out.println("Введите число. Попробуйте снова.");
                    sc.next();
                }
            }
        }
        private static int readDiscountPercent(Scanner sc) {
            while (true) {
                System.out.print("Введите процент скидки (0–100): ");
                if (sc.hasNextInt()) {
                    int percent = sc.nextInt();
                    if (percent >= 0 && percent <= 100) return percent;
                    System.out.println("Скидка должна быть от 0 до 100%.");
                } else {
                    System.out.println("Введите целое число.");
                    sc.next();
                }
            }
        }
    }
