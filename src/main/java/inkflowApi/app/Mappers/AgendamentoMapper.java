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

    public Agendamento toEntity(AgendamentoInputDto dto, Cliente cliente, Servico servico) {
        if (dto == null) return null;

        Agendamento entity = new Agendamento();
        entity.setCliente(cliente);
        entity.setServico(servico);

        entity.setDataHora(dto.data_hora());
        entity.setValor(dto.valor());
        entity.setValorPago(dto.valor_pago());
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

