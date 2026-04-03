package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private List<Agendamento> agendamentos = new ArrayList<>();

    }
