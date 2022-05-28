package az.unibank.unibanktech.service.impl;

import az.unibank.unibanktech.domain.User;
import az.unibank.unibanktech.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void when_find_user_by_pin_then_get_successful_user(){
        User user = User
                .builder()
                .pin("1234567")
                .build();
        when(userRepository.findByPin("1234567")).thenReturn(Optional.of(user));

        User currentUser = userService.findUserByPin("1234567");

        assertEquals("1234567", currentUser.getPin());
    }


}