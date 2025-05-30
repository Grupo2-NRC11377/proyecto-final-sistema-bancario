package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Transaccion;
import repositorio.RepositorioCuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
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
		Cliente clienteOrigen = null, clienteDestino = null;
		Cuenta cuentaOrigen = null, cuentaDestino = null;
		String descripcion = "";
		String numeroOrigen = txtNumeroCuentaOrigen.getText().trim();
		String numeroDestino = txtNumeroCuentaDestino.getText().trim();
		String motivoPagar = txtMotivoPagar.getText().trim();
		if(txtMonto.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo monto está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		double montoInicial = Double.parseDouble(txtMonto.getText().trim()), montoFinal = 0;
		if(montoInicial < 0) {
			JOptionPane.showMessageDialog(this, "Monto inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}else if(montoInicial == 0) {
			JOptionPane.showMessageDialog(this, "Monto no puede ser cero.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(tipo.equals("retirar") || tipo.equals("transferir") || tipo.equals("pagar")) {
			if(numeroOrigen.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo número de cuenta de origen está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaOrigen = RepositorioCuenta.buscarCuenta(numeroOrigen);
			if(cuentaOrigen == null) {
				JOptionPane.showMessageDialog(this, "La cuenta de origen no existe.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(montoInicial > cuentaOrigen.getSaldoDisponible()) {
				JOptionPane.showMessageDialog(this, "El saldo de la cuenta de origen es insuficiente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			clienteOrigen = cuentaOrigen.getCliente();
			if(tipo.equals("transferir")) descripcion = "Número de cuenta de origen: " + numeroOrigen;
			else if(tipo.equals("pagar")) descripcion = "Número de cuenta de origen: " + numeroOrigen;
			else descripcion = "Número de cuenta de origen: " + numeroOrigen + ";";
		}
		if(tipo.equals("depositar") || tipo.equals("transferir") || tipo.equals("pagar")){
			if(numeroDestino.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo número de cuenta de destino está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			cuentaDestino = RepositorioCuenta.buscarCuenta(numeroDestino);
			if(cuentaDestino == null) {
				JOptionPane.showMessageDialog(this, "La cuenta de destino no existe.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if((tipo.equalsIgnoreCase("transferir") || tipo.equalsIgnoreCase("pagar")) && cuentaOrigen.equals(cuentaDestino)) {
				JOptionPane.showMessageDialog(this, "No se puede " + tipo + " a la misma cuenta", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			clienteDestino = cuentaDestino.getCliente();
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
			cuentaOrigen.setSaldoContable(cuentaOrigen.getSaldoContable() - montoInicial);
			cuentaOrigen.setSaldoDisponible(cuentaOrigen.getSaldoDisponible() - montoInicial);
		}
		if(cuentaDestino!=null) {
			if(cuentaDestino.getEstado().equals("cancelada")) {
				JOptionPane.showMessageDialog(this, "La cuenta de destino está cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			montoFinal = montoInicial;
			if(tipo.equals("transferir") || tipo.equals("pagar")) montoFinal = calcularConversión(cuentaOrigen.getMoneda(), cuentaDestino.getMoneda(), montoInicial);
			cuentaDestino.setSaldoContable(cuentaDestino.getSaldoContable() + montoFinal);
			cuentaDestino.setSaldoDisponible(cuentaDestino.getSaldoDisponible() + montoFinal);
		}
		VentanaAutenticar ventanaAutenticar = new VentanaAutenticar(cliente);
		ventanaAutenticar.setVisible(true);
		if(ventanaAutenticar.getEstadoAutenticacion()) {			
			Transaccion transaccion = new Transaccion(tipo, descripcion, montoInicial);
			transaccion.setEstado("completada");
			if(cuentaOrigen!=null) cuentaOrigen.agregarTransaccion(transaccion);
			if(cuentaDestino!=null) cuentaDestino.agregarTransaccion(transaccion);
			if(clienteOrigen != null && clienteDestino != null) {
				if(clienteOrigen.equals(clienteDestino)) clienteOrigen.agregarTransaccion(transaccion);
				else {
					clienteOrigen.agregarTransaccion(transaccion);
					clienteDestino.agregarTransaccion(transaccion);
				}
			}else if(cuentaDestino==null) {
				clienteOrigen.agregarTransaccion(transaccion);
			}else if(cuentaOrigen==null) {
				clienteDestino.agregarTransaccion(transaccion);
			}
			int seleccion = JOptionPane.showConfirmDialog(this,
	                "La autenticación se realizó con éxito, la transacción se ejecutó. ¿Deseas descargar el comprobante?",
	                "Confirmar descarga del comprobante", JOptionPane.YES_NO_OPTION);
	        if (seleccion == JOptionPane.YES_OPTION) {
	        	JFileChooser fileChooser = new JFileChooser();
	    	    fileChooser.setDialogTitle("Descargar comprobante");
	    	    fileChooser.setSelectedFile(new java.io.File("comprobante-" + transaccion.getIdTransaccion() + ".txt"));
	    	    seleccion = fileChooser.showSaveDialog(this);
	    	    if (seleccion == JFileChooser.APPROVE_OPTION) {
	    	        java.io.File archivo = fileChooser.getSelectedFile();
	    	        try {
	    	        	FileWriter writer = new FileWriter(archivo);
	    	            writer.write("Comprobante de la transacción\n");
	    	            writer.write("------------------------------\n");
	    	            writer.write("ID: " + transaccion.getIdTransaccion() + "\n");
	    	            writer.write("Tipo: " + transaccion.getTipo() + "\n");
	            		writer.write("Descripción: " + transaccion.getDescripcion() + "\n");
        				writer.write("Fecha y hora: " + transaccion.getFechaHora() + "\n");
        				writer.write("Estado: " + transaccion.getEstado() + "\n");
        				writer.write("Monto: " + transaccion.getMonto() + "\n");
	    	        	writer.close();
	    	            JOptionPane.showMessageDialog(this, "Comprobante descargado correctamente.");
	    	        } catch (IOException ex) {
	    	            JOptionPane.showMessageDialog(this, "Error al descargar el comprobante.", "Error", JOptionPane.ERROR_MESSAGE);
	    	            ex.printStackTrace();
	    	        }
	    	    }
	        }
		}else {
			JOptionPane.showMessageDialog(this, "La autenticación falló.", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		dispose();
	}
	private double calcularConversión(String monedaOrigen, String monedaDestino, double monto) {
		final double SOL_TO_DOLAR = 0.27;
	    final double SOL_TO_EURO = 0.24;
	    final double SOL_TO_LIBRA = 0.20;
	    final double DOLAR_TO_SOL = 1 / SOL_TO_DOLAR;
	    final double DOLAR_TO_EURO = 0.92;
	    final double DOLAR_TO_LIBRA = 0.79;
	    final double EURO_TO_SOL = 1 / SOL_TO_EURO;
	    final double EURO_TO_DOLAR = 1.09;
	    final double EURO_TO_LIBRA = 0.85;
	    final double LIBRA_TO_SOL = 1 / SOL_TO_LIBRA;
	    final double LIBRA_TO_DOLAR = 1.26;
	    final double LIBRA_TO_EURO = 1.18;
	    if (monedaOrigen.equals("soles")) {
	        if (monedaDestino.equals("soles")) return monto;
	        else if (monedaDestino.equals("dólares")) return monto * SOL_TO_DOLAR;
	        else if (monedaDestino.equals("euros")) return monto * SOL_TO_EURO;
	        else if (monedaDestino.equals("libras")) return monto * SOL_TO_LIBRA;
	    } else if (monedaOrigen.equals("dólares")) {
	        if (monedaDestino.equals("soles")) return monto * DOLAR_TO_SOL;
	        else if (monedaDestino.equals("dólares")) return monto;
	        else if (monedaDestino.equals("euros")) return monto * DOLAR_TO_EURO;
	        else if (monedaDestino.equals("libras")) return monto * DOLAR_TO_LIBRA;
	    } else if (monedaOrigen.equals("euros")) {
	        if (monedaDestino.equals("soles")) return monto * EURO_TO_SOL;
	        else if (monedaDestino.equals("dólares")) return monto * EURO_TO_DOLAR;
	        else if (monedaDestino.equals("euros")) return monto;
	        else if (monedaDestino.equals("libras")) return monto * EURO_TO_LIBRA;
	    } else if (monedaOrigen.equals("libras")) {
	        if (monedaDestino.equals("soles")) return monto * LIBRA_TO_SOL;
	        else if (monedaDestino.equals("dólares")) return monto * LIBRA_TO_DOLAR;
	        else if (monedaDestino.equals("euros")) return monto * LIBRA_TO_EURO;
	        else if (monedaDestino.equals("libras")) return monto;
	    }
	    return monto;
	}
}
