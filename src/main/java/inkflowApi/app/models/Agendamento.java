package inkflowApi.app.models;

import inkflowApi.app.models.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Agendamento {
    private int id;
    private BigDecimal valor;
    private BigDecimal valorPago; // eventualmente usar sum(Pagamentos)
    private LocalDateTime dataHora;
    private Cliente cliente;
    private Servico servico;
    private StatusAgendamento statusAgendamento;

}
