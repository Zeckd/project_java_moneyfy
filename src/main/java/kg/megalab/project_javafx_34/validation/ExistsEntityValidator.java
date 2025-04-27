package kg.megalab.project_javafx_34.validation;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsEntityValidator implements ConstraintValidator<ExistsEntity, Long> {

    private EntityManager entityManager;

    private Class<?> entityClass;
    private String fieldName;

    @Override
    public void initialize(ExistsEntity constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {

        String query = "select count(e) from "+ entityClass.getSimpleName()+" e where e."+fieldName+" = :value";
        Long count = (Long) entityManager.createQuery((query)).setParameter("value", value).getSingleResult();

        return count > 0;
    }
}
