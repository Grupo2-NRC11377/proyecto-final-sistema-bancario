package repositorio;

import java.sql.*;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;
import modelo.Cuenta;

public class RepositorioCuenta {

    public static ArrayList<Cuenta> getCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement cstmt = cnx.prepareCall("{CALL sp_listarCuenta()}")) {

            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getString(8));

                Cuenta cuenta = new Cuenta(
                    rs.getString(6), // tipoCuenta
                    rs.getString(7), // moneda
                    cliente
                );

                cuenta.setSaldoContable(rs.getDouble(2));
                cuenta.setSaldoDisponible(rs.getDouble(3));
                cuenta.setEstado(rs.getString(5));

                cuenta.getClass().getDeclaredField("numeroCuenta").setAccessible(true);
                cuenta.getClass().getDeclaredField("numeroCuenta").set(cuenta, rs.getString(1));

                cuenta.getClass().getDeclaredField("fechaCreacion").setAccessible(true);
                cuenta.getClass().getDeclaredField("fechaCreacion").set(cuenta, rs.getDate(4).toLocalDate());

                cuentas.add(cuenta);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener cuentas: " + e);
        }
        return cuentas;
    }

    public static boolean agregarCuenta(Cuenta cuenta) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement cstmt = cnx.prepareCall("{CALL sp_insertarCuenta(?, ?, ?, ?, ?, ?, ?, ?)}")) {

            cstmt.setString(1, cuenta.getNumeroCuenta());
            cstmt.setDouble(2, cuenta.getSaldoContable());
            cstmt.setDouble(3, cuenta.getSaldoDisponible());
            cstmt.setDate(4, Date.valueOf(cuenta.getFechaCreacion()));
            cstmt.setString(5, cuenta.getEstado());
            cstmt.setString(6, cuenta.getTipoCuenta());
            cstmt.setString(7, cuenta.getMoneda());
            cstmt.setString(8, cuenta.getCliente().getIdPersona());

            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar cuenta: " + e);
            return false;
        }
    }

    public static Cuenta buscarCuenta(String numeroCuenta) {
        Cuenta cuenta = null;
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement cstmt = cnx.prepareCall("{CALL sp_buscarNumeroCuenta(?)}")) {

            cstmt.setString(1, numeroCuenta);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getString(8));

                cuenta = new Cuenta(
                    rs.getString(6),
                    rs.getString(7),
                    cliente
                );

                cuenta.setSaldoContable(rs.getDouble(2));
                cuenta.setSaldoDisponible(rs.getDouble(3));
                cuenta.setEstado(rs.getString(5));

                cuenta.getClass().getDeclaredField("numeroCuenta").setAccessible(true);
                cuenta.getClass().getDeclaredField("numeroCuenta").set(cuenta, rs.getString(1));

                cuenta.getClass().getDeclaredField("fechaCreacion").setAccessible(true);
                cuenta.getClass().getDeclaredField("fechaCreacion").set(cuenta, rs.getDate(4).toLocalDate());
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cuenta: " + e);
        }
        return cuenta;
    }

    public static boolean eliminarCuenta(String numeroCuenta) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement cstmt = cnx.prepareCall("{CALL sp_eliminarCuenta(?)}")) {
            cstmt.setString(1, numeroCuenta);
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar cuenta: " + e);
            return false;
        }
    }

    public static boolean actualizarCuenta(String numeroCuenta, double saldoContable, double saldoDisponible, String estado) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement cstmt = cnx.prepareCall("{CALL sp_actualizarCuenta(?, ?, ?, ?)}")) {

            cstmt.setString(1, numeroCuenta);
            cstmt.setDouble(2, saldoContable);
            cstmt.setDouble(3, saldoDisponible);
            cstmt.setString(4, estado);
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar cuenta: " + e);
            return false;
        }
    }
}
