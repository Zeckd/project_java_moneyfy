package kg.megalab.project_javafx_34.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class AllowedValuesValidator implements ConstraintValidator<AllowedValues, String> {

    private String[] allowedValues;


    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return true;
        }
        return Arrays.asList(allowedValues).contains(value.toUpperCase());
    }
}
