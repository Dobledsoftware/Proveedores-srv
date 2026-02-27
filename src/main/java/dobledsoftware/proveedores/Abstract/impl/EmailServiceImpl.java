package dobledsoftware.proveedores.Abstract.impl;

import dobledsoftware.proveedores.Abstract.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("EMAIL to " + to + ": " + subject + " - " + body);
    }
}
