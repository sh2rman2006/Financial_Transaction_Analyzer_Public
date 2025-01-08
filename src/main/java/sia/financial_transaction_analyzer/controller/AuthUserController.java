package sia.financial_transaction_analyzer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.financial_transaction_analyzer.model.AuthUser;
import sia.financial_transaction_analyzer.responses.ProfileResponse;

@RestController
@RequestMapping("/user")
public class AuthUserController {

    @GetMapping("/me")
    public ResponseEntity<?> getProfile(Authentication auth) {
        AuthUser user = (AuthUser) auth.getPrincipal();
        ProfileResponse profileResponse = new ProfileResponse(user.getFirstName(), user.getLastName(), user.getEmail());
        return ResponseEntity.ok(profileResponse);
    }
}
