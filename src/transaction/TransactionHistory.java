package transaction;

import exception.TransactionException;

import java.util.LinkedList;

/**
 * Класс для управления историей транзакций с поддержкой Undo/Redo
 */
public class TransactionHistory {
    private final LinkedList<Transaction> transactions = new LinkedList<>();
    private final LinkedList<Transaction> undoneTransactions = new LinkedList<>();
    private int maxHistorySize = 100; // Лимит истории

    /**
     * Добавляет новую транзакцию
     */
    public void addTransaction(Transaction transaction) throws TransactionException {
        if (transactions.size() >= maxHistorySize) {
            transactions.removeFirst(); // Удаляем самую старую транзакцию
        }
        transactions.addLast(transaction);
        undoneTransactions.clear(); // Сброс стека Redo при новом действии
    }

    /**
     * Отменяет последнюю транзакцию (Undo)
     */
    public Transaction undo() throws TransactionException {
        if (transactions.isEmpty()) {
            throw new TransactionException("Нет операций для отмены");
        }
        Transaction last = transactions.removeLast();
        undoneTransactions.addLast(last);
        return last;
    }

    /**
     * Повторяет отмененную транзакцию (Redo)
     */
    public Transaction redo() throws TransactionException {
        if (undoneTransactions.isEmpty()) {
            throw new TransactionException("Нет операций для повтора");
        }
        Transaction lastUndone = undoneTransactions.removeLast();
        transactions.addLast(lastUndone);
        return lastUndone;
    }

    /**
     * Выводит историю транзакций
     */
    public void printHistory() {
        System.out.println("\n=== История транзакций ===");
        if (transactions.isEmpty()) {
            System.out.println("История пуста");
            return;
        }
        transactions.forEach(System.out::println);
    }

    // Геттеры/сеттеры
    public void setMaxHistorySize(int size) {
        this.maxHistorySize = size;
    }
}