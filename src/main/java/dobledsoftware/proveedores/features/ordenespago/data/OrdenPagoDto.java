package dobledsoftware.proveedores.features.ordenespago.data;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetTime;

@Schema(description = "Objeto de transferencia de datos para Orden de Pago")
public class OrdenPagoDto {

    @Schema(description = "Identificador único de la orden de pago", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(description = "Número de operación", example = "OP-2025-0001")
    private String nroOperacion;

    @Schema(description = "Hora de la operación", example = "15:00:00-03:00")
    private OffsetTime fecha;

    @Schema(description = "ID del proveedor asociado", example = "12")
    private Long proveedorId;

    @Schema(description = "Concepto del pago", example = "Pago de facturas")
    private String concepto;

    @Schema(description = "ID del estado", example = "2")
    private Integer idEstado;

    @Schema(description = "Importe total", example = "175000.00")
    private BigDecimal importeTotal;

    @Schema(description = "Importe pagado", example = "0.00")
    private BigDecimal importePagado;

    @Schema(description = "Ruta del archivo PDF", example = "/var/apps/pdf/proveedores/op_2025_0001_v2.pdf")
    private String rutaArchivo;

    @Schema(description = "Fecha de alta del registro", example = "2025-09-10T13:42:36")
    private LocalDateTime fechaAlta;

    @Schema(description = "ID del usuario que creó/modificó", example = "7")
    private Long idUsuario;

    @Schema(description = "Fecha de última modificación", example = "2025-09-10T13:48:46")
    private LocalDateTime ultimaModificacion;

    @Schema(description = "Estado descriptivo", example = "PENDIENTE")
    private String estado;

    @Schema(description = "Forma de pago", example = "TRANSFERENCIA")
    private String formaPago;

    @Schema(description = "Monto total (puede ser redundante con importeTotal)", example = "175000.00")
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
