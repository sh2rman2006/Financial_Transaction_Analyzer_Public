package sia.financial_transaction_analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Data
@Document("users")
public class AuthUser implements UserDetails {
    @Id
    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Indexed(unique = true)
    @NotBlank
    private String email;
    @NotBlank
    @JsonIgnore
    private String password;
    @NotEmpty
    private Set<CustomRole> role;

    private String verificationCode;

    private LocalDateTime verificationExpiresAt;

    private boolean isAccountNonLocked;

    private boolean isAccountEnabled;

    public AuthUser(String firstName, String lastName, String email, String password, Set<CustomRole> role,
                    String verificationCode, LocalDateTime verificationExpiresAt,
                    boolean isAccountNonLocked, boolean isAccountEnabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.verificationCode = verificationCode;
        this.verificationExpiresAt = verificationExpiresAt;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountEnabled = isAccountEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return isAccountEnabled;
    }
}
