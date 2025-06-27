package repositorio;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;
import modelo.Tarjeta;

public class RepositorioTarjeta {

    public static ArrayList<Tarjeta> getTarjetas() {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_listarTarjeta()}")) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getString(5)); // id_cliente

                Tarjeta tarjeta = new Tarjeta(
                    rs.getString(3), // tipo_tarjeta
                    cliente
                );

                tarjeta.setEstado(rs.getString(2));
                tarjeta.setFechaVencimiento(rs.getDate(4).toLocalDate().atStartOfDay());

                tarjeta.getClass().getDeclaredField("numeroTarjeta").setAccessible(true);
                tarjeta.getClass().getDeclaredField("numeroTarjeta").set(tarjeta, rs.getString(1));

                tarjetas.add(tarjeta);
            }

        } catch (Exception e) {
            System.out.println("Error al listar tarjetas: " + e);
        }
        return tarjetas;
    }

    public static boolean agregarTarjeta(Tarjeta tarjeta) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_insertarTarjeta(?, ?, ?, ?, ?)}")) {

            stmt.setString(1, tarjeta.getNumeroTarjeta().replaceAll(" ", ""));
            stmt.setString(2, tarjeta.getEstado());
            stmt.setString(3, tarjeta.getTipoTarjeta());
            stmt.setDate(4, Date.valueOf(tarjeta.getFechaVencimiento().substring(3) + "-"
                                         + tarjeta.getFechaVencimiento().substring(0, 2) + "-01"));
            stmt.setString(5, tarjeta.getCliente().getIdPersona());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al agregar tarjeta: " + e);
            return false;
        }
    }

    public static boolean actualizarEstadoTarjeta(String numeroTarjeta, String nuevoEstado) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_actualizarTarjeta(?, ?)}")) {

            stmt.setString(1, numeroTarjeta.replaceAll(" ", ""));
            stmt.setString(2, nuevoEstado);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar estado de tarjeta: " + e);
            return false;
        }
    }

    public static boolean eliminarTarjeta(String numeroTarjeta) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_eliminarTarjeta(?)}")) {

            stmt.setString(1, numeroTarjeta.replaceAll(" ", ""));
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar tarjeta: " + e);
            return false;
        }
    }

    public static Tarjeta buscarTarjeta(String numeroTarjeta) {
        Tarjeta tarjeta = null;
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_buscarIdTarjeta(?)}")) {

            stmt.setString(1, numeroTarjeta.replaceAll(" ", ""));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getString(5));

                tarjeta = new Tarjeta(
                    rs.getString(3),
                    cliente
                );

                tarjeta.setEstado(rs.getString(2));
                tarjeta.setFechaVencimiento(rs.getDate(4).toLocalDate().atStartOfDay());

                tarjeta.getClass().getDeclaredField("numeroTarjeta").setAccessible(true);
                tarjeta.getClass().getDeclaredField("numeroTarjeta").set(tarjeta, rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error al buscar tarjeta: " + e);
        }
        return tarjeta;
    }
}
