package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Transaccion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaTransaccion extends JDialog implements ActionListener {
	
	private Cliente cliente;
	private String tipo;

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JLabel lblTransaccion;
	private JLabel lblSelecciona;
	private JLabel lblNumeroCuentaDestino;
	private JTextField txtNumeroCuentaDestino;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JLabel lblMotivo;
	private JTextField txtMotivoPagar;
	private JButton btnContinuar;
	private JTextField txtNumeroCuentaOrigen;

	public VentanaTransaccion(Cliente cliente, String tipo) {
		this.cliente = cliente;
		this.tipo = tipo.toLowerCase();
		
		setTitle("Transacción");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 520, 343);
		getContentPane().setLayout(null);
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(301, 253, 117, 29);
			getContentPane().add(btnCancelar);
		}
		{
			lblTransaccion = new JLabel(tipo);
			lblTransaccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTransaccion.setBounds(90, 32, 339, 25);
			getContentPane().add(lblTransaccion);
		}
		{
			lblSelecciona = new JLabel("Número de cuenta de origen:");
			lblSelecciona.setBounds(38, 94, 209, 16);
			getContentPane().add(lblSelecciona);
		}
		{
			lblNumeroCuentaDestino = new JLabel("Número de cuenta de destino:");
			lblNumeroCuentaDestino.setBounds(38, 127, 209, 16);
			getContentPane().add(lblNumeroCuentaDestino);
		}
		{
			txtNumeroCuentaDestino = new JTextField();
			if(tipo.equalsIgnoreCase("retirar")) txtNumeroCuentaDestino.setEnabled(false);
			else txtNumeroCuentaDestino.setEnabled(true);
			txtNumeroCuentaDestino.setBounds(259, 122, 217, 26);
			getContentPane().add(txtNumeroCuentaDestino);
			txtNumeroCuentaDestino.setColumns(10);
		}
		{
			lblMonto = new JLabel("Monto a " + tipo.toLowerCase() + ":");
			lblMonto.setBounds(38, 165, 209, 16);
			getContentPane().add(lblMonto);
		}
		{
			txtMonto = new JTextField();
			txtMonto.setColumns(10);
			txtMonto.setBounds(259, 160, 130, 26);
			getContentPane().add(txtMonto);
		}
		{
			lblMotivo = new JLabel("Motivo a pagar:");
			lblMotivo.setBounds(38, 203, 209, 16);
			getContentPane().add(lblMotivo);
		}
		{
			txtMotivoPagar = new JTextField();
			if(tipo.equalsIgnoreCase("pagar")) txtMotivoPagar.setEnabled(true);
			else txtMotivoPagar.setEnabled(false);
			txtMotivoPagar.setColumns(10);
			txtMotivoPagar.setBounds(259, 198, 217, 26);
			getContentPane().add(txtMotivoPagar);
		}
		{
			btnContinuar = new JButton("Continuar");
			btnContinuar.addActionListener(this);
			btnContinuar.setBounds(79, 253, 117, 29);
			getContentPane().add(btnContinuar);
		}
		{
			txtNumeroCuentaOrigen = new JTextField();
			if(tipo.equalsIgnoreCase("depositar")) txtNumeroCuentaOrigen.setEnabled(false);
			else txtNumeroCuentaOrigen.setEnabled(true);
			txtNumeroCuentaOrigen.setColumns(10);
			txtNumeroCuentaOrigen.setBounds(259, 89, 217, 26);
			getContentPane().add(txtNumeroCuentaOrigen);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnContinuar) {
			do_btnContinuar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnContinuar_actionPerformed(ActionEvent e) {
		Cuenta cuentaOrigen = null, cuentaDestino = null;
		String descripcion = "";
		String numeroOrigen = txtNumeroCuentaOrigen.getText().trim();
		String numeroDestino = txtNumeroCuentaDestino.getText().trim();
		String motivoPagar = txtMotivoPagar.getText().trim();
		if(txtMonto.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo monto está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		double monto = Double.parseDouble(txtMonto.getText().trim());
		if(monto < 0) {
			JOptionPane.showMessageDialog(this, "Monto inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}else if(monto == 0) {
			JOptionPane.showMessageDialog(this, "Monto no puede ser cero.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(tipo.equals("retirar") || tipo.equals("transferir") || tipo.equals("pagar")) {
			if(numeroOrigen.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo número de cuenta de origen está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaOrigen = cliente.buscarCuenta(numeroOrigen);
			if(cuentaOrigen == null) {
				JOptionPane.showMessageDialog(this, "La cuenta de origen no existe.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(monto > cuentaOrigen.getSaldoDisponible()) {
				JOptionPane.showMessageDialog(this, "El saldo de la cuenta de origen es insuficiente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(tipo.equals("transferir")) descripcion = "Número de cuenta de origen: " + numeroOrigen;
			else if(tipo.equals("pagar")) descripcion = "Número de cuenta de origen: " + numeroOrigen;
			else descripcion = "Número de cuenta de origen: " + numeroOrigen + ";";
		}
		if(tipo.equals("depositar") || tipo.equals("transferir") || tipo.equals("pagar")){
			if(numeroDestino.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo número de cuenta de destino está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaDestino = cliente.buscarCuenta(numeroDestino);
			if(cuentaDestino == null) {
				JOptionPane.showMessageDialog(this, "La cuenta de destino no existe.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if((tipo.equalsIgnoreCase("transferir") || tipo.equalsIgnoreCase("pagar")) && cuentaOrigen.equals(cuentaDestino)) {
				JOptionPane.showMessageDialog(this, "No se puede " + tipo + " a la misma cuenta", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(tipo.equals("transferir")) descripcion += "; Número de cuenta de destino: " + numeroDestino + ";";
			else if(tipo.equals("pagar")) descripcion += "; Número de cuenta de destino: " + numeroDestino + ";";
			else descripcion = "Número de cuenta de destino: " + numeroDestino + ";";
		}
		if(tipo.equals("pagar")) {
			if(motivoPagar.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo motivo a pagar está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			descripcion += "; Motivo: " + motivoPagar + ";";
		}
		if(cuentaOrigen!=null) {
			if(cuentaOrigen.getEstado().equals("cancelada")){
				JOptionPane.showMessageDialog(this, "La cuenta de origen está cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaOrigen.setSaldoContable(cuentaOrigen.getSaldoContable() - monto);
			cuentaOrigen.setSaldoDisponible(cuentaOrigen.getSaldoDisponible() - monto);
		}
		if(cuentaDestino!=null) {
			if(cuentaDestino.getEstado().equals("cancelada")) {
				JOptionPane.showMessageDialog(this, "La cuenta de destino está cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaDestino.setSaldoContable(cuentaDestino.getSaldoContable() + monto);
			cuentaDestino.setSaldoDisponible(cuentaDestino.getSaldoDisponible() + monto);
		}
		VentanaAutenticar ventanaAutenticar = new VentanaAutenticar(cliente);
		ventanaAutenticar.setVisible(true);
		if(ventanaAutenticar.getEstadoAutenticacion()) {			
			Transaccion transaccion = new Transaccion(tipo, descripcion, monto);
			transaccion.setEstado("completada");
			cliente.agregarTransaccion(transaccion);
			JOptionPane.showMessageDialog(this, "La autenticación se realizó con éxito, la transacción se ejecutó.", "Información", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "La autenticación falló.", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		dispose();
	}
}
