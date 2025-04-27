package kg.megalab.project_javafx_34.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import kg.megalab.project_javafx_34.models.User;
import kg.megalab.project_javafx_34.validation.UniqueField;

import java.time.LocalDateTime;

public record UserCreateDto(
        @NotNull
        @NotEmpty
        @Size(min = 2, max = 255)
        String name,
        @NotEmpty(message = "Email не должен быть пустым")
        @NotNull(message = "Email не должен быть null")
        @NotBlank(message = "Email не должен содержать пробелов")
        @Email(message = "Некорректный email")
        @UniqueField(fieldName = "email", entityClass = User.class, message = "Такой email уже существует")
        String email,

        @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
        LocalDateTime createdAt
) {
}
