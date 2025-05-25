package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.SimulaciónCuentas;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerTransacciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblHistorialTransacciones;
	private JLabel lblFiltrar;
	private JLabel lblCuenta;
	private JComboBox<String> cboxCuenta;
	private JLabel lblTipoOperación;
	private JComboBox<String> cboxTipoOperación;
	private JButton btnBuscar;
	private JLabel lblResultadoBúsqueda;
	private JScrollPane scrollPane;
	private JTextArea txtResultadoBúsqueda;
	private JButton btnCerrar;
	private JButton btnRefrescar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerTransacciones frame = new VentanaVerTransacciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaVerTransacciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblHistorialTransacciones = new JLabel("Historial de Transacciones");
			lblHistorialTransacciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHistorialTransacciones.setBounds(126, 10, 267, 52);
			contentPane.add(lblHistorialTransacciones);
		}
		{
			lblFiltrar = new JLabel("Filtrar por:");
			lblFiltrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblFiltrar.setBounds(32, 55, 83, 31);
			contentPane.add(lblFiltrar);
		}
		{
			lblCuenta = new JLabel("Cuenta");
			lblCuenta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblCuenta.setBounds(61, 92, 54, 17);
			contentPane.add(lblCuenta);
		}
		{
			cboxCuenta = new JComboBox();
			cboxCuenta.addActionListener(this);
			cboxCuenta.setBounds(125, 90, 83, 21);
			contentPane.add(cboxCuenta);
		}
		{
			lblTipoOperación = new JLabel("Tipo de operación:");
			lblTipoOperación.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblTipoOperación.setBounds(235, 94, 129, 13);
			contentPane.add(lblTipoOperación);
		}
		{
			cboxTipoOperación = new JComboBox();
			cboxTipoOperación.addActionListener(this);
			cboxTipoOperación.setBounds(347, 90, 111, 21);
			contentPane.add(cboxTipoOperación);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnBuscar.setBounds(71, 123, 111, 39);
			contentPane.add(btnBuscar);
		}
		{
			lblResultadoBúsqueda = new JLabel("Resultado de la búsqueda");
			lblResultadoBúsqueda.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblResultadoBúsqueda.setBounds(166, 184, 250, 31);
			contentPane.add(lblResultadoBúsqueda);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 225, 426, 256);
			contentPane.add(scrollPane);
			{
				txtResultadoBúsqueda = new JTextArea();
				scrollPane.setViewportView(txtResultadoBúsqueda);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnCerrar.setBounds(192, 123, 126, 39);
			contentPane.add(btnCerrar);
		}
		{
			btnRefrescar = new JButton("Refrescar");
			btnRefrescar.addActionListener(this);
			btnRefrescar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnRefrescar.setBounds(332, 123, 111, 39);
			contentPane.add(btnRefrescar);
		}
		{
		// Llenar comboBoxes
				cboxCuenta.addItem("Seleccione");
				for (String cuenta : SimulaciónCuentas.obtenerTodasLasCuentas()) {
					cboxCuenta.addItem(cuenta);
				}

				cboxTipoOperación.addItem("Todos");
				cboxTipoOperación.addItem("Transferencia");
				cboxTipoOperación.addItem("Pago");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRefrescar) {
			do_btnRefrescar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		String cuentaSeleccionada = (String) cboxCuenta.getSelectedItem();
	    String tipoSeleccionado = (String) cboxTipoOperación.getSelectedItem();

	    // Validar selección
	    if (cuentaSeleccionada == null || cuentaSeleccionada.equals("Seleccione")) {
	        txtResultadoBúsqueda.setText("Por favor, seleccione una cuenta válida.");
	        return;
	    }
	    if (tipoSeleccionado == null) {
	        txtResultadoBúsqueda.setText("Por favor, seleccione un tipo de operación.");
	        return;
	    }

	    // Obtener todas las transacciones
	    java.util.List<modelo.Transacción> todasTransacciones = modelo.Transacción.obtenerTransacciones();

	    // Filtrar transacciones por cuenta y tipo
	    StringBuilder sb = new StringBuilder();
	    boolean hayResultados = false;

	    for (modelo.Transacción t : todasTransacciones) {
	        // Supongamos que en Transacción agregaste el campo cuenta para filtrar
	        // Si no, deberías añadirlo para filtrar correctamente
	        if (!t.getCuenta().equals(cuentaSeleccionada)) {
	            continue;
	        }

	        if (!tipoSeleccionado.equals("Todos") && !t.getTipoTransacción().equalsIgnoreCase(tipoSeleccionado)) {
	            continue;
	        }

	        hayResultados = true;

	        // Formatear la transacción para mostrarla
	        sb.append(String.format("ID: %d | Tipo: %s | Fecha: %s | Monto: %.2f | Estado: %s\n",
	                t.getIdTransacción(),
	                t.getTipoTransacción(),
	                t.getFechaYhora().toString(),
	                t.getMontoTransacción(),
	                t.getEstadoTransacción()
	        ));
	    }

	    if (!hayResultados) {
	        txtResultadoBúsqueda.setText("No se encontraron transacciones para los filtros seleccionados.");
	    } else {
	        txtResultadoBúsqueda.setText(sb.toString());
	    }
	}

	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnRefrescar_actionPerformed(ActionEvent e) {
		txtResultadoBúsqueda.setText("");
	}
}
