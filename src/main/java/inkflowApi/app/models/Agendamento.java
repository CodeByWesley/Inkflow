package inkflowApi.app.models;

import inkflowApi.app.models.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data // Gera Getter, Setter, equals, hashCode e toString
public class Agendamento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private BigDecimal valor;
    private BigDecimal valorPago; // eventualmente usar sum(Pagamentos)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

}
