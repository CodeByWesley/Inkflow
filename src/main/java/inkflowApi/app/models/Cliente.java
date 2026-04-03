package inkflowApi.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class Cliente {
    public int Id;
    private int idade;
    private String numeroTelefone;
    private String email;
    private String senha;
    private String nomeCliente;
    private Endereco endereco;



    }
