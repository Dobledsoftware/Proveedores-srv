package dobledsoftware.proveedores.Abstract.impl;

import dobledsoftware.proveedores.Abstract.AuditService;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {
    @Override
    public void audit(String action, String details) {
        System.out.println("AUDIT: [" + action + "] " + details);
    }
}
