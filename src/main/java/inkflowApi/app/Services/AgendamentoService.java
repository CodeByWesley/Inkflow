package inkflowApi.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inkflowApi.app.Helpers.JsonHelper;
import inkflowApi.app.Mappers.AgendamentoMapper;
import inkflowApi.app.Repositories.AgendamentoRepository;
import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Dtos.AgendamentoDto;
import inkflowApi.app.models.Dtos.AgendamentoInputDto;
import inkflowApi.app.models.Dtos.ClienteInputDto;
import inkflowApi.app.models.Servico;
import inkflowApi.app.models.enums.StatusAgendamento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AgendamentoService {
    private final AgendamentoMapper mapper;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private AgendamentoRepository repository;

    public AgendamentoService(AgendamentoMapper mapper) {
        this.mapper = mapper;
    }

    public List<AgendamentoDto> carregar() {
        var lista = repository.findAll();
        return lista.stream()
                .map(mapper::toDto)
                .toList();
    }
    public Agendamento getEntityById(int id) {
        var Agendamento = repository.findById(id);
        return Agendamento.orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
    }

    public AgendamentoDto adicionar(AgendamentoInputDto dto) {
        Cliente cliente = clienteService.getEntityById(dto.cliente_id());

        Servico servico = servicoService.getById(dto.servico_id());

        Agendamento ag = mapper.toEntity(dto, cliente, servico);
        ag.setStatusAgendamento(StatusAgendamento.PENDENTE);

        repository.save(ag);
        return mapper.toDto(ag);
    }
    public AgendamentoDto atualizar(Integer id, AgendamentoInputDto ag) {
        var entity = getEntityById(id);
        Cliente cliente = clienteService.getEntityById(ag.cliente_id());
        Servico servico = servicoService.getById(ag.servico_id());

        entity.setValor(ag.valor());
        entity.setValorPago(ag.valor_pago());
        entity.setCliente(cliente);
        entity.setServico(servico);
        entity.setDataHora(ag.data_hora());
        repository.save(entity);

        return mapper.toDto(entity);
    }
    public boolean remover(int id) {
        repository.deleteById(id);
        return true;
    }


}
