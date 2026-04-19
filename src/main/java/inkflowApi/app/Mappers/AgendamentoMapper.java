package inkflowApi.app.Mappers;

import inkflowApi.app.models.Agendamento;
import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Dtos.AgendamentoDto;
import inkflowApi.app.models.Dtos.AgendamentoInputDto;
import inkflowApi.app.models.Dtos.ClienteDto;
import inkflowApi.app.models.Servico;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {
    private final ClienteMapper clienteMapper;
    public AgendamentoMapper(ClienteMapper clienteMapper) {
        this.clienteMapper = clienteMapper;
    }

    public Agendamento toEntity(AgendamentoInputDto dto) {
        if (dto == null) return null;

        Agendamento entity = new Agendamento();
        Cliente cliente = new Cliente();
        cliente.setId(dto.clienteId());
        entity.setCliente(cliente);

        Servico servico = new Servico();
        servico.setId(dto.servicoId());
        entity.setServico(servico);

        entity.setDataHora(dto.dataHora());
        entity.setValor(dto.valor());
        entity.setValorPago(dto.valorPago());
        return entity;
    }

    public AgendamentoDto toDto(Agendamento entity) {
        if (entity == null) return null;

        return AgendamentoDto.builder()
                .id(entity.getId())
                .cliente(clienteMapper.toClienteDto(entity.getCliente()))
                .servicoNome(entity.getServico() != null ? entity.getServico().getNome() : "Serviço não carregado")
                .valor(entity.getValor())
                .valorPago(entity.getValorPago())
                .dataHora(entity.getDataHora())
                .build();
    }



        // Mapeando o objeto aninhado (Cliente -> ClienteResumoDto)
       /* if (entity.getCliente() != null) {
            ClienteResumoDto clienteDto = new ClienteResumoDto();
            clienteDto.setId(entity.getCliente().getId());
            clienteDto.setNome(entity.getCliente().getNome());
            dto.setCliente(clienteDto);
        } */


    }

