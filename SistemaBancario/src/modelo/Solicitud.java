package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Solicitud {
	private String idSolicitud;
	private String asunto;
	private String estado;
	private LocalDate fechaCreacion;
	private LocalDate fechaResolucion;
	private Cliente Cliente;
	private Empleado Empleado;
	public Solicitud() {}
	public Solicitud(String asunto, Cliente cliente, Empleado empleado) {
		this.idSolicitud = UUID.randomUUID().toString();
		this.asunto = asunto;
		this.estado = "pendiente";
		this.fechaCreacion = LocalDate.now();
		this.fechaResolucion = null;
		this.Cliente = cliente;
		this.Empleado = empleado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setFechaResolucion(LocalDate fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getIdSolicitud() {
		return idSolicitud;
	}

	public String getAsunto() {
		return asunto;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaCreacion() {
		return fechaCreacion.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
	}

	public String getFechaResolucion() {
		return fechaResolucion == null ? "--/--/--" : fechaResolucion.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
	}

	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Empleado getEmpleado() {
		return Empleado;
	}
	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}
	
}
