package inkflowApi.app.models.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
        @NotNull int id,
        String nome,
        String telefone,
        @Email String email

) {
}
