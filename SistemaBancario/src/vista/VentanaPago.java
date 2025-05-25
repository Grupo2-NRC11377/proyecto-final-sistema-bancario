package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import modelo.SimulaciónCuentas;

public class VentanaPago extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCuentaUsar;
	private JComboBox<String> cboxCuentas;
	private JLabel lblSuSaldoDisponible;
	private JTextField txtSaldoDisponible;
	private JLabel lblCuentaDestino;
	private JTextField txtCuentaDestinoPago;
	private JLabel lblMontoPagar;
	private JTextField txtMontoPagar;
	private JScrollPane scrollPane;
	private JButton btnRealizarPago;
	private JButton btnCerrar;
	private JLabel lblNewLabel_3;
	private JTextArea txtConceptoPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPago frame = new VentanaPago();
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
	public VentanaPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nuevo Pago");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(136, 10, 125, 49);
			contentPane.add(lblNewLabel);
		}
		{
			lblCuentaUsar = new JLabel("Seleccione la cuenta a usar:");
			lblCuentaUsar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblCuentaUsar.setBounds(68, 54, 166, 31);
			contentPane.add(lblCuentaUsar);
		}
		{
			cboxCuentas = new JComboBox();
			cboxCuentas.addActionListener(this);
			cboxCuentas.setBounds(232, 59, 63, 21);
			contentPane.add(cboxCuentas);
		}
		{
			lblSuSaldoDisponible = new JLabel("Su saldo disponible es:");
			lblSuSaldoDisponible.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblSuSaldoDisponible.setBounds(68, 82, 166, 31);
			contentPane.add(lblSuSaldoDisponible);
		}
		{
			txtSaldoDisponible = new JTextField();
			txtSaldoDisponible.setEditable(false);
			txtSaldoDisponible.setColumns(10);
			txtSaldoDisponible.setBounds(219, 88, 112, 19);
			contentPane.add(txtSaldoDisponible);
		}
		{
			lblCuentaDestino = new JLabel("Número de cuenta del destino:");
			lblCuentaDestino.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblCuentaDestino.setBounds(32, 122, 166, 31);
			contentPane.add(lblCuentaDestino);
		}
		{
			txtCuentaDestinoPago = new JTextField();
			txtCuentaDestinoPago.setColumns(10);
			txtCuentaDestinoPago.setBounds(205, 128, 144, 19);
			contentPane.add(txtCuentaDestinoPago);
		}
		{
			lblMontoPagar = new JLabel("Monto a pagar:");
			lblMontoPagar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblMontoPagar.setBounds(68, 163, 166, 31);
			contentPane.add(lblMontoPagar);
		}
		{
			txtMontoPagar = new JTextField();
			txtMontoPagar.setColumns(10);
			txtMontoPagar.setBounds(205, 169, 144, 19);
			contentPane.add(txtMontoPagar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 297, 317, 171);
			contentPane.add(scrollPane);
			{
				txtConceptoPago = new JTextArea();
				scrollPane.setViewportView(txtConceptoPago);
			}
		}
		{
			btnRealizarPago = new JButton("Realizar Pago");
			btnRealizarPago.addActionListener(this);
			btnRealizarPago.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnRealizarPago.setBounds(25, 204, 173, 45);
			contentPane.add(btnRealizarPago);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnCerrar.setBounds(223, 204, 126, 45);
			contentPane.add(btnCerrar);
		}
		{
			lblNewLabel_3 = new JLabel("Concepto de pago");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(142, 259, 119, 31);
			contentPane.add(lblNewLabel_3);
		}
		// Cargar cuentas simuladas
				for (String cuenta : SimulaciónCuentas.obtenerTodasLasCuentas()) {
					cboxCuentas.addItem(cuenta);
				}
				if (cboxCuentas.getItemCount() > 0) {
					actualizarSaldoDisponible((String) cboxCuentas.getSelectedItem());
				}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboxCuentas) {
			do_cboxCuentas_actionPerformed(e);
		}
		if (e.getSource() == btnRealizarPago) {
			do_btnRealizarPago_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	
	private void actualizarSaldoDisponible(String cuenta) {
		double saldo = SimulaciónCuentas.obtenerSaldo(cuenta);
		txtSaldoDisponible.setText(String.valueOf(saldo));
	}

	private void realizarPago() {
		String cuentaOrigen = (String) cboxCuentas.getSelectedItem();
		String cuentaDestino = txtCuentaDestinoPago.getText().trim().replaceAll("\\s+", "");
		String montoStr = txtMontoPagar.getText().trim();

		if (cuentaDestino.isEmpty() || montoStr.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Complete todos los campos");
			return;
		}

		if (!SimulaciónCuentas.existeCuenta(cuentaDestino)) {
			JOptionPane.showMessageDialog(this, "La cuenta destino no existe");
			return;
		}

		if (cuentaOrigen.equals(cuentaDestino)) {
			JOptionPane.showMessageDialog(this, "No puede pagar a la misma cuenta");
			return;
		}

		double monto;
		try {
			monto = Double.parseDouble(montoStr);
			if (monto <= 0) throw new NumberFormatException();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
			return;
		}

		if (SimulaciónCuentas.pagar(cuentaOrigen, monto)) {
			JOptionPane.showMessageDialog(this, "Pago realizado con éxito");
			actualizarSaldoDisponible(cuentaOrigen);
			txtConceptoPago.append("Pago de S/ " + monto + " a cuenta " + cuentaDestino + " realizado.\n");
		} else {
			JOptionPane.showMessageDialog(this, "Saldo insuficiente o error en el pago");
		}
	}

	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnRealizarPago_actionPerformed(ActionEvent e) {
		realizarPago();
	}
	protected void do_cboxCuentas_actionPerformed(ActionEvent e) {
		String cuentaSeleccionada = (String) cboxCuentas.getSelectedItem();
		actualizarSaldoDisponible(cuentaSeleccionada);
	}
}
