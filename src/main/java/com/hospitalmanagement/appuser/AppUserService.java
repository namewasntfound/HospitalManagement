package com.hospitalmanagement.appuser;

import com.hospitalmanagement.registration.token.ConfirmationToken;
import com.hospitalmanagement.registration.token.ConfirmationTokenRepository;
import com.hospitalmanagement.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private static final String USER_NOT_FOUND_MSG = "User with %s email not found";
    private final AppUserRepository appUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser user) {
        boolean userExists = appUserRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("Email is already taken.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        appUserRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(7),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
