package dobledsoftware.proveedores.features.ordenescompra.data;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "Objeto de transferencia de datos para Orden de Compra")
public class OrdenCompraDto {

    @Schema(description = "Identificador único de la orden de compra", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(description = "Número de orden de compra", example = "OC-2025-0001")
    private String nroOrdenCompra;

    @Schema(description = "Fecha de alta del registro", example = "2025-09-10T13:42:36")
    private LocalDateTime fechaAlta;

    @Schema(description = "ID del proveedor asociado", example = "12")
    private Long proveedorId;

    @Schema(description = "Concepto de la orden", example = "Compra de insumos")
    private String concepto;

    @Schema(description = "ID del estado", example = "2")
    private Integer idEstado;

    @Schema(description = "Importe total", example = "175000.00")
    private BigDecimal importeTotal;

    @Schema(description = "Importe pagado", example = "0.00")
    private BigDecimal importePagado;

    @Schema(description = "Ruta del archivo PDF", example = "/var/apps/pdf/proveedores/oc_2025_0001_v2.pdf")
    private String rutaArchivo;

    @Schema(description = "Fecha de última modificación", example = "2025-09-10T17:08:21")
    private LocalDateTime fechaModificacion;

    @Schema(description = "ID del usuario que creó/modificó", example = "7")
    private Long idUsuario;

    @Schema(description = "Fecha de la orden", example = "2025-09-12")
    private LocalDate fecha;

    @Schema(description = "Estado descriptivo", example = "PENDIENTE")
    private String estado;

    @Schema(description = "Total (puede ser redundante con importeTotal)", example = "175000.00")
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

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
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
