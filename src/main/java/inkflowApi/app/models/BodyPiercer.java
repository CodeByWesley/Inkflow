package inkflowApi.app.models;

import lombok.Data;

@Data // Gera Getter, Setter, equals, hashCode e toString
public class BodyPiercer {
    public int Id;
    private String cpf;
    private String nomeBodyPiercer;
    private String email;
    private String numeroTelefone;



}
