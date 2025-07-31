package app;

import transaction.Transaction;
import transaction.TransactionHistory;
import exception.TransactionException;

import java.util.Scanner;

/**
 * Главный класс приложения
 */
public class BankApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TransactionHistory history = new TransactionHistory();

    public static void main(String[] args) {
        history.setMaxHistorySize(5); // Установим лимит истории

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addTransaction();
                    case "2" -> undoTransaction();
                    case "3" -> redoTransaction();
                    case "4" -> history.printHistory();
                    case "0" -> { return; }
                    default -> System.out.println("Неверный ввод");
                }
            } catch (TransactionException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Банковское приложение ===");
        System.out.println("1. Добавить транзакцию");
        System.out.println("2. Отменить (Undo)");
        System.out.println("3. Повторить (Redo)");
        System.out.println("4. Показать историю");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void addTransaction() throws TransactionException {
        System.out.print("Введите ID транзакции: ");
        String id = scanner.nextLine();
        System.out.print("Введите описание: ");
        String desc = scanner.nextLine();
        System.out.print("Введите сумму: ");
        double amount = Double.parseDouble(scanner.nextLine());

        history.addTransaction(new Transaction(id, desc, amount));
        System.out.println("Транзакция добавлена!");
    }

    private static void undoTransaction() throws TransactionException {
        Transaction undone = history.undo();
        System.out.println("Отменено: " + undone);
    }

    private static void redoTransaction() throws TransactionException {
        Transaction redone = history.redo();
        System.out.println("Повторено: " + redone);
    }
}