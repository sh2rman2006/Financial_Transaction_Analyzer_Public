package sia.financial_transaction_analyzer.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sia.financial_transaction_analyzer.model.AuthUser;
import sia.financial_transaction_analyzer.model.Transaction;
import sia.financial_transaction_analyzer.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {
    private final TransactionRepository transactionRepository;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTransactions(Authentication authentication) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        if (transactionRepository.existsByUserId(authUser.getId())) {
            return ResponseEntity.ok(transactionRepository.findAll());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pagination")
    public Page<Transaction> pagination(Pageable pageable, Authentication authentication) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        if (transactionRepository.existsByUserId(authUser.getId())) {
            return transactionRepository.findByUserId(authUser.getId(), pageable);
        }
        return null;
    }


    @GetMapping("/getMonthHistory")
    public ResponseEntity<?> getTransactionsByMonth(
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            Authentication authentication) {

        if (year < 1900 || year > 2100) {
            return ResponseEntity.badRequest().body("Invalid year");
        }

        if (month < 1 || month > 12) {
            return ResponseEntity.badRequest().body("Invalid month");
        }

        // Создаем локальную дату и время с учетом UTC
        LocalDateTime startDateTime = LocalDateTime.of(year, month, 1, 0, 0, 0, 0);
        LocalDateTime endDateTime = startDateTime.plusMonths(1);

        // Конвертируем LocalDateTime в строку ISO 8601
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String startDateStr = startDateTime.format(formatter);
        String endDateStr = endDateTime.format(formatter);

        AuthUser authUser = (AuthUser) authentication.getPrincipal();

        if (transactionRepository.existsByUserId(authUser.getId())) {
            List<Transaction> transactions = transactionRepository.findByUserIdAndDateAfterAndDateBefore(
                    authUser.getId(), startDateStr, endDateStr);
            return ResponseEntity.ok(transactions);
        }

        return ResponseEntity.noContent().build();
    }


}
