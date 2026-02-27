package dobledsoftware.proveedores.features.proveedores.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PROVEEDORES")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "fecha_alta")
    private LocalDateTime registrationDate;

    @Column(name = "estado")
    private String status;

    @Column(name = "cuil_cuit")
    private String cuilCuit;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "fecha_modificacion")
    private LocalDateTime modificationDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCuilCuit() {
        return cuilCuit;
    }

    public void setCuilCuit(String cuilCuit) {
        this.cuilCuit = cuilCuit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}
