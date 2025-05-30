package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Cuenta;
import modelo.Transaccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaVerDetallesCB extends JDialog implements ActionListener {
	
	private Cuenta cuenta;

	private static final long serialVersionUID = 1L;
	private JLabel lblCuentaBancaria;
	private JLabel lblNewLabel;
	private JLabel lblSaldoDisponible;
	private JLabel lblSaldoContable;
	private JLabel lblFechaDeCreacin;
	private JLabel lblEstado;
	private JTextField txtNumeroCuenta;
	private JTextField txtSaldoDisponible;
	private JTextField txtSaldoContable;
	private JTextField txtFechaCreacion;
	private JTextField txtEstado;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JLabel lblHistorial;
	private JTable tableHistorial;
	private DefaultTableModel defaultTableModel;
	private JLabel lblMoneda;
	private JTextField txtMoneda;

	public VentanaVerDetallesCB(Cuenta cuenta) {
		this.cuenta = cuenta;
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Ver detalles");
		setBounds(100, 100, 704, 614);
		getContentPane().setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(307, 533, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblCuentaBancaria = new JLabel("");
			if(cuenta != null) lblCuentaBancaria.setText("Cuenta de " + cuenta.getTipoCuenta());
			lblCuentaBancaria.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCuentaBancaria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCuentaBancaria.setBounds(163, 29, 378, 34);
			getContentPane().add(lblCuentaBancaria);
		}
		{
			lblNewLabel = new JLabel("Número de cuenta:");
			lblNewLabel.setBounds(28, 96, 131, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			lblSaldoDisponible = new JLabel("Saldo disponible:");
			lblSaldoDisponible.setBounds(28, 121, 131, 14);
			getContentPane().add(lblSaldoDisponible);
		}
		{
			lblSaldoContable = new JLabel("Saldo contable:");
			lblSaldoContable.setBounds(28, 146, 131, 14);
			getContentPane().add(lblSaldoContable);
		}
		{
			lblFechaDeCreacin = new JLabel("Fecha de creación:");
			lblFechaDeCreacin.setBounds(28, 171, 131, 14);
			getContentPane().add(lblFechaDeCreacin);
		}
		{
			lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(28, 196, 131, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtNumeroCuenta = new JTextField();
			txtNumeroCuenta.setEditable(false);
			txtNumeroCuenta.setBounds(153, 93, 240, 20);
			getContentPane().add(txtNumeroCuenta);
			txtNumeroCuenta.setColumns(10);
		}
		{
			txtSaldoDisponible = new JTextField();
			txtSaldoDisponible.setEditable(false);
			txtSaldoDisponible.setColumns(10);
			txtSaldoDisponible.setBounds(153, 118, 240, 20);
			getContentPane().add(txtSaldoDisponible);
		}
		{
			txtSaldoContable = new JTextField();
			txtSaldoContable.setEditable(false);
			txtSaldoContable.setColumns(10);
			txtSaldoContable.setBounds(153, 143, 240, 20);
			getContentPane().add(txtSaldoContable);
		}
		{
			txtFechaCreacion = new JTextField();
			txtFechaCreacion.setEditable(false);
			txtFechaCreacion.setColumns(10);
			txtFechaCreacion.setBounds(153, 168, 240, 20);
			getContentPane().add(txtFechaCreacion);
		}
		{
			txtEstado = new JTextField();
			txtEstado.setEditable(false);
			txtEstado.setColumns(10);
			txtEstado.setBounds(153, 193, 240, 20);
			getContentPane().add(txtEstado);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 284, 644, 231);
			getContentPane().add(scrollPane);
			{
				tableHistorial = new JTable();
				tableHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"Id", "Tipo", "Descripción", "Fecha y hora", "Estado", "Monto"};
				defaultTableModel = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableHistorial.setModel(defaultTableModel);
				scrollPane.setViewportView(tableHistorial);
			}
		}
		{
			lblHistorial = new JLabel("Historial:");
			lblHistorial.setBounds(28, 260, 131, 14);
			getContentPane().add(lblHistorial);
		}
		{
			lblMoneda = new JLabel("Moneda:");
			lblMoneda.setBounds(28, 225, 131, 14);
			getContentPane().add(lblMoneda);
		}
		{
			txtMoneda = new JTextField();
			txtMoneda.setText((String) null);
			txtMoneda.setEditable(false);
			txtMoneda.setColumns(10);
			txtMoneda.setBounds(153, 222, 240, 20);
			getContentPane().add(txtMoneda);
		}
		mostrarDatos();
		llenarTabla();
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
		txtNumeroCuenta.setText(cuenta.getNumeroCuenta());
		txtSaldoDisponible.setText(cuenta.getSaldoDisponibleFormateado());
		txtSaldoContable.setText(cuenta.getSaldoContableFormateado());
		txtFechaCreacion.setText(cuenta.getFechaCreacion());
		txtEstado.setText(cuenta.getEstado());
		txtMoneda.setText(cuenta.getMoneda());
	}
	private void llenarTabla() {
		if(cuenta == null) return;
		defaultTableModel.setRowCount(0);
		for (Transaccion transaccion : cuenta.getTransacciones()) {
			Object[] fila = new Object[6];
			fila[0] = transaccion.getIdTransaccion();
			fila[1] = transaccion.getTipo();
			fila[2] = transaccion.getDescripcion();
			fila[3] = transaccion.getFechaHora();
			fila[4] = transaccion.getEstado();
			fila[5] = transaccion.getMonto();
			defaultTableModel.addRow(fila);
		}
	}
}
