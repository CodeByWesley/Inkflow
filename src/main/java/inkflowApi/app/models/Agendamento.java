package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Agendamento {
    public Cliente cliente;
    public Servico servico;
}
