package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Servico {
    private int id;
    private String nome;
    private BigDecimal valorBase;
}
