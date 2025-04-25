package kg.megalab.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String name,
        String email,
        @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
        LocalDateTime createdAt
) {
}
