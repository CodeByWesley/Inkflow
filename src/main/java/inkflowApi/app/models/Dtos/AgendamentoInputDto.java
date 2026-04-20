package inkflowApi.app.models.Dtos;


import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Servico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AgendamentoInputDto(
        @NotNull BigDecimal valor,
        @NotNull BigDecimal valor_pago,
        @Future LocalDateTime data_hora,
        @NotNull int cliente_id,
        @NotNull int servico_id
) { }
