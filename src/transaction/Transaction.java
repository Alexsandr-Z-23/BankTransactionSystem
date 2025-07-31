package transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс, представляющий банковскую транзакцию
 */
public class Transaction {
    private final String id;
    private final String description;
    private final double amount;
    private final LocalDateTime timestamp;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(String id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Геттеры
    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %+.2f (%s)",
                id,
                description,
                amount,
                timestamp.format(formatter));
    }
}