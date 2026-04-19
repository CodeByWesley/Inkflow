package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.Mappers.ClienteMapper;
import inkflowApi.app.Repositories.ClienteRepository;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Dtos.ClienteDto;
import inkflowApi.app.models.Dtos.ClienteInputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteMapper mapper) {
        this.mapper = mapper;
    }

    public Cliente getById(int id) {
        var cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

    }

    public List<Cliente> carregar() {
        return repository.findAll();
    }

    public ClienteDto adicionarCliente(ClienteInputDto novoCliente) {
        var entity = mapper.toEntity(novoCliente);
        repository.save(entity);
        return mapper.toClienteDto(entity);

    }
    public List<Cliente> atualizarCliente(Cliente cliente) {
         return JsonHelper.atualizarJson(
                "Dados/clientes.json",
                cliente,
                c -> c.getId(), // Lambda dizendo que o ID vem de getId()
                new TypeReference<List<Cliente>>() {}
        );
    }
    public List<Cliente> removerCliente(int id) {
        return JsonHelper.removerJson(
                "Dados/clientes.json",
                id,
                c -> c.getId(),
                new TypeReference<List<Cliente>>() {}
        );
    }


}
