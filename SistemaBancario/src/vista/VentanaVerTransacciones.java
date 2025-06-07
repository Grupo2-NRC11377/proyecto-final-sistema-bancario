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
import java.awt.Color;

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
		getContentPane().setBackground(new Color(255, 255, 255));
		this.cliente = cliente;
		
		setTitle("Ver transacciones");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 820, 563);
		getContentPane().setLayout(null);
		{
			lblTransacciones = new JLabel("Transacciones");
			lblTransacciones.setForeground(new Color(238, 52, 37));
			lblTransacciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblTransacciones.setFont(new Font("Arial", Font.BOLD, 25));
			lblTransacciones.setBounds(314, 50, 175, 30);
			getContentPane().add(lblTransacciones);
		}
		{
			cbxTipoTransaccion = new JComboBox<String>();
			cbxTipoTransaccion.setForeground(new Color(90, 90, 90));
			cbxTipoTransaccion.setFont(new Font("Arial", Font.PLAIN, 13));
			String[] tiposTransacciones = {"todos", "transferir", "pagar", "retirar", "depositar"};
			for (String tipoTransaccion : tiposTransacciones) {
				cbxTipoTransaccion.addItem(tipoTransaccion);
			}
			cbxTipoTransaccion.setBounds(200, 116, 200, 25);
			getContentPane().add(cbxTipoTransaccion);
		}
		{
			lblTipoOperación = new JLabel("Tipo de transacción:");
			lblTipoOperación.setForeground(new Color(90, 90, 90));
			lblTipoOperación.setFont(new Font("Arial", Font.BOLD, 13));
			lblTipoOperación.setBounds(50, 120, 129, 16);
			getContentPane().add(lblTipoOperación);
		}
		{
			lblDescripcin = new JLabel("Descripción:");
			lblDescripcin.setForeground(new Color(90, 90, 90));
			lblDescripcin.setFont(new Font("Arial", Font.BOLD, 13));
			lblDescripcin.setBounds(445, 120, 78, 16);
			getContentPane().add(lblDescripcin);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setForeground(new Color(90, 90, 90));
			txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(550, 116, 200, 25);
			getContentPane().add(txtDescripcion);
		}
		{
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.setBackground(new Color(238, 52, 37));
			btnFiltrar.setForeground(new Color(255, 255, 255));
			btnFiltrar.addActionListener(this);
			btnFiltrar.setFont(new Font("Arial", Font.BOLD, 13));
			btnFiltrar.setBounds(327, 160, 150, 35);
			getContentPane().add(btnFiltrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(50, 220, 700, 200);
			getContentPane().add(scrollPane);
			{
				tableTransacciones = new JTable();
				tableTransacciones.setForeground(new Color(90, 90, 90));
				tableTransacciones.setFont(new Font("Arial", Font.PLAIN, 13));
				tableTransacciones.setBackground(new Color(255, 255, 255));
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
			btnCerrar.setBackground(new Color(255, 255, 255));
			btnCerrar.setForeground(new Color(90, 90, 90));
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Arial", Font.BOLD, 13));
			btnCerrar.setBounds(600, 440, 150, 35);
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
