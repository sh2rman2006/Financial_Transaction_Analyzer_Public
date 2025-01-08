package sia.financial_transaction_analyzer.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sia.financial_transaction_analyzer.repository.AuthUserRepository;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
