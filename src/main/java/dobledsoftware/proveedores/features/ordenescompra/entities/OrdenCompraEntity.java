package dobledsoftware.proveedores.features.ordenescompra.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import dobledsoftware.proveedores.constants.AppConstants;

@Entity
@Table(name = AppConstants.TABLE_ORDENES_COMPRA)
public class OrdenCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Integer id;

    @Column(name = "nro_orden_compra")
    private String nroOrdenCompra;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

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

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total", precision = 19, scale = 2)
    private BigDecimal total;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroOrdenCompra() {
        return nroOrdenCompra;
    }

    public void setNroOrdenCompra(String nroOrdenCompra) {
        this.nroOrdenCompra = nroOrdenCompra;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
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

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
