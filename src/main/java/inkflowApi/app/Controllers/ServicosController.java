package inkflowApi.app.Controllers;

import inkflowApi.app.Services.ClienteService;
import inkflowApi.app.Services.ServicoService;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicoService _service;

    @GetMapping
    public List<Servico> carregar() {
        return _service.carregar();
    }
    @PostMapping
    public List<Servico> salvar(@RequestBody Servico servico) {
        return _service.adicionarServico(servico);
    }
    @PutMapping("/{id}")
    public List<Servico> atualizar(@RequestBody Servico servico, @PathVariable int id) {
        return _service.atualizarServico(servico);
    }
    @DeleteMapping("/{id}")
    public List<Servico> deletar(@PathVariable int id) {
        return _service.removerServico(id);
    }
}

