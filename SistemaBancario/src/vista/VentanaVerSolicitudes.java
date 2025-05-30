package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Empleado;
import modelo.Solicitud;
import modelo.Tarjeta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class VentanaVerSolicitudes extends JDialog implements ActionListener {
	
	private Empleado empleado;

	private static final long serialVersionUID = 1L;
	private JLabel lblSolicitudes;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnVerCliente;
	private JTable tableSolicitudes;
	private DefaultTableModel defaultTableModel;
	private JButton btnAceptar;
	private JButton btnRechazar;

	public VentanaVerSolicitudes(Empleado empleado) {
		this.empleado = empleado;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Ver solicitudes");
		setBounds(100, 100, 789, 483);
		getContentPane().setLayout(null);
		{
			lblSolicitudes = new JLabel("Solicitudes");
			lblSolicitudes.setHorizontalAlignment(SwingConstants.CENTER);
			lblSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSolicitudes.setBounds(306, 46, 185, 25);
			getContentPane().add(lblSolicitudes);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(45, 94, 704, 277);
			getContentPane().add(scrollPane);
			{
				tableSolicitudes = new JTable();
				tableSolicitudes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"Id", "Asunto", "Estado", "Fecha de creación", "Fecha de resolución"};
				defaultTableModel = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableSolicitudes.setModel(defaultTableModel);
				scrollPane.setViewportView(tableSolicitudes);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(660, 395, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			btnVerCliente = new JButton("Ver perfil del cliente");
			btnVerCliente.addActionListener(this);
			btnVerCliente.setBounds(45, 395, 181, 23);
			getContentPane().add(btnVerCliente);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(238, 395, 128, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnRechazar = new JButton("Rechazar");
			btnRechazar.addActionListener(this);
			btnRechazar.setBounds(378, 395, 128, 23);
			getContentPane().add(btnRechazar);
		}
		llenarTabla();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRechazar) {
			do_btnRechazar_actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
		if (e.getSource() == btnVerCliente) {
			do_btnVerCliente_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnVerCliente_actionPerformed(ActionEvent e) {
		Solicitud solicitud = obtenerSolicitud();
		VentanaVerPerfil ventanaVerPerfil = new VentanaVerPerfil(solicitud.getCliente());
		ventanaVerPerfil.setVisible(true);
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		Solicitud solicitud = obtenerSolicitud();
		if(solicitud == null) return;
		else if(solicitud.getEstado().equals("aceptada") || solicitud.getEstado().equals("rechazada")) {
			JOptionPane.showMessageDialog(this, "La solicitud ya fue resuelta.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Cliente cliente = solicitud.getCliente();
		if(solicitud.getAsunto().contains("cuenta")) {
			String asunto = solicitud.getAsunto();
			String moneda = asunto.split(" en ")[1];
			if(solicitud.getAsunto().contains("corriente")) cliente.agregarCuenta(new Cuenta("corriente", moneda));
			else if(solicitud.getAsunto().contains("ahorro")) cliente.agregarCuenta(new Cuenta("ahorro", moneda));
		}
		else if (solicitud.getAsunto().contains("tarjeta")) {
			if(solicitud.getAsunto().contains("débito")) cliente.agregarTarjeta(new Tarjeta("débito"));
			else if(solicitud.getAsunto().contains("crédito")) cliente.agregarTarjeta(new Tarjeta("crédito"));
		}
		solicitud.setEstado("aceptada");
		solicitud.setFechaResolucion(LocalDate.now());
		llenarTabla();
	}
	protected void do_btnRechazar_actionPerformed(ActionEvent e) {
		Solicitud solicitud = obtenerSolicitud();
		if(solicitud == null) return;
		else if(solicitud.getEstado().equals("aceptada") || solicitud.getEstado().equals("rechazada")) {
			JOptionPane.showMessageDialog(this, "La solicitud ya fue resuelta.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		solicitud.setEstado("rechazada");
		solicitud.setFechaResolucion(LocalDate.now());
		llenarTabla();
	}
	private Solicitud obtenerSolicitud() {
		int posicionFilaSeleccionada = tableSolicitudes.getSelectedRow();
		if (posicionFilaSeleccionada == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una solicitud.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		String idSolicitud = tableSolicitudes.getValueAt(posicionFilaSeleccionada, 0).toString();
		return empleado.buscarSolicitud(idSolicitud);
	}
	private void llenarTabla() {
		if(empleado == null) return;
		defaultTableModel.setRowCount(0);
		for (Solicitud solicitud : empleado.getSolicitudes()) {
			Object[] fila = new Object[5];
			fila[0] = solicitud.getIdSolicitud();
			fila[1] = solicitud.getAsunto();
			fila[2] = solicitud.getEstado();
			fila[3] = solicitud.getFechaCreacion();
			fila[4] = solicitud.getFechaResolucion();
			defaultTableModel.addRow(fila);
		}
	}
}
