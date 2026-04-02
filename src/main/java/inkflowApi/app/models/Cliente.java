package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Cliente {
    public int Id;
    public String Nome;
    public String Telefone;
    private List<Agendamento> agendamentos = new ArrayList<>();

    }
