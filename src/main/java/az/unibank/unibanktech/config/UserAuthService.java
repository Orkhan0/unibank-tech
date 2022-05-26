package az.unibank.unibanktech.config;

import az.unibank.unibanktech.user.User;
import az.unibank.unibanktech.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pin) throws UsernameNotFoundException {
        User inDb = userRepository.findByPin(pin);
        if (inDb == null){
            throw new UsernameNotFoundException("PIN not found");
        }
        return inDb;
    }
}