package inkflowApi.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data // Gera Getter, Setter, equals, hashCode e toString
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Agendamento> agendamentos;

    }
