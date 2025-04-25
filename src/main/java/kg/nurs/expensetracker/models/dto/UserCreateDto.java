package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

public record UserCreateDto(
        @NotBlank
        @NotNull
        @Size(min = 2, max = 50)
        String name,

        @NotBlank
        @NotNull
        @Email
        String email,

        @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
        LocalDateTime createdAt
) {
}
