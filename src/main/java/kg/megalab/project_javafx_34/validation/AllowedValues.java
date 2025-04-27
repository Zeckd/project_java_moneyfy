package kg.megalab.project_javafx_34.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedValues {
    String message() default "Недопустимое значение";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] values();
}
