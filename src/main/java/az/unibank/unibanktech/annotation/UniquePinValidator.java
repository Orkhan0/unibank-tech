package az.unibank.unibanktech.annotation;

import az.unibank.unibanktech.domain.User;
import az.unibank.unibanktech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniquePinValidator implements ConstraintValidator<UniquePin, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String pin, ConstraintValidatorContext context) {
        return !userRepository.findByPin(pin).isPresent();
    }

}