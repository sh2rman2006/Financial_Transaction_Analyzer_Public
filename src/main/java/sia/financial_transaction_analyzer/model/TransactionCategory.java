package sia.financial_transaction_analyzer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionCategory {
    CREDIT("Credit"),          // Пополнение баланса, доход
    DEBIT("Debit"),           // Списание средств, расход

    GROCERIES("Groceries"),       // Продукты питания
    RENT("Rent"),             // Аренда жилья
    UTILITIES("Utilities"),     // Коммунальные услуги
    TRANSPORTATION("Transportation"), // Транспорт
    ENTERTAINMENT("Entertainment"),  // Развлечения
    RESTAURANTS("Restaurants"),    // Питание в ресторанах
    CLOTHING("Clothing"),          // Одежда
    HEALTHCARE("Healthcare"),         // Медицина
    EDUCATION("Education"),        // Обучение
    GIFTS("Gifts"),               // Подарки
    TRAVEL("Travel"),           // Путешествия
    SUBSCRIPTIONS("Subscriptions"), // Подписки
    HOBBIES("Hobbies"),           // Хобби
    OTHER("Other"),             // Прочее

    SALARY("Salary"),           // Зарплата
    SAVINGS("Savings");          // Сбережения

    private final String category;

    @Override
    public String toString(){
        return this.category;
    }
}