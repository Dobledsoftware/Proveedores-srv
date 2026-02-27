package dobledsoftware.proveedores.features.ordenespago.services;

import dobledsoftware.proveedores.constants.AppConstants;
import dobledsoftware.proveedores.features.ordenespago.dao.OrdenPagoRepository;
import dobledsoftware.proveedores.features.ordenespago.data.OrdenPagoDto;
import dobledsoftware.proveedores.features.ordenespago.entities.OrdenPagoEntity;
import dobledsoftware.proveedores.features.ordenespago.mappers.OrdenPagoMapper;
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
public class OrdenPagoService {

    private final OrdenPagoRepository ordenPagoRepository;
    private final ProveedorRepository proveedorRepository;
    private final OrdenPagoMapper ordenPagoMapper;
    private final MessageSource messageSource;

    @Autowired
    public OrdenPagoService(OrdenPagoRepository ordenPagoRepository,
                            ProveedorRepository proveedorRepository,
                            OrdenPagoMapper ordenPagoMapper,
                            MessageSource messageSource) {
        this.ordenPagoRepository = ordenPagoRepository;
        this.proveedorRepository = proveedorRepository;
        this.ordenPagoMapper = ordenPagoMapper;
        this.messageSource = messageSource;
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    @Transactional(readOnly = true)
    public List<OrdenPagoDto> getAll() {
        log.info(getMessage("log.fetch.all"));
        return ordenPagoRepository.findAll().stream()
                .map(ordenPagoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<OrdenPagoDto> getById(Integer id) {
        log.info(getMessage("log.fetch.by.id", id));
        return ordenPagoRepository.findById(id)
                .map(ordenPagoMapper::toDto);
    }

    @Transactional
    public OrdenPagoDto create(OrdenPagoDto dto) {
        log.info(getMessage("log.create.start", dto.getNroOperacion()));
        
        if (ordenPagoRepository.existsByNroOperacion(dto.getNroOperacion())) {
            String errorMsg = getMessage("error.orden.exists", dto.getNroOperacion());
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        
        ProveedorEntity proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.proveedor.not.found", dto.getProveedorId());
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });

        OrdenPagoEntity entity = ordenPagoMapper.toEntity(dto, proveedor);
        
        // Set default values if null
        if (entity.getFechaAlta() == null) {
            entity.setFechaAlta(LocalDateTime.now());
        }
        if (entity.getEstado() == null) {
            entity.setEstado(AppConstants.STATUS_PENDIENTE);
        }
        
        OrdenPagoEntity saved = ordenPagoRepository.save(entity);
        log.info(getMessage("log.create.success", saved.getId()));
        
        return ordenPagoMapper.toDto(saved);
    }

    @Transactional
    public OrdenPagoDto update(Integer id, OrdenPagoDto dto) {
        log.info(getMessage("log.update.start", id));
        
        OrdenPagoEntity existing = ordenPagoRepository.findById(id)
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.orden.not.found", id);
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });
        
        existing.setNroOperacion(dto.getNroOperacion());
        existing.setFecha(dto.getFecha());
        existing.setConcepto(dto.getConcepto());
        existing.setIdEstado(dto.getIdEstado());
        existing.setImporteTotal(dto.getImporteTotal());
        existing.setImportePagado(dto.getImportePagado());
        existing.setRutaArchivo(dto.getRutaArchivo());
        existing.setUltimaModificacion(LocalDateTime.now()); // Update modification date
        existing.setIdUsuario(dto.getIdUsuario());
        existing.setEstado(dto.getEstado());
        existing.setFormaPago(dto.getFormaPago());
        existing.setMontoTotal(dto.getMontoTotal());
        
        if (dto.getProveedorId() != null && !dto.getProveedorId().equals(existing.getProveedor().getId())) {
             ProveedorEntity proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> {
                    String errorMsg = getMessage("error.proveedor.not.found", dto.getProveedorId());
                    log.error(errorMsg);
                    return new IllegalArgumentException(errorMsg);
                });
             existing.setProveedor(proveedor);
        }

        OrdenPagoEntity updated = ordenPagoRepository.save(existing);
        log.info(getMessage("log.update.success", updated.getId()));
        
        return ordenPagoMapper.toDto(updated);
    }

    @Transactional
    public void delete(Integer id) {
        log.info(getMessage("log.delete.start", id));
        
        if (!ordenPagoRepository.existsById(id)) {
            String errorMsg = getMessage("error.orden.not.found", id);
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        
        ordenPagoRepository.deleteById(id);
        log.info(getMessage("log.delete.success", id));
    }
}
