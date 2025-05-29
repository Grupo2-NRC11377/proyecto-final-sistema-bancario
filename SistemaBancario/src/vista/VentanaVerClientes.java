package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import repositorio.RepositorioCliente;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class VentanaVerClientes extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblClientes;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JTable tableClientes;
	private DefaultTableModel defaultTableModel;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JButton btnFiltrar;
	private JButton btnVerDetalles;

	public VentanaVerClientes() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Ver clientes");
		setBounds(100, 100, 846, 486);
		getContentPane().setLayout(null);
		{
			lblClientes = new JLabel("Clientes");
			lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblClientes.setBounds(330, 41, 185, 25);
			getContentPane().add(lblClientes);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 172, 778, 204);
			getContentPane().add(scrollPane);
			{
				tableClientes = new JTable();
				tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"DNI", "Nombres", "Apellidos", "teléfono", "Dirección", "Correo electrónico"};
				defaultTableModel = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableClientes.setModel(defaultTableModel);
				scrollPane.setViewportView(tableClientes);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(723, 402, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblDni.setBounds(34, 95, 129, 13);
			getContentPane().add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setColumns(10);
			txtDni.setBounds(80, 88, 150, 26);
			getContentPane().add(txtDni);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblNombres.setBounds(257, 95, 129, 13);
			getContentPane().add(lblNombres);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setColumns(10);
			txtNombres.setBounds(337, 88, 179, 26);
			getContentPane().add(txtNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblApellidos.setBounds(547, 95, 129, 13);
			getContentPane().add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(633, 88, 179, 26);
			getContentPane().add(txtApellidos);
		}
		{
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(this);
			btnFiltrar.setBounds(378, 126, 89, 23);
			getContentPane().add(btnFiltrar);
		}
		{
			btnVerDetalles = new JButton("Ver detalles");
			btnVerDetalles.addActionListener(this);
			btnVerDetalles.setBounds(34, 399, 117, 29);
			getContentPane().add(btnVerDetalles);
		}
		llenarTabla();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerDetalles) {
			do_btnVerDetalles_actionPerformed(e);
		}
		if (e.getSource() == btnFiltrar) {
			do_btnFiltrar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	public void llenarTabla() {
		defaultTableModel.setRowCount(0);
		for (Cliente cliente : RepositorioCliente.getClientes()) {
			Object[] fila = new Object[6];
			fila[0] = cliente.getDni();
			fila[1] = cliente.getNombres();
			fila[2] = cliente.getApellidos();
			fila[3] = cliente.getTelefono();
			fila[4] = cliente.getDireccion();
			fila[5] = cliente.getCorreo();
			defaultTableModel.addRow(fila);
		}
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent e) {
		String dni = txtDni.getText().trim();
		String nombres = txtNombres.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		defaultTableModel.setRowCount(0);
		boolean filtrarPorDni = !dni.isEmpty();
		boolean filtrarPorNombres = !nombres.isEmpty();
		boolean filtrarPorApellidos = !apellidos.isEmpty();
		if (!filtrarPorDni && !filtrarPorNombres && !filtrarPorApellidos) {
		    llenarTabla();
		    return;
		}
		for (Cliente cliente : RepositorioCliente.getClientes()) {
		    boolean coincideDni = !filtrarPorDni || cliente.getDni().equals(dni);
		    boolean coincideNombres = !filtrarPorNombres || cliente.getNombres().contains(nombres);
		    boolean coincideApellidos = !filtrarPorApellidos || cliente.getApellidos().contains(apellidos);
		    if (coincideDni && coincideNombres && coincideApellidos) {
		    	Object[] fila = new Object[6];
				fila[0] = cliente.getDni();
				fila[1] = cliente.getNombres();
				fila[2] = cliente.getApellidos();
				fila[3] = cliente.getTelefono();
				fila[4] = cliente.getDireccion();
				fila[5] = cliente.getCorreo();
				defaultTableModel.addRow(fila);
		    }
		}
	}
	protected void do_btnVerDetalles_actionPerformed(ActionEvent e) {
		int posicionFilaSeleccionada = tableClientes.getSelectedRow();
		if(posicionFilaSeleccionada == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un cliente.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String correo = tableClientes.getValueAt(posicionFilaSeleccionada, 5).toString();
		Cliente cliente = RepositorioCliente.buscarCliente(correo);
		if(cliente == null) {
			JOptionPane.showMessageDialog(this, "El cliente seleccionado no existe.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		VentanaVerDetallesCliente ventanaVerDetallesCliente = new VentanaVerDetallesCliente(cliente);
		ventanaVerDetallesCliente.setVisible(true);
	}
}
