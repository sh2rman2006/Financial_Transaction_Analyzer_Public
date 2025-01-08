package sia.financial_transaction_analyzer.repository;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sia.financial_transaction_analyzer.model.AuthUser;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String> {

    Optional<AuthUser> findByEmail(String email);

    Optional<AuthUser> findByVerificationCode(String verificationCode);

    void deleteByEmail(String email);

    boolean existsByEmailAndIsAccountEnabled(@NotBlank String email, boolean accountEnabled);

    boolean existsByEmail(String email);
}
