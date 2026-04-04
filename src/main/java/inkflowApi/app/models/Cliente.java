package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String telefone;
    private String email;
    private String senha;
    private Endereco endereco;
    private List<Agendamento> agendamentos = new ArrayList<>();


    }
