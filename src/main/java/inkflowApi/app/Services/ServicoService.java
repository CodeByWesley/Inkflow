package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.models.Servico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Servico> carregar() {
        return JsonHelper.carregarJson(
                "Dados/servicos.json",
                new TypeReference<List<Servico>>() {});
    }

    public List<Servico> adicionarServico(Servico novoServico) {
        List<Servico> servicos = carregar();

        servicos.add(novoServico);

        JsonHelper.criarJson(servicos, "Dados/servicos.json");

        return servicos;
    }
    public List<Servico> atualizarServico(Servico cliente) {
        return JsonHelper.atualizarJson(
                "Dados/servicos.json",
                cliente,
                c -> c.getId(), // Lambda dizendo que o ID vem de getId()
                new TypeReference<List<Servico>>() {}
        );
    }
    public List<Servico> removerServico(int id) {
        return JsonHelper.removerJson(
                "Dados/servicos.json",
                id,
                c -> c.getId(),
                new TypeReference<List<Servico>>() {}
        );
    }
}
