package az.unibank.unibanktech.shared;

import az.unibank.unibanktech.user.UniquePinValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniquePinValidator.class})
public @interface UniquePin {

    String message() default "This pin is in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}