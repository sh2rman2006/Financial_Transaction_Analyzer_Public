package sia.financial_transaction_analyzer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDto {
    @Email
    private String email;
    @NotBlank
    private String password;
}
