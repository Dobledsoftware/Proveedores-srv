package dobledsoftware.proveedores.features.proveedores.services;

import dobledsoftware.proveedores.Abstract.AuditService;
import dobledsoftware.proveedores.Abstract.EmailService;
import dobledsoftware.proveedores.features.proveedores.dao.ProveedorRepository;
import dobledsoftware.proveedores.features.proveedores.data.ProveedorDto;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import dobledsoftware.proveedores.features.proveedores.mappers.ProveedorMapper;
// import org.springframework.stereotype.Service;

// @Service
public class ProveedorService {

    private final ProveedorRepository providerRepository;
    private final ProveedorMapper providerMapper;
    private final AuditService auditService;
    private final EmailService emailService;

    public ProveedorService(ProveedorRepository providerRepository,
                            ProveedorMapper providerMapper,
                            AuditService auditService,
                            EmailService emailService) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
        this.auditService = auditService;
        this.emailService = emailService;
    }

    public ProveedorDto createProvider(ProveedorDto providerDto) {
        ProveedorEntity entity = providerMapper.toEntity(providerDto);
        ProveedorEntity savedEntity = providerRepository.save(entity);

        auditService.audit("CREATE_PROVIDER", "Provider created: " + savedEntity.getName());
        emailService.sendEmail(savedEntity.getEmail(), "Welcome", "Thank you for registering as a provider.");

        return providerMapper.mapToDto(savedEntity);
    }
}
