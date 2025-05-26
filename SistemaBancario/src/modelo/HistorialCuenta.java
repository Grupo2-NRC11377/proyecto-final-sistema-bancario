package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialCuenta {
    private String estado;
    private LocalDateTime fechaCambio;

    public HistorialCuenta(String estado) {
        this.estado = estado;
        this.fechaCambio = LocalDateTime.now();
    }

    public String getEstado() {
        return estado;//
    }

    public String getFechaCambio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaCambio.format(formatter);
    }

    @Override
    public String toString() {
        return "Estado: " + estado + ", Fecha: " + getFechaCambio();
    }
}
