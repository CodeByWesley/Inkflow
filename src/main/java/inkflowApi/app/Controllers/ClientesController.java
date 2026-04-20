package inkflowApi.app.Controllers;

import inkflowApi.app.Services.ClienteService;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Dtos.ClienteDto;
import inkflowApi.app.models.Dtos.ClienteInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> carregar() {
        return clienteService.carregar();
    }
    @PostMapping
    public ClienteDto salvar(@RequestBody ClienteInputDto cliente) {
        return clienteService.adicionarCliente(cliente);
    }
    @PutMapping("/{id}")
    public ClienteDto atualizar(@RequestBody ClienteInputDto cliente, @PathVariable int id) {
        return clienteService.atualizarCliente(id, cliente);
    }
    @GetMapping("/{id}")
    public ClienteDto getById(@PathVariable int id) {
        return clienteService.getDtoById(id);
    }
    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable int id) {
        return clienteService.removerCliente(id);
    }
}
