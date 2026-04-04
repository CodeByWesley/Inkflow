package inkflowApi.app.Controllers;

import inkflowApi.app.Services.ClienteService;
import inkflowApi.app.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> carregar() {
        return clienteService.carregar();
    }
    @PostMapping
    public List<Cliente> salvar(@RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }
    @PutMapping("/{id}")
    public List<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable int id) {
        return clienteService.atualizarCliente(cliente);
    }
    @DeleteMapping("/{id}")
    public List<Cliente> deletar(@PathVariable int id) {
        return clienteService.removerCliente(id);
    }
}
