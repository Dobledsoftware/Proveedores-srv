package dobledsoftware.proveedores.constants;

public final class AppConstants {

    private AppConstants() {
        // Prevent instantiation
    }

    // Table Names
    public static final String TABLE_PROVEEDORES = "PROVEEDORES";
    public static final String TABLE_ORDENES_COMPRA = "ORDENES_COMPRA";
    public static final String TABLE_ORDENES_PAGO = "ORDENES_PAGO";

    // Status
    public static final String STATUS_PENDIENTE = "PENDIENTE";
    public static final String STATUS_APROBADA = "APROBADA";
    public static final String STATUS_RECHAZADA = "RECHAZADA";
    public static final String STATUS_PAGADA = "PAGADA";

    // Messages Keys - Success
    public static final String MSG_ORDEN_COMPRA_CREATED = "orden.compra.create.success";
    public static final String MSG_ORDEN_PAGO_CREATED = "orden.pago.create.success";

    // Messages Keys - Errors
    public static final String MSG_ERROR_ORDEN_EXISTS = "error.orden.exists";
    public static final String MSG_ERROR_PROVEEDOR_NOT_FOUND = "error.proveedor.not.found";
    public static final String MSG_ERROR_ORDEN_NOT_FOUND = "error.orden.not.found";

    // Messages Keys - Logs
    public static final String LOG_FETCH_ALL = "log.fetch.all";
    public static final String LOG_FETCH_BY_ID = "log.fetch.by.id";
    public static final String LOG_CREATE_START = "log.create.start";
    public static final String LOG_CREATE_SUCCESS = "log.create.success";
    public static final String LOG_UPDATE_START = "log.update.start";
    public static final String LOG_UPDATE_SUCCESS = "log.update.success";
    public static final String LOG_DELETE_START = "log.delete.start";
    public static final String LOG_DELETE_SUCCESS = "log.delete.success";
}
