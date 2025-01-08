package sia.financial_transaction_analyzer.service;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sia.financial_transaction_analyzer.dto.LoginUserDto;
import sia.financial_transaction_analyzer.dto.RegisterUserDto;
import sia.financial_transaction_analyzer.dto.VerifyUserDto;
import sia.financial_transaction_analyzer.model.AuthUser;
import sia.financial_transaction_analyzer.model.CustomRole;
import sia.financial_transaction_analyzer.repository.AuthUserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthEmailService {
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthUser signUp(RegisterUserDto registerUserDto) {
        if (authUserRepository.existsByEmail(registerUserDto.getEmail())) {
            if (authUserRepository.existsByEmailAndIsAccountEnabled(registerUserDto.getEmail(), true)) {
                return null;
            } else {
                authUserRepository.deleteByEmail(registerUserDto.getEmail());
            }
        }
        AuthUser authUser = new AuthUser(
                registerUserDto.getFirstName(),
                registerUserDto.getLastName(),
                registerUserDto.getEmail(),
                passwordEncoder.encode(registerUserDto.getPassword()),
                Set.of(CustomRole.USER),
                generateVerificationCode(),
                LocalDateTime.now().plusMinutes(15),
                true,
                false
        );
        sendVerificationEmail(authUser);
        authUserRepository.save(authUser);
        return authUser;
    }

    public AuthUser authenticate(LoginUserDto loginUserDto) {
        Optional<AuthUser> optionalAuthUser = authUserRepository.findByEmail(loginUserDto.getEmail());
        if (optionalAuthUser.isPresent()) {
            AuthUser authUser = optionalAuthUser.get();

            if (!authUser.isEnabled()) {
                throw new RuntimeException("Account not verified. Please verify your account.");
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginUserDto.getEmail(),
                    loginUserDto.getPassword()));
            return authUser;
        }
        throw new RuntimeException("User not found");
    }

    public AuthUser verifyUser(VerifyUserDto verifyUserDto) {
        Optional<AuthUser> optionalAuthUser = authUserRepository.findByEmail(verifyUserDto.getEmail());
        if (optionalAuthUser.isPresent()) {
            AuthUser authUser = optionalAuthUser.get();

            if (authUser.getVerificationExpiresAt().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("verification code has expired");
            }

            if (authUser.getVerificationCode().equals(verifyUserDto.getVerificationCode())) {
                authUser.setAccountEnabled(true);
                authUser.setVerificationCode(null);
                authUser.setVerificationExpiresAt(null);
                authUserRepository.save(authUser);
                return authUser;
            } else {
                throw new RuntimeException("verification code is incorrect");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }


    public void sendVerificationEmail(AuthUser authUser) {
        String subject = "Verification Code";
        String verificationCode = authUser.getVerificationCode();
        String htmlMessage = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Welcome to our app!</h2>"
                + "<p style=\"font-size: 16px;\">Please enter the verification code below to continue:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Verification Code:</h3>"
                + "<p style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        try {
            emailService.sendVerificationEmail(authUser.getEmail(), subject, htmlMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
