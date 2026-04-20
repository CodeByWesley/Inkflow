package inkflowApi.app.Controllers;

import inkflowApi.app.Services.AgendamentoService;
import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Dtos.AgendamentoDto;
import inkflowApi.app.models.Dtos.AgendamentoInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {
    @Autowired
    private AgendamentoService _service;

    @GetMapping
    public List<AgendamentoDto> carregar() {
        return _service.carregar();
    }
    @PostMapping
    public AgendamentoDto salvar(@RequestBody AgendamentoInputDto Agendamento) {
        return _service.adicionar(Agendamento);
    }
    @PutMapping("/{id}")
    public AgendamentoDto atualizar(@RequestBody AgendamentoInputDto Agendamento, @PathVariable int id) {
        return _service.atualizar(id, Agendamento);
    }
    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable int id) {
        return _service.remover(id);
    }
}

