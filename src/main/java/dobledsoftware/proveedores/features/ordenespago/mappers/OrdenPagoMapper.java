package dobledsoftware.proveedores.features.ordenespago.mappers;

import dobledsoftware.proveedores.features.ordenespago.data.OrdenPagoDto;
import dobledsoftware.proveedores.features.ordenespago.entities.OrdenPagoEntity;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import org.springframework.stereotype.Component;

@Component
public class OrdenPagoMapper {

    public OrdenPagoDto toDto(OrdenPagoEntity entity) {
        if (entity == null) {
            return null;
        }
        OrdenPagoDto dto = new OrdenPagoDto();
        dto.setId(entity.getId());
        dto.setNroOperacion(entity.getNroOperacion());
        dto.setFecha(entity.getFecha());
        dto.setConcepto(entity.getConcepto());
        dto.setIdEstado(entity.getIdEstado());
        dto.setImporteTotal(entity.getImporteTotal());
        dto.setImportePagado(entity.getImportePagado());
        dto.setRutaArchivo(entity.getRutaArchivo());
        dto.setFechaAlta(entity.getFechaAlta());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setUltimaModificacion(entity.getUltimaModificacion());
        dto.setEstado(entity.getEstado());
        dto.setFormaPago(entity.getFormaPago());
        dto.setMontoTotal(entity.getMontoTotal());
        
        if (entity.getProveedor() != null) {
            dto.setProveedorId(entity.getProveedor().getId());
        }
        return dto;
    }

    public OrdenPagoEntity toEntity(OrdenPagoDto dto, ProveedorEntity proveedor) {
        if (dto == null) {
            return null;
        }
        OrdenPagoEntity entity = new OrdenPagoEntity();
        entity.setId(dto.getId());
        entity.setNroOperacion(dto.getNroOperacion());
        entity.setFecha(dto.getFecha());
        entity.setConcepto(dto.getConcepto());
        entity.setIdEstado(dto.getIdEstado());
        entity.setImporteTotal(dto.getImporteTotal());
        entity.setImportePagado(dto.getImportePagado());
        entity.setRutaArchivo(dto.getRutaArchivo());
        entity.setFechaAlta(dto.getFechaAlta());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setUltimaModificacion(dto.getUltimaModificacion());
        entity.setEstado(dto.getEstado());
        entity.setFormaPago(dto.getFormaPago());
        entity.setMontoTotal(dto.getMontoTotal());
        entity.setProveedor(proveedor);
        return entity;
    }
}
