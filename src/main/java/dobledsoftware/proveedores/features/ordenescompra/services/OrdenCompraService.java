package dobledsoftware.proveedores.features.ordenescompra.services;

import dobledsoftware.proveedores.constants.AppConstants;
import dobledsoftware.proveedores.features.ordenescompra.dao.OrdenCompraRepository;
import dobledsoftware.proveedores.features.ordenescompra.data.OrdenCompraDto;
import dobledsoftware.proveedores.features.ordenescompra.entities.OrdenCompraEntity;
import dobledsoftware.proveedores.features.ordenescompra.mappers.OrdenCompraMapper;
import dobledsoftware.proveedores.features.proveedores.dao.ProveedorRepository;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProveedorRepository proveedorRepository;
    private final OrdenCompraMapper ordenCompraMapper;
    private final MessageSource messageSource;

    @Autowired
    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository,
                              ProveedorRepository proveedorRepository,
                              OrdenCompraMapper ordenCompraMapper,
                              MessageSource messageSource) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.proveedorRepository = proveedorRepository;
        this.ordenCompraMapper = ordenCompraMapper;
        this.messageSource = messageSource;
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    @Transactional(readOnly = true)
    public List<OrdenCompraDto> getAll() {
        log.info(getMessage("log.fetch.all"));
        return ordenCompraRepository.findAll().stream()
                .map(ordenCompraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<OrdenCompraDto> getById(Integer id) {
        log.info(getMessage("log.fetch.by.id", id));
        return ordenCompraRepository.findById(id)
                .map(ordenCompraMapper::toDto);
    }

    @Transactional
    public OrdenCompraDto create(OrdenCompraDto dto) {
        log.info(getMessage("log.create.start", dto.getNroOrdenCompra()));
        
        if (ordenCompraRepository.existsByNroOrdenCompra(dto.getNroOrdenCompra())) {
            String errorMsg = getMessage("error.orden.exists", dto.getNroOrdenCompra());
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        
        ProveedorEntity proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.proveedor.not.found", dto.getProveedorId());
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });

        OrdenCompraEntity entity = ordenCompraMapper.toEntity(dto, proveedor);
        
        // Set default values if null
        if (entity.getFechaAlta() == null) {
            entity.setFechaAlta(LocalDateTime.now());
        }
        if (entity.getEstado() == null) {
            entity.setEstado(AppConstants.STATUS_PENDIENTE);
        }
        
        OrdenCompraEntity saved = ordenCompraRepository.save(entity);
        log.info(getMessage("log.create.success", saved.getId()));
        
        return ordenCompraMapper.toDto(saved);
    }

    @Transactional
    public OrdenCompraDto update(Integer id, OrdenCompraDto dto) {
        log.info(getMessage("log.update.start", id));
        
        OrdenCompraEntity existing = ordenCompraRepository.findById(id)
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.orden.not.found", id);
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });
        
        existing.setNroOrdenCompra(dto.getNroOrdenCompra());
        existing.setFechaAlta(dto.getFechaAlta());
        existing.setConcepto(dto.getConcepto());
        existing.setIdEstado(dto.getIdEstado());
        existing.setImporteTotal(dto.getImporteTotal());
        existing.setImportePagado(dto.getImportePagado());
        existing.setRutaArchivo(dto.getRutaArchivo());
        existing.setFechaModificacion(LocalDateTime.now()); // Update modification date
        existing.setIdUsuario(dto.getIdUsuario());
        existing.setFecha(dto.getFecha());
        existing.setEstado(dto.getEstado());
        existing.setTotal(dto.getTotal());
        
        if (dto.getProveedorId() != null && !dto.getProveedorId().equals(existing.getProveedor().getId())) {
             ProveedorEntity proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.proveedor.not.found", dto.getProveedorId());
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });
             existing.setProveedor(proveedor);
        }

        OrdenCompraEntity updated = ordenCompraRepository.save(existing);
        log.info(getMessage("log.update.success", updated.getId()));
        
        return ordenCompraMapper.toDto(updated);
    }

    @Transactional
    public void delete(Integer id) {
        log.info(getMessage("log.delete.start", id));
        
        if (!ordenCompraRepository.existsById(id)) {
            String errorMsg = getMessage("error.orden.not.found", id);
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        
        ordenCompraRepository.deleteById(id);
        log.info(getMessage("log.delete.success", id));
    }
}
