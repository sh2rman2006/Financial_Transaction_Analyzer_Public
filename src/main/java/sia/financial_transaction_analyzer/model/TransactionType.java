package sia.financial_transaction_analyzer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    CREDIT("Credit"), // Пополнение баланса, доход
    DEBIT("Debit"), // Списание средств, расход
    TRANSFER("Transfer"), // Перевод средств между счетами
    FEE("Fee"); // Комиссия или плата за услугу

    private final String type;

    @Override
    public String toString(){
        return this.type;
    }
}
