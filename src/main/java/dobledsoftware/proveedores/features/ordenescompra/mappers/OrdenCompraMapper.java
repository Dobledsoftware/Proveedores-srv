package dobledsoftware.proveedores.features.ordenescompra.mappers;

import dobledsoftware.proveedores.features.ordenescompra.data.OrdenCompraDto;
import dobledsoftware.proveedores.features.ordenescompra.entities.OrdenCompraEntity;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import org.springframework.stereotype.Component;

@Component
public class OrdenCompraMapper {

    public OrdenCompraDto toDto(OrdenCompraEntity entity) {
        if (entity == null) {
            return null;
        }
        OrdenCompraDto dto = new OrdenCompraDto();
        dto.setId(entity.getId());
        dto.setNroOrdenCompra(entity.getNroOrdenCompra());
        dto.setFechaAlta(entity.getFechaAlta());
        dto.setConcepto(entity.getConcepto());
        dto.setIdEstado(entity.getIdEstado());
        dto.setImporteTotal(entity.getImporteTotal());
        dto.setImportePagado(entity.getImportePagado());
        dto.setRutaArchivo(entity.getRutaArchivo());
        dto.setFechaModificacion(entity.getFechaModificacion());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setFecha(entity.getFecha());
        dto.setEstado(entity.getEstado());
        dto.setTotal(entity.getTotal());
        
        if (entity.getProveedor() != null) {
            dto.setProveedorId(entity.getProveedor().getId());
        }
        return dto;
    }

    public OrdenCompraEntity toEntity(OrdenCompraDto dto, ProveedorEntity proveedor) {
        if (dto == null) {
            return null;
        }
        OrdenCompraEntity entity = new OrdenCompraEntity();
        entity.setId(dto.getId());
        entity.setNroOrdenCompra(dto.getNroOrdenCompra());
        entity.setFechaAlta(dto.getFechaAlta());
        entity.setConcepto(dto.getConcepto());
        entity.setIdEstado(dto.getIdEstado());
        entity.setImporteTotal(dto.getImporteTotal());
        entity.setImportePagado(dto.getImportePagado());
        entity.setRutaArchivo(dto.getRutaArchivo());
        entity.setFechaModificacion(dto.getFechaModificacion());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setFecha(dto.getFecha());
        entity.setEstado(dto.getEstado());
        entity.setTotal(dto.getTotal());
        entity.setProveedor(proveedor);
        return entity;
    }
}
