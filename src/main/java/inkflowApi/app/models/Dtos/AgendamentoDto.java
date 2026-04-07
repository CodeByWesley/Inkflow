package inkflowApi.app.models.Dtos;

import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Servico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoDto(
         int id,
         BigDecimal valor,
         BigDecimal valorPago, // eventualmente usar sum(Pagamentos)
         LocalDateTime dataHora,
         String clienteNome,
         String servicoNome) {
    public static AgendamentoDto fromEntity(Agendamento entity) {
        return new AgendamentoDto(
                entity.getId(),
                entity.getValor(),
                entity.getValorPago(),
                entity.getDataHora(),
                entity.getCliente() != null ? entity.getCliente().getNome() : "N/A",
                entity.getServico() != null ? entity.getServico().getNome() : "N/A"
        );
    }
}
