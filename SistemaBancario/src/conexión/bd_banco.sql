CREATE DATABASE bd_banco;
USE bd_banco;

# CREACIÓN DE TABLAS
CREATE TABLE personas(
	id_persona CHAR(36) PRIMARY KEY,
	dni CHAR(8) NOT NULL UNIQUE,
	nombres VARCHAR(200) NOT NULL,
	apellidos VARCHAR(200) NOT NULL,
	telefono CHAR(9) NOT NULL UNIQUE,
	direccion varchar(300) NOT NULL,
	correo varchar(200) NOT NULL UNIQUE,
	contraseña varchar(300) NOT NULL
);
CREATE TABLE clientes(
	id_persona CHAR(36) PRIMARY KEY,
	FOREIGN KEY (id_persona) REFERENCES personas(id_persona)
);
CREATE TABLE empleados(
    id_persona CHAR(36) PRIMARY KEY,
	FOREIGN KEY (id_persona) REFERENCES personas(id_persona)
);
CREATE TABLE cuentas(
    numero_cuenta CHAR(10) PRIMARY KEY,
    saldo_contable DECIMAL(13,2) NOT NULL,
    saldo_disponible DECIMAL(13,2) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estado ENUM('activa', 'inactiva', 'cancelada') NOT NULL,
    tipo_cuenta ENUM('ahorro', 'corriente') NOT NULL,
    moneda ENUM('soles', 'dólares', 'euros', 'libras') NOT NULL,
    id_cliente CHAR(36) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_persona)
);
CREATE TABLE solicitudes(
    id_solicitud CHAR(36) PRIMARY KEY,
    asunto VARCHAR(150) NOT NULL,
    estado ENUM('rechazada', 'aceptada', 'pendiente') NOT NULL,
    fecha_creacion DATE NOT NULL,
    fecha_resolucion DATE,
    id_cliente CHAR(36) NOT NULL,
    id_empleado CHAR(36) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_persona),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_persona)
);
CREATE TABLE tarjetas(
    numero_tarjeta CHAR(16) PRIMARY KEY,
    estado ENUM('activa', 'inactiva', 'bloqueada') NOT NULL,
    tipo_tarjeta ENUM('débito', 'crédito') NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    id_cliente CHAR(36) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_persona)
);
CREATE TABLE transacciones(
    id_transaccion CHAR(36) PRIMARY KEY,
    tipo_transaccion ENUM('transferir', 'pagar', 'retirar', 'depositar') NOT NULL,
    descripcion varchar(500),
    fecha_hora DATETIME NOT NULL,
    estado ENUM('completada', 'pendiente', 'cancelada') NOT NULL,
    monto DECIMAL(13,2) NOT NULL,
    id_cliente CHAR(36) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_persona)
);

# CREACIÓN DE LOS PROCEDIMIENTOS ALMACENADOS
-- Para Clientes (el único terminado por ahora):
CREATE PROCEDURE sp_listarCliente(
) SELECT * FROM clientes;
DELIMITER //
CREATE PROCEDURE sp_insertarCliente(
	id_persona CHAR(36),
	dni CHAR(8),
	nombres VARCHAR(200),
	apellidos VARCHAR(200),
	telefono CHAR(9),
	direccion varchar(300),
	correo varchar(200),
	contraseña varchar(300)
)
BEGIN
	INSERT INTO personas VALUES (id_persona, dni, nombres, apellidos, telefono, direccion, correo, contraseña);
    INSERT INTO clientes VALUES (id_persona);
END //
DELIMITER ;
CREATE PROCEDURE sp_eliminarCliente(
	id_persona CHAR(36)
) DELETE FROM clientes WHERE id_persona = id_persona;
CREATE PROCEDURE sp_actualizarCliente(
	id_persona CHAR(36),
	dni CHAR(8),
	nombres VARCHAR(200),
	apellidos VARCHAR(200),
	telefono CHAR(9),
	direccion varchar(300),
	correo varchar(200),
	contraseña varchar(300)
) UPDATE personas p JOIN clientes c ON p.id_persona = c.id_persona
SET p.dni = dni, p.nombres = nombres, p.apellidos = apellidos, p.telefono = telefono, p.direccion = direccion, p.correo = correo, p.contraseña = contraseña 
WHERE p.id_persona = id_persona;
CREATE PROCEDURE sp_buscarIdCliente(
	id_persona CHAR(36)
) SELECT p.* FROM personas p JOIN clientes c ON p.id_persona = c.id_persona WHERE p.id_persona = id_persona;
CREATE PROCEDURE sp_buscarDniCliente(
	id_persona CHAR(36)
) SELECT p.* FROM personas p JOIN clientes c ON p.id_persona = c.id_persona WHERE p.dni = dni;
CREATE PROCEDURE sp_buscarCorreoCliente(
	correo varchar(200)
) SELECT p.* FROM personas p JOIN clientes c ON p.id_persona = c.id_persona WHERE p.correo = correo;
CREATE PROCEDURE sp_buscarCorreoContraseñaCliente(
	correo varchar(200),
	contraseña varchar(300)
) SELECT p.* FROM personas p JOIN clientes c ON p.id_persona = c.id_persona WHERE p.correo = correo AND p.contraseña = contraseña;

