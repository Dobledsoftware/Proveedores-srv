-- Insertar proveedores faltantes del 5 al 12
INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 5, 'Proveedor Test 5', 'test5@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-5', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 5);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 6, 'Proveedor Test 6', 'test6@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-6', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 6);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 7, 'Proveedor Test 7', 'test7@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-7', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 7);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 8, 'Proveedor Test 8', 'test8@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-8', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 8);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 9, 'Proveedor Test 9', 'test9@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-9', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 9);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 10, 'Proveedor Test 10', 'test10@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-0', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 10);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 11, 'Proveedor Test 11', 'test11@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-1', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 11);

INSERT INTO proveedores (id_proveedor, descripcion, email, direccion, telefono, fecha_alta, estado, cuil_cuit, id_usuario, fecha_modificacion)
SELECT 12, 'Proveedor Test 12', 'test12@example.com', 'Calle Falsa 123', '555-1234', NOW(), 'ACTIVO', '20-12345678-2', 1, NOW()
WHERE NOT EXISTS (SELECT 1 FROM proveedores WHERE id_proveedor = 12);
