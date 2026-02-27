package dobledsoftware.proveedores.features.proveedores.mappers;

import dobledsoftware.proveedores.features.proveedores.data.ProveedorDto;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public ProveedorDto mapToDto(ProveedorEntity entity) {
        if (entity == null) {
            return null;
        }
        ProveedorDto dto = new ProveedorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setStatus(entity.getStatus());
        dto.setCuilCuit(entity.getCuilCuit());
        dto.setUserId(entity.getUserId());
        dto.setModificationDate(entity.getModificationDate());
        return dto;
    }

    public ProveedorEntity toEntity(ProveedorDto dto) {
        if (dto == null) {
            return null;
        }
        ProveedorEntity entity = new ProveedorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setRegistrationDate(dto.getRegistrationDate());
        entity.setStatus(dto.getStatus());
        entity.setCuilCuit(dto.getCuilCuit());
        entity.setUserId(dto.getUserId());
        entity.setModificationDate(dto.getModificationDate());
        return entity;
    }
}
