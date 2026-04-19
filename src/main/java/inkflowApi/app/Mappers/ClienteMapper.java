package inkflowApi.app.Mappers;

import inkflowApi.app.models.Cliente;
import inkflowApi.app.models.Dtos.ClienteDto;
import inkflowApi.app.models.Dtos.ClienteInputDto;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente toEntity(ClienteInputDto dto) {
        if (dto == null) return null;

        Cliente entity = new Cliente();

        entity.setNome(dto.nome());
        entity.setEmail(dto.email());
        entity.setTelefone(dto.telefone());
        entity.setSenha(dto.senha());
        return entity;
    }
    public ClienteDto toClienteDto(Cliente cliente) {
        if (cliente == null) return null;
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build();
    }
}

