package dobledsoftware.proveedores.features.proveedores.utils;

import dobledsoftware.proveedores.constants.ProveedorConstants;

public class ProveedorUtils {

    public static String buildAuditMessage(String nombreProveedor) {
        return ProveedorConstants.AUDIT_MSG_CREAR_PROVEEDOR + nombreProveedor;
    }

    private ProveedorUtils() {
        // Private constructor to prevent instantiation
    }
}
