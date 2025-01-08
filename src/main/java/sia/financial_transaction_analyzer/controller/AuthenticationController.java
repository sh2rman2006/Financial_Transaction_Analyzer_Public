package sia.financial_transaction_analyzer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.financial_transaction_analyzer.dto.LoginUserDto;
import sia.financial_transaction_analyzer.dto.RegisterUserDto;
import sia.financial_transaction_analyzer.dto.VerifyUserDto;
import sia.financial_transaction_analyzer.model.AuthUser;
import sia.financial_transaction_analyzer.responses.LoginResponse;
import sia.financial_transaction_analyzer.service.AuthEmailService;
import sia.financial_transaction_analyzer.service.JwtService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthEmailService authEmailService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterUserDto registerUserDto) {
        AuthUser authUser = authEmailService.signUp(registerUserDto);
        if (authUser != null) {
            return ResponseEntity.ok("check your email");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("user already exists");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto) {
        AuthUser authUser = authEmailService.authenticate(loginUserDto);
        String token = jwtService.generateToken(authUser.getEmail());
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            AuthUser authUser = authEmailService.verifyUser(verifyUserDto);
            LoginResponse loginResponse = new LoginResponse(jwtService.generateToken(authUser.getEmail()));
            return ResponseEntity.ok(loginResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint() {
        return ResponseEntity.ok("protected");
    }

}
