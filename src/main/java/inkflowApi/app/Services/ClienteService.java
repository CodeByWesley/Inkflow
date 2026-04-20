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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    private final ClienteMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ClienteService(ClienteMapper mapper) {
        this.mapper = mapper;
    }

    public Cliente getEntityById(int id) {
        var cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }
    public ClienteDto getDtoById(int id) {
        var cliente = getEntityById(id);
        return mapper.toClienteDto(cliente);
    }

    public List<ClienteDto> carregar() {
        var clientes = repository.findAll();
        return clientes.stream()
                .map(mapper::toClienteDto)
                .toList();

    }

    public ClienteDto adicionarCliente(ClienteInputDto novoCliente) {
        var entity = mapper.toEntity(novoCliente);

        String senhaCriptografada = passwordEncoder.encode(entity.getSenha());
        entity.setSenha(senhaCriptografada);

        repository.save(entity);
        return mapper.toClienteDto(entity);

    }
    public ClienteDto atualizarCliente(Integer id, ClienteInputDto cliente) {

        var entity = getEntityById(id);

        entity.setNome(cliente.nome());
        entity.setEmail(cliente.email());
        entity.setTelefone(cliente.telefone());
        repository.save(entity);

        return mapper.toClienteDto(entity);
    }
    public boolean removerCliente(int id) {
         repository.deleteById(id);
         return true;
    }


}