-- Para Empleados:
CREATE PROCEDURE sp_listarEmpleado(
) SELECT * FROM empleados;
DELIMITER //
CREATE PROCEDURE sp_insertarEmpleado(
	id_persona CHAR(36),
	dni CHAR(8),
	nombres VARCHAR(200),
	apellidos VARCHAR(200),
	telefono CHAR(9),
	direccion varchar(300),
	correo varchar(200),
	contraseña varchar(300)
)
BEGIN
	INSERT INTO personas VALUES (id_persona, dni, nombres, apellidos, telefono, direccion, correo, contraseña);
    INSERT INTO empleados VALUES (id_persona);
END //
DELIMITER ;
CREATE PROCEDURE sp_eliminarEmpleado(
	id_persona CHAR(36)
) DELETE FROM empleados WHERE id_persona = id_persona;
CREATE PROCEDURE sp_actualizarEmpleado(
	id_persona CHAR(36),
	dni CHAR(8),
	nombres VARCHAR(200),
	apellidos VARCHAR(200),
	telefono CHAR(9),
	direccion varchar(300),
	correo varchar(200),
	contraseña varchar(300)
) UPDATE personas p JOIN empleados e ON p.id_persona = e.id_persona
SET p.dni = dni, p.nombres = nombres, p.apellidos = apellidos, p.telefono = telefono, p.direccion = direccion, p.correo = correo, p.contraseña = contraseña 
WHERE p.id_persona = id_persona;
CREATE PROCEDURE sp_buscarIdEmpleado(
	id_persona CHAR(36)
) SELECT p.* FROM personas p JOIN empleados e ON p.id_persona = e.id_persona WHERE p.id_persona = id_persona;
CREATE PROCEDURE sp_buscarDniEmpleado(
	id_persona CHAR(36)
) SELECT p.* FROM personas p JOIN empleados e ON p.id_persona = e.id_persona WHERE p.dni = dni;
CREATE PROCEDURE sp_buscarCorreoEmpleado(
	correo varchar(200)
) SELECT p.* FROM personas p JOIN empleados e ON p.id_persona = e.id_persona WHERE p.correo = correo;
CREATE PROCEDURE sp_buscarCorreoContraseñaEmpleado(
	correo varchar(200),
	contraseña varchar(300)
) SELECT p.* FROM personas p JOIN empleados e ON p.id_persona = e.id_persona WHERE p.correo = correo AND p.contraseña = contraseña;

-- Para Cuentas:
CREATE PROCEDURE sp_listarCuenta(
) SELECT * FROM cuentas;
CREATE PROCEDURE sp_insertarCuenta(
	numero_cuenta CHAR(10),
    saldo_contable DECIMAL(13,2),
    saldo_disponible DECIMAL(13,2),
    fecha_creacion DATE,
    estado ENUM('activa', 'inactiva', 'cancelada'),
    tipo_cuenta ENUM('ahorro', 'corriente'),
    moneda ENUM('soles', 'dólares', 'euros', 'libras'),
    id_cliente CHAR(36)
) INSERT INTO cuentas VALUES (numero_cuenta, saldo_contable, saldo_disponible, fecha_creacion, estado, tipo_cuenta, moneda, id_cliente);
CREATE PROCEDURE sp_eliminarCuenta(
	numero_cuenta CHAR(10)
) DELETE FROM cuentas WHERE numero_cuenta = numero_cuenta;
CREATE PROCEDURE sp_actualizarCuenta(
	numero_cuenta CHAR(10),
    saldo_contable DECIMAL(13,2),
    saldo_disponible DECIMAL(13,2),
    estado ENUM('activa', 'inactiva', 'cancelada')
) UPDATE cuentas SET saldo_contable = saldo_contable, saldo_disponible = saldo_disponible, estado = estado WHERE numero_cuenta = numero_cuenta;
CREATE PROCEDURE sp_buscarNumeroCuenta(
	numero_cuenta CHAR(10)
) SELECT * FROM cuentas WHERE numero_cuenta = numero_cuenta;

