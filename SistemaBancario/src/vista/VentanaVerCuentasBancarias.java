package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Cuenta;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class VentanaVerCuentasBancarias extends JDialog implements ActionListener {

	private Cliente cliente;
	
	private static final long serialVersionUID = 1L;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tableCuentasBancarias;
	private DefaultTableModel defaultTableModel;
	private JButton btnVerDetalles;

	public VentanaVerCuentasBancarias(Cliente cliente) {
		this.cliente = cliente;
		setTitle("Ver cuentas bancarias");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 785, 482);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cuentas bancarias");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(293, 40, 185, 25);
			getContentPane().add(lblNewLabel);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(647, 389, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 88, 704, 277);
			getContentPane().add(scrollPane);
			{
				tableCuentasBancarias = new JTable();
				tableCuentasBancarias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"Número de cuenta", "Tipo de cuenta", "Saldo disponible", "Saldo contable", 
						"Estado"};
				defaultTableModel = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableCuentasBancarias.setModel(defaultTableModel);
				scrollPane.setViewportView(tableCuentasBancarias);
			}
		}
		{
			btnVerDetalles = new JButton("Ver detalles");
			btnVerDetalles.addActionListener(this);
			btnVerDetalles.setBounds(32, 389, 128, 23);
			getContentPane().add(btnVerDetalles);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerDetalles) {
			do_btnVerDetalles_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	public void llenarTabla() {
		if(cliente == null) return;
		for (Cuenta cuenta : cliente.getCuentas()) {
			Object[] fila = new Object[6];
			fila[0] = cuenta.getNumeroCuenta();
			fila[1] = cuenta.getTipoCuenta();
			fila[2] = cuenta.getSaldoDisponibleSoles();
			fila[3] = cuenta.getSaldoContableSoles();
			fila[4] = cuenta.getEstado();
			defaultTableModel.addRow(fila);
		}
	}
	protected void do_btnVerDetalles_actionPerformed(ActionEvent e) {
		int posicionFilaSeleccionada = tableCuentasBancarias.getSelectedRow();
		if(posicionFilaSeleccionada == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una cuenta.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String numeroCuenta = tableCuentasBancarias.getValueAt(posicionFilaSeleccionada, 0).toString();
		Cuenta cuenta = cliente.buscarCuenta(numeroCuenta);
		if(cuenta == null) {
			JOptionPane.showMessageDialog(this, "La cuenta seleccionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		VentanaVerDetallesCB ventanaVerDetallesCB = new VentanaVerDetallesCB(cuenta);
		ventanaVerDetallesCB.setVisible(true);
	}
}
