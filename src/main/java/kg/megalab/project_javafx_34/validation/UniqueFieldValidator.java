package kg.megalab.project_javafx_34.validation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private String fieldName;
    private Class<?> entityClass;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Если null, пропускаем проверку
        }
        var query = entityManager.createQuery(
                "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value",
                Long.class
        );
        query.setParameter("value", value);
        Long count = query.getSingleResult();
        return count == 0;
    }

    @Override
    public void initialize(UniqueField constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.entityClass = constraintAnnotation.entityClass();
    }
}