-- Para Solicitud:
CREATE PROCEDURE sp_listarSolicitud(
) SELECT * FROM solicitudes;
CREATE PROCEDURE sp_insertarSolicitud(
	id_solicitud CHAR(36),
    asunto VARCHAR(150),
    estado ENUM('rechazada', 'aceptada', 'pendiente'),
    fecha_creacion DATE,
    fecha_resolucion DATE,
    id_cliente CHAR(36),
    id_empleado CHAR(36)
) INSERT INTO solicitudes VALUES (id_solicitud, asunto, estado, fecha_creacion, fecha_resolucion, id_cliente, id_empleado);
CREATE PROCEDURE sp_eliminarSolicitud(
	id_solicitud CHAR(36)
) DELETE FROM solicitudes WHERE id_solicitud = id_solicitud;
CREATE PROCEDURE sp_actualizarSolicitud(
	id_solicitud CHAR(36),
    estado ENUM('rechazada', 'aceptada', 'pendiente'),
    fecha_resolucion DATE
) UPDATE solicitudes SET estado = estado, fecha_resolucion = fecha_resolucion WHERE id_solicitud = id_solicitud;
CREATE PROCEDURE sp_buscarIdSolicitud(
	id_solicitud CHAR(36)
) SELECT * FROM solicitudes WHERE id_solicitud = id_solicitud;

-- Para Tarjetas:
CREATE PROCEDURE sp_listarTarjeta(
) SELECT * FROM tarjetas;
CREATE PROCEDURE sp_insertarTarjeta(
	numero_tarjeta CHAR(16),
    estado ENUM('activa', 'inactiva', 'bloqueada'),
    tipo_tarjeta ENUM('débito', 'crédito'),
    fecha_vencimiento DATE,
    id_cliente CHAR(36)
) INSERT INTO tarjetas VALUES (numero_tarjeta, estado, tipo_tarjeta, fecha_vencimiento, id_cliente);
CREATE PROCEDURE sp_eliminarTarjeta(
	id_solicitud CHAR(36)
) DELETE FROM tarjetas WHERE id_solicitud = id_solicitud;
CREATE PROCEDURE sp_actualizarTarjeta(
	numero_tarjeta CHAR(16),
    estado ENUM('activa', 'inactiva', 'bloqueada')
) UPDATE tarjetas SET estado = estado WHERE numero_tarjeta = numero_tarjeta;
CREATE PROCEDURE sp_buscarIdTarjeta(
	numero_tarjeta CHAR(16)
) SELECT * FROM tarjetas WHERE id_solicitud = id_solicitud;

-- Para Transacciones:
CREATE PROCEDURE sp_listarTransaccion(
) SELECT * FROM transacciones;
CREATE PROCEDURE sp_insertarTransaccion(
	id_transaccion CHAR(36),
    tipo_transaccion ENUM('transferir', 'pagar', 'retirar', 'depositar'),
    descripcion varchar(500),
    fecha_hora DATETIME,
    estado ENUM('completada', 'pendiente', 'cancelada'),
    monto DECIMAL(13,2),
    id_cliente CHAR(36)
) INSERT INTO transacciones VALUES (id_transaccion, tipo_transaccion, descripcion, fecha_hora, estado, monto, id_cliente);
CREATE PROCEDURE sp_eliminarTransaccion(
	id_transaccion CHAR(36)
) DELETE FROM transacciones WHERE id_transaccion = id_transaccion;
CREATE PROCEDURE sp_actualizarTransaccion(
	id_transaccion CHAR(36),
    estado ENUM('completada', 'pendiente', 'cancelada')
) UPDATE transacciones SET estado = estado WHERE id_transaccion = id_transaccion;
CREATE PROCEDURE sp_buscarIdTransaccion(
	id_transaccion CHAR(36)
) SELECT * FROM transacciones WHERE id_transaccion = id_transaccion;

