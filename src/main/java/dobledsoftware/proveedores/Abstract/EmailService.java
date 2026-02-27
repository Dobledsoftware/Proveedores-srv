package dobledsoftware.proveedores.Abstract;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
