package az.unibank.unibanktech.user;

import az.unibank.unibanktech.shared.UniquePin;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePinValidator implements ConstraintValidator<UniquePin, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String pin, ConstraintValidatorContext context) {
        User user = userRepository.findByPin(pin);
        return user == null;
    }

}