package modelo;
import java.util.Random;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class Cuenta {
	protected long numeroCuenta;
	protected int saldo;
	protected String fechaCreacion;
	protected boolean estado;
	public Cuenta() {
		this.numeroCuenta = generarNumeroCuenta();
		this.saldo = 0;
		this.fechaCreacion = generarFechaCreacion();
		this.estado = false;
	}
	private long generarNumeroCuenta() {
		Random rand = new Random();
		String numero = "";
		for (int i = 0; i < 18; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        numero += Integer.toString(n);
	    }
		return Long.parseLong(numero);
	}
	private String generarFechaCreacion() {
        ZonedDateTime fechaYHora = ZonedDateTime.now(ZoneId.of("America/Lima"));
		return fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public boolean Retirar(int monto) {
		if(monto > saldo || monto < 0) return false;
		saldo -= monto;
		return true;
	}
	public boolean Depositar(int monto) {
		if(monto < 0) return false;
		saldo += monto;
		return true;
	}
	public int ConsultarSaldo() {
		return saldo;
	}
	public void Cancelar() {
		this.estado = true;
	}
	public long getNumeroCuenta() {
		return numeroCuenta;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public boolean getEstado() {
		return estado;
	}
}
