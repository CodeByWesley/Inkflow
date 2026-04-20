package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.Repositories.ServicoRepository;
import inkflowApi.app.models.Servico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicoService {
@Autowired
private ServicoRepository repository;

    public Servico getById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Servico não encontrado"));
    }

    public List<Servico> carregar() {
        return JsonHelper.carregarJson(
                "Dados/servicos.json",
                new TypeReference<List<Servico>>() {});
    }

    public Servico adicionarServico(Servico novoServico) {
        Servico entity = new Servico();
        entity.setNome(novoServico.getNome());
        entity.setValor_base(novoServico.getValor_base());
        repository.save(entity);

        return entity;
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
