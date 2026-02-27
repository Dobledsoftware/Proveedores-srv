package dobledsoftware.proveedores.features.ordenespago.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import dobledsoftware.proveedores.constants.AppConstants;

@Entity
@Table(name = AppConstants.TABLE_ORDENES_PAGO)
public class OrdenPagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_pago")
    private Integer id;

    @Column(name = "nro_operacion")
    private String nroOperacion;

    @Column(name = "fecha")
    private OffsetTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "importe_total", precision = 19, scale = 2)
    private BigDecimal importeTotal;

    @Column(name = "importe_pagado", precision = 19, scale = 2)
    private BigDecimal importePagado;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "ultima_modificacion")
    private LocalDateTime ultimaModificacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "monto_total", precision = 19, scale = 2)
    private BigDecimal montoTotal;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public OffsetTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetTime fecha) {
        this.fecha = fecha;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
}
