package modelo;

public class Persona {
	public Persona(String nombres, String apellidos, int telefono, String direccion, String correo, String contraseña) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	protected String nombres;
	protected String apellidos;
	protected int telefono;
	protected String direccion;
	protected String correo;
	protected String contraseña;
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
