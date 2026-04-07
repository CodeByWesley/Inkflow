package inkflowApi.app.models.Dtos;


import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Servico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoInputDto(
        @NotNull BigDecimal valor,
        @NotNull BigDecimal valorPago,
        @Future LocalDateTime dataHora,
        @NotNull int clienteId,
        @NotNull int servicoId
) {
    public Agendamento toEntity() {
        Agendamento entity = new Agendamento();
        entity.setValor(this.valor);
        entity.setDataHora(this.dataHora);

        Cliente c = new Cliente(); c.setId(this.clienteId);
        Servico s = new Servico(); s.setId(this.servicoId);

        entity.setCliente(c);
        entity.setServico(s);
        return entity;
    }
}
