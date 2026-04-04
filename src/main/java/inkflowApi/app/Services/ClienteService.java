package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.models.Cliente;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static final ObjectMapper mapper = new ObjectMapper();


    public List<Cliente> carregar() {
        return JsonHelper.carregarJson(
                "Dados/clientes.json",
                 new TypeReference<List<Cliente>>() {});
    }

    public List<Cliente> adicionarCliente(Cliente novoCliente) {
        List<Cliente> clientes = carregar();

        clientes.add(novoCliente);

        JsonHelper.criarJson(clientes, "Dados/clientes.json");

        return clientes;
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