#INSERCIÓN DE DATOS
CALL sp_insertarEmpleado('1', '00000001', 'Juan', 'Pérez García', '987654321', 'Calle Falsa 123, Distrito Imaginario, Ciudad Ejemplo', 'juan.perez@empleado.com', 'ClaveEjemplo#1');
CALL sp_insertarEmpleado('2', '00000002', 'María', 'López Rodríguez', '912345678', 'Avenida Siempre Viva 742, Sector Demo, Ciudad Ejemplo', 'maria.lopez@empleado.com', 'ClaveEjemplo#2');
CALL sp_insertarCliente('3', '00000003', 'Carlos', 'Solicitud', '955501003', 'Jirón Desconocido 456, Urb. Modelo, Ciudad Ejemplo', 'carlos.martinez@email.com', 'ClaveEjemplo#1');
CALL sp_insertarCliente('4', '00000004', 'Ana', 'Gonzales Castillo', '933112233', 'Pasaje Inventado 789, Zona Test, Ciudad Ejemplo', 'ana.gonzales@email.com', 'ClaveEjemplo#2');

CALL sp_insertarSolicitud('1', 'Apertura de cuenta de ahorro en soles', 'aceptada', current_date(), current_date(), '3', '1');
CALL sp_insertarSolicitud('2', 'Apertura de cuenta corriente en dólares', 'aceptada', current_date(), current_date(), '3', '1');
CALL sp_insertarSolicitud('3', 'Apertura de cuenta de ahorro en soles', 'aceptada', current_date(), current_date(), '4', '2');
CALL sp_insertarSolicitud('4', 'Apertura de cuenta corriente en dólares', 'aceptada', current_date(), current_date(), '4', '2');
CALL sp_insertarSolicitud('5', 'Emisión de tarjeta de crédito', 'aceptada', current_date(), current_date(), '3', '1');
CALL sp_insertarSolicitud('6', 'Emisión de tarjeta de débito', 'aceptada', current_date(), current_date(), '3', '1');
CALL sp_insertarSolicitud('7', 'Emisión de tarjeta de crédito', 'aceptada', current_date(), current_date(), '4', '2');
CALL sp_insertarSolicitud('8', 'Emisión de tarjeta de débito', 'aceptada', current_date(), current_date(), '4', '2');

CALL sp_insertarCuenta('1', '1500', '1500', current_date(), 'activa', 'ahorro', 'soles', '3');
CALL sp_insertarCuenta('2', '800', '800', current_date(), 'activa', 'corriente', 'dólares', '3');
CALL sp_insertarCuenta('3', '1200', '1200', current_date(), 'activa', 'ahorro', 'soles', '4');
CALL sp_insertarCuenta('4', '900', '900', current_date(), 'activa', 'corriente', 'dólares', '4');

CALL sp_insertarTarjeta('1', 'activa', 'crédito', (DATE_ADD(CURDATE(), INTERVAL 3 YEAR)), '3');
CALL sp_insertarTarjeta('2', 'activa', 'débito', (DATE_ADD(CURDATE(), INTERVAL 3 YEAR)), '3');
CALL sp_insertarTarjeta('3', 'activa', 'crédito', (DATE_ADD(CURDATE(), INTERVAL 3 YEAR)), '4');
CALL sp_insertarTarjeta('4', 'activa', 'débito', (DATE_ADD(CURDATE(), INTERVAL 3 YEAR)), '4');

CALL sp_insertarTransaccion('1', 'depositar', 'Número de cuenta de destino: 1;', now(), 'completada', 1500, '3');
CALL sp_insertarTransaccion('2', 'depositar', 'Número de cuenta de destino: 2;', now(), 'completada', 800, '3');
CALL sp_insertarTransaccion('3', 'depositar', 'Número de cuenta de destino: 3;', now(), 'completada', 1200, '4');
CALL sp_insertarTransaccion('4', 'depositar', 'Número de cuenta de destino: 4;', now(), 'completada', 900, '4');

SELECT * FROM solicitudes s 

JOIN empleados e ON s.id_empleado = e.id_persona 
JOIN personas p1 ON e.id_persona = p1.id_persona 

JOIN clientes c ON s.id_cliente = c.id_persona
JOIN personas p2 ON c.id_persona = p2.id_persona

 WHERE s.id_solicitud = 5;

/*
SELECT * FROM personas;
CALL sp_listarEmpleado();
CALL sp_listarCliente();
CALL sp_listarCuenta();
CALL sp_listarTarjeta();
CALL sp_listarSolicitud();
CALL sp_listarTransaccion();
*/