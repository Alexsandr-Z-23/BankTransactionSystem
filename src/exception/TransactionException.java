package exception;

/**
 * Кастомное исключение для ошибок транзакций
 */
public class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}