package sia.financial_transaction_analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("transactions")
public class Transaction {
    @Id
    private String id;
    @JsonIgnore
    private String userId;

    private LocalDateTime date;

    private TransactionCategory category;

    private String description;

    private double amount; // сумма

    private TransactionType type;
}
