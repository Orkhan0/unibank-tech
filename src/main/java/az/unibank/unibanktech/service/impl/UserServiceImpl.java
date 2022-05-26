package az.unibank.unibanktech.service.impl;

import az.unibank.unibanktech.domain.User;
import az.unibank.unibanktech.dto.request.UserRequest;
import az.unibank.unibanktech.exception.NotFoundException;
import az.unibank.unibanktech.repository.UserRepository;
import az.unibank.unibanktech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public User findUserByPin(String pin) {
        return userRepository.findByPin(pin)
                .orElseThrow(() -> new UsernameNotFoundException("PIN not found"));
    }

    @Override
    public Long saveUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

}