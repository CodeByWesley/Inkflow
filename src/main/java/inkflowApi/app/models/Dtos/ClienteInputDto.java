package inkflowApi.app.models.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClienteInputDto(
        @NotNull String nome,
        @NotNull String telefone,
        @Email String email,
        @NotNull String senha
) {}
