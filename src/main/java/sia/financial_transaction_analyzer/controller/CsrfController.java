package sia.financial_transaction_analyzer.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csrf")
public class CsrfController {

    @GetMapping
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }
}
