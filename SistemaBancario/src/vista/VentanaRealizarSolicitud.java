package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Solicitud;
import repositorio.RepositorioEmpleado;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRealizarSolicitud extends JDialog implements ActionListener {
	
	private String asunto;
	private Cliente cliente;

	private static final long serialVersionUID = 1L;
	private JLabel lblAsunto;
	private JComboBox<String> cbxAsunto;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JLabel lblMoneda;
	private JComboBox<String> cbxMonedas;

	public VentanaRealizarSolicitud(String asunto, Cliente cliente) {
		this.asunto = asunto;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Realizar solicitud");
		setBounds(100, 100, 460, 308);
		getContentPane().setLayout(null);
		{
			lblAsunto = new JLabel("");
			if(asunto.contains("cuenta")) lblAsunto.setText("¿Qué tipo de cuenta desea solicitar?");
			else if(asunto.contains("tarjeta")) lblAsunto.setText("¿Qué tipo de tarjeta desea solicitar?");
			lblAsunto.setHorizontalAlignment(SwingConstants.CENTER);
			lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAsunto.setBounds(60, 42, 339, 25);
			getContentPane().add(lblAsunto);
		}
		{
			cbxAsunto = new JComboBox<String>();
			if(asunto.contains("cuenta")) {
				String[] tiposCuentas = {"ahorro", "corriente"};
				for (String tipoCuenta : tiposCuentas) {
					cbxAsunto.addItem(tipoCuenta);
				}
			}
			else if(asunto.contains("tarjeta")) {
				String[] tiposTarjetas = {"débito", "crédito"};
				for (String tipoTarjeta : tiposTarjetas) {
					cbxAsunto.addItem(tipoTarjeta);
				}
			}
			cbxAsunto.setBounds(135, 91, 189, 27);
			getContentPane().add(cbxAsunto);
		}
		{
			btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(this);
			btnEnviar.setBounds(91, 213, 117, 29);
			getContentPane().add(btnEnviar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(261, 213, 117, 29);
			getContentPane().add(btnCancelar);
		}
		{
			lblMoneda = new JLabel("Moneda:");
			lblMoneda.setBounds(41, 153, 131, 14);
			getContentPane().add(lblMoneda);
		}
		{
			cbxMonedas = new JComboBox<String>();
			if(asunto.contains("cuenta")) {
				cbxMonedas.setEnabled(true);
				String[] monedas = {"soles", "dólares", "euros", "libras"};
				for (String moneda : monedas) {
					cbxMonedas.addItem(moneda);
				}
			} else cbxMonedas.setEnabled(false);
			cbxMonedas.setBounds(120, 148, 189, 27);
			getContentPane().add(cbxMonedas);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnEnviar_actionPerformed(ActionEvent e) {
		String tipo = (String) cbxAsunto.getSelectedItem();
		String moneda = (String) cbxMonedas.getSelectedItem();
		Empleado empleado = RepositorioEmpleado.obtenerEmpleadoAleatorio();
    	if(empleado == null) {
    		JOptionPane.showMessageDialog(this, "No hay empleados disponibles, vuelva a intentarlo más tarde.", "Información", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}
    	asunto = tipo.equals("corriente") ? asunto + " " + tipo : asunto + " de " + tipo;
    	Solicitud solicitud = new Solicitud(asunto + " en " + moneda, cliente, empleado);
    	empleado.agregarSolicitud(solicitud);
    	JOptionPane.showMessageDialog(this, "La solicitud se realizó con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
    	dispose();
	}
}
