package sia.financial_transaction_analyzer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import sia.financial_transaction_analyzer.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserId(String userId);

    boolean existsByUserId(String userId);

    @Query(sort = "{date: -1}")
    Page<Transaction> findByUserId(String userId, Pageable pageable);

    @Query(value = "{ userId: ?0, date: { $gte: ?1, $lte: ?2 }}", sort = "{date: -1}")
    List<Transaction> findByUserIdAndDateAfterAndDateBefore(String userId, String startDate, String endDate);
}
