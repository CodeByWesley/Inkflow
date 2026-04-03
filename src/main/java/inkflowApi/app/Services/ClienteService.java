package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.models.Cliente;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static final ObjectMapper mapper = new ObjectMapper();

    public void salvar(List<Cliente> clientes) {
        try {
            File file = new File("Dados/clientes.json");
            file.mkdirs(); // cria a pasta se não existir
            mapper.writeValue(file, clientes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> carregar() {
        try {
            return mapper.readValue(
                    new File("Dados/clientes.json"),
                    new TypeReference<>() { }
            );

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Cliente> adicionarCliente(Cliente novoCliente) {
        List<Cliente> clientes = carregar();

        clientes.add(novoCliente);

        salvar(clientes);

        return clientes;
    }


}
