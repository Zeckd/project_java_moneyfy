package kg.megalab.project_javafx_34.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsEntityValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEntity {
    String message() default "Объект по данному id не найден";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> entityClass();
    String fieldName() default "id";
}
