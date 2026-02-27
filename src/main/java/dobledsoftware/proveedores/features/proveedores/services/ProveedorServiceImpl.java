package dobledsoftware.proveedores.features.proveedores.services;

import dobledsoftware.proveedores.Abstract.AuditService;
import dobledsoftware.proveedores.Abstract.EmailService;
import dobledsoftware.proveedores.features.proveedores.dao.ProveedorRepository;
import dobledsoftware.proveedores.features.proveedores.data.ProveedorDto;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import dobledsoftware.proveedores.features.proveedores.mappers.ProveedorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ResourceBundle;
import java.text.MessageFormat;

@Service
public class ProveedorServiceImpl {

    private final ProveedorRepository providerRepository;
    private final ProveedorMapper providerMapper;
    private final AuditService auditService;
    private final EmailService emailService;
    private final ResourceBundle messages;

    public ProveedorServiceImpl(ProveedorRepository providerRepository,
                                ProveedorMapper providerMapper,
                                AuditService auditService,
                                EmailService emailService) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
        this.auditService = auditService;
        this.emailService = emailService;
        this.messages = ResourceBundle.getBundle("messages_en");
    }

    @Transactional
    public ProveedorDto createProvider(ProveedorDto providerDto) {
        if (providerRepository.existsByEmail(providerDto.getEmail())) {
            throw new IllegalArgumentException(messages.getString("error.email.already.exists"));
        }

        if (providerDto.getRegistrationDate() == null) {
            providerDto.setRegistrationDate(LocalDateTime.now());
        }
        if (providerDto.getStatus() == null) {
            providerDto.setStatus(messages.getString("provider.status.active"));
        }

        ProveedorEntity entity = providerMapper.toEntity(providerDto);
        ProveedorEntity savedEntity = providerRepository.save(entity);

        auditService.audit(messages.getString("audit.create.provider"), 
                           MessageFormat.format(messages.getString("audit.message.provider.created"), savedEntity.getName()));
        emailService.sendEmail(savedEntity.getEmail(), 
                               messages.getString("email.subject.welcome"), 
                               messages.getString("email.body.welcome"));

        return providerMapper.mapToDto(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<ProveedorDto> listProviders() {
        return providerRepository.findAll().stream()
                .map(providerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProveedorDto> searchByName(String name) {
        return providerRepository.findByNameContainingIgnoreCase(name).stream()
                .map(providerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
