package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Transaccion;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerTransacciones extends JDialog implements ActionListener {
	
	private Cliente cliente;

	private static final long serialVersionUID = 1L;
	private JLabel lblTransacciones;
	private JComboBox<String> cbxTipoTransaccion;
	private JLabel lblTipoOperación;
	private JLabel lblDescripcin;
	private JTextField txtDescripcion;
	private JButton btnFiltrar;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JTable tableTransacciones;
	private DefaultTableModel defaultTableModel;

	public VentanaVerTransacciones(Cliente cliente) {
		this.cliente = cliente;
		
		setTitle("Ver transacciones");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 723, 548);
		getContentPane().setLayout(null);
		{
			lblTransacciones = new JLabel("Transacciones");
			lblTransacciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblTransacciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTransacciones.setBounds(225, 26, 267, 31);
			getContentPane().add(lblTransacciones);
		}
		{
			cbxTipoTransaccion = new JComboBox<String>();
			String[] tiposTransacciones = {"todos", "transferir", "pagar", "retirar", "depositar"};
			for (String tipoTransaccion : tiposTransacciones) {
				cbxTipoTransaccion.addItem(tipoTransaccion);
			}
			cbxTipoTransaccion.setBounds(161, 84, 185, 21);
			getContentPane().add(cbxTipoTransaccion);
		}
		{
			lblTipoOperación = new JLabel("Tipo de transacción:");
			lblTipoOperación.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblTipoOperación.setBounds(22, 87, 129, 13);
			getContentPane().add(lblTipoOperación);
		}
		{
			lblDescripcin = new JLabel("Descripción:");
			lblDescripcin.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblDescripcin.setBounds(379, 87, 129, 13);
			getContentPane().add(lblDescripcin);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(481, 80, 222, 26);
			getContentPane().add(txtDescripcion);
		}
		{
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(this);
			btnFiltrar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			btnFiltrar.setBounds(303, 117, 111, 39);
			getContentPane().add(btnFiltrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 176, 678, 254);
			getContentPane().add(scrollPane);
			{
				tableTransacciones = new JTable();
				tableTransacciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = new String[] {"Id", "Tipo", "Descripción", "Fecha y hora", "Estado", "Monto"};
				defaultTableModel = new DefaultTableModel(columnas, 0) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
		                return false;
		            }
				};
				tableTransacciones.setModel(defaultTableModel);
				scrollPane.setViewportView(tableTransacciones);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			btnCerrar.setBounds(577, 455, 126, 39);
			getContentPane().add(btnCerrar);
		}
		llenarTabla();
	}

	public void actionPerformed(ActionEvent e) {
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
	private void llenarTabla() {
		if(cliente == null) return;
		defaultTableModel.setRowCount(0);
		for (Transaccion transaccion : cliente.getTransacciones()) {
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
	protected void do_btnFiltrar_actionPerformed(ActionEvent e) {
		String tipo = (String) cbxTipoTransaccion.getSelectedItem();
		String descripcion = txtDescripcion.getText().trim();
		defaultTableModel.setRowCount(0);
		boolean filtrarPorTipo = !tipo.equals("todos");
		boolean filtrarPorDescripcion = !descripcion.isEmpty();
		if (!filtrarPorTipo && !filtrarPorDescripcion) {
		    llenarTabla();
		    return;
		}
		for (Transaccion transaccion : cliente.getTransacciones()) {
		    boolean coincideTipo = !filtrarPorTipo || transaccion.getTipo().equals(tipo);
		    boolean coincideDescripcion = !filtrarPorDescripcion || transaccion.getDescripcion().contains(descripcion);
		    if (coincideTipo && coincideDescripcion) {
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
}
