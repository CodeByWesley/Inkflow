package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Dtos.AgendamentoDto;
import inkflowApi.app.models.Dtos.AgendamentoInputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Agendamento> carregar() {
        return JsonHelper.carregarJson(
                "Dados/agendamentos.json",
                new TypeReference<List<Agendamento>>() {});
    }

    public List<Agendamento> adicionar(Agendamento ag) {
        List<Agendamento> agendamentos = carregar();

        agendamentos.add(ag);

        JsonHelper.criarJson(agendamentos, "Dados/agendamentos.json");

        return agendamentos;
    }
    public List<Agendamento> atualizar(Agendamento Agendamento) {
        return JsonHelper.atualizarJson(
                "Dados/agendamentos.json",
                Agendamento,
                c -> c.getId(), // Lambda dizendo que o ID vem de getId()
                new TypeReference<List<Agendamento>>() {}
        );
    }
    public List<Agendamento> remover(int id) {
        return JsonHelper.removerJson(
                "Dados/agendamentos.json",
                id,
                c -> c.getId(),
                new TypeReference<List<Agendamento>>() {}
        );
    }


}
