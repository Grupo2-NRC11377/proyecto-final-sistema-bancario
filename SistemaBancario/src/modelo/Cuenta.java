package modelo;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Cuenta {
	protected String numeroCuenta;
	protected double saldoContable;
	protected double saldoDisponible;
	protected LocalDate fechaCreacion;
	protected String estado;
	protected String tipoCuenta;
    private ArrayList<HistorialCuenta> historialEstados;

	public Cuenta(String tipoCuenta) {
		this.numeroCuenta = generarNumeroCuenta();
		this.saldoContable = this.saldoDisponible = 0;
		this.fechaCreacion = LocalDate.now();
		this.estado = "activa";
		this.tipoCuenta = tipoCuenta;
		this.historialEstados = new ArrayList<>();
		registrarEstado(this.estado);
	}	
	private String generarNumeroCuenta() {
		Random rand = new Random();
		String numero = "";
		for (int i = 0; i < 10; i++)
	    {
	        int n = rand.nextInt(10);
	        numero += Integer.toString(n);
	    }
		return numero;
	}
	
	public void setSaldoContable(double saldoContable) {
		this.saldoContable = saldoContable;
	}
	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroCuenta() {
		return numeroCuenta.substring(0, 3) + "-" + numeroCuenta.substring(3);
	}
	public double getSaldoContable() {
		return saldoContable;
	}
	public double getSaldoDisponible() {
		return saldoDisponible;
	}
	public String getFechaCreacion() {
		return fechaCreacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public String getEstado() {
		return estado;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public String getSaldoContableSoles() {
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "PE"));
        return formatoMoneda.format(saldoContable);
	}
	public String getSaldoDisponibleSoles() {
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "PE"));
        return formatoMoneda.format(saldoDisponible);
	}
	private void registrarEstado(String nuevoEstado) {
        historialEstados.add(new HistorialCuenta(nuevoEstado));
    }
	public ArrayList<HistorialCuenta> getHistorialEstados() {
        return historialEstados;
    }
}
