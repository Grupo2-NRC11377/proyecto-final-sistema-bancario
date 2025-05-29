package vista;

import javax.swing.JDialog;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Tarjeta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerDetallesCliente extends JDialog implements ActionListener {

	private Cliente cliente;
	
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JLabel lblCorreoElectrnico;
	private JLabel lblDireccin;
	private JLabel lblTelfono;
	private JLabel lblApellidos;
	private JLabel lblNombres;
	private JLabel lblDni;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tableCuentasCliente;
	private JScrollPane scrollPane_1;
	private JLabel lblCuentas;
	private JLabel lblTarjetas;
	private JTable tableTarjetasCliente;
	private DefaultTableModel defaultTableModelCuentas;
	private DefaultTableModel defaultTableModelTarjetas;

	public VentanaVerDetallesCliente(Cliente cliente) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.cliente = cliente;
		setTitle("Ver detalles cliente");
		setBounds(100, 100, 833, 597);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Cliente");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(368, 37, 96, 23);
			getContentPane().add(lblNewLabel);
		}
		{
			txtDni = new JTextField();
			txtDni.setText((String) null);
			txtDni.setEditable(false);
			txtDni.setColumns(10);
			txtDni.setBounds(188, 89, 209, 20);
			getContentPane().add(txtDni);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setText((String) null);
			txtNombres.setEditable(false);
			txtNombres.setColumns(10);
			txtNombres.setBounds(188, 114, 209, 20);
			getContentPane().add(txtNombres);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setText((String) null);
			txtApellidos.setEditable(false);
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(188, 139, 209, 20);
			getContentPane().add(txtApellidos);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setText((String) null);
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(188, 164, 209, 20);
			getContentPane().add(txtTelefono);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setText((String) null);
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(188, 189, 209, 20);
			getContentPane().add(txtDireccion);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setText((String) null);
			txtCorreo.setEditable(false);
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(188, 214, 209, 20);
			getContentPane().add(txtCorreo);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(41, 217, 152, 14);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			lblDireccin = new JLabel("Dirección:");
			lblDireccin.setBounds(41, 192, 115, 14);
			getContentPane().add(lblDireccin);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setBounds(41, 167, 115, 14);
			getContentPane().add(lblTelfono);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(41, 142, 115, 14);
			getContentPane().add(lblApellidos);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setBounds(41, 117, 115, 14);
			getContentPane().add(lblNombres);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setBounds(41, 92, 135, 14);
			getContentPane().add(lblDni);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(372, 513, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 298, 355, 183);
			getContentPane().add(scrollPane);
			{
				tableCuentasCliente = new JTable();
				tableCuentasCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"Número de cuenta", "Tipo de cuenta", "Estado"};
				defaultTableModelCuentas = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableCuentasCliente.setModel(defaultTableModelCuentas);
				scrollPane.setViewportView(tableCuentasCliente);
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(433, 298, 355, 183);
			getContentPane().add(scrollPane_1);
			{
				tableTarjetasCliente = new JTable();
				tableTarjetasCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = { "Número de tarjeta", "Tipo de tarjeta", "Estado" };
				defaultTableModelTarjetas = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
		        };
				tableTarjetasCliente.setModel(defaultTableModelTarjetas);
				scrollPane_1.setViewportView(tableTarjetasCliente);
			}
		}
		{
			lblCuentas = new JLabel("Cuentas:");
			lblCuentas.setBounds(41, 259, 152, 14);
			getContentPane().add(lblCuentas);
		}
		{
			lblTarjetas = new JLabel("Tarjetas");
			lblTarjetas.setBounds(433, 258, 152, 14);
			getContentPane().add(lblTarjetas);
		}
		mostrarDatos();
		llenarTablaCuentas();
		llenarTablaTarjetas();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	private void mostrarDatos() {
		txtDni.setText(cliente.getDni());
		txtNombres.setText(cliente.getNombres());
		txtApellidos.setText(cliente.getApellidos());
		txtTelefono.setText(cliente.getTelefono());
		txtDireccion.setText(cliente.getDireccion());
		txtCorreo.setText(cliente.getCorreo());		
	}
	private void llenarTablaCuentas() {
		if(cliente == null) return;
		defaultTableModelCuentas.setRowCount(0);
		for (Cuenta cuenta : cliente.getCuentas()) {
			Object[] fila = new Object[3];
			fila[0] = cuenta.getNumeroCuenta();
			fila[1] = cuenta.getTipoCuenta();
			fila[2] = cuenta.getEstado();
			defaultTableModelCuentas.addRow(fila);
		}
	}
	private void llenarTablaTarjetas() {
		if(cliente == null) return;
		defaultTableModelTarjetas.setRowCount(0);
		for (Tarjeta tarjeta : cliente.getTarjetas()) {
			Object[] fila = new Object[3];
			fila[0] = tarjeta.getNumeroTarjeta();
			fila[1] = tarjeta.getTipoTarjeta();
			fila[2] = tarjeta.getEstado();
			defaultTableModelTarjetas.addRow(fila);
		}
	}
}
