package dobledsoftware.proveedores.features.proveedores.data;

import java.time.LocalDateTime;

public class ProveedorDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private LocalDateTime registrationDate;
    private String status;
    private String cuilCuit;
    private Long userId;
    private LocalDateTime modificationDate;

    // Constructors
    public ProveedorDto() {}

    public ProveedorDto(Long id, String name, String email, String address, String phone, LocalDateTime registrationDate, String status, String cuilCuit, Long userId, LocalDateTime modificationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.status = status;
        this.cuilCuit = cuilCuit;
        this.userId = userId;
        this.modificationDate = modificationDate;
    }

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
