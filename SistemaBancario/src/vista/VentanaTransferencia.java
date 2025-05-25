package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.SimulaciónCuentas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class VentanaTransferencia extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMontoTransferencia;
	private JTextField txtNúmeroCuentaTransferencia;
	private JButton btnRealizarTransferencia;
	private JComboBox<String> cboxCuentas;
	private JLabel lblCuentaUsar;
	private JLabel lblSuSaldoDisponible;
	private JTextField txtSaldoDisponibleTransferencia;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea txtConceptoTransferencia;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTransferencia frame = new VentanaTransferencia();
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
	public VentanaTransferencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransferencia = new JLabel("Nueva Transferencia");
		lblTransferencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTransferencia.setBounds(115, 10, 229, 59);
		contentPane.add(lblTransferencia);
		
		btnRealizarTransferencia = new JButton("Realizar Transferemcia");
		btnRealizarTransferencia.addActionListener(this);
		btnRealizarTransferencia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRealizarTransferencia.setBounds(47, 213, 173, 45);
		contentPane.add(btnRealizarTransferencia);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el monto a transferir:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(47, 131, 166, 31);
		contentPane.add(lblNewLabel_1);
		
		txtMontoTransferencia = new JTextField();
		txtMontoTransferencia.setBounds(223, 137, 144, 19);
		contentPane.add(txtMontoTransferencia);
		txtMontoTransferencia.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese el número de cuenta:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(47, 172, 166, 31);
		contentPane.add(lblNewLabel_1_1);
		
		txtNúmeroCuentaTransferencia = new JTextField();
		txtNúmeroCuentaTransferencia.setColumns(10);
		txtNúmeroCuentaTransferencia.setBounds(223, 178, 144, 19);
		contentPane.add(txtNúmeroCuentaTransferencia);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCerrar.setBounds(233, 213, 126, 45);
		contentPane.add(btnCerrar);
		{
			cboxCuentas = new JComboBox();
			cboxCuentas.addActionListener(this);
			cboxCuentas.setBounds(227, 64, 89, 21);
			contentPane.add(cboxCuentas);
		}
		{
			lblCuentaUsar = new JLabel("Seleccione la cuenta a usar:");
			lblCuentaUsar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblCuentaUsar.setBounds(90, 59, 166, 31);
			contentPane.add(lblCuentaUsar);
		}
		{
			lblSuSaldoDisponible = new JLabel("Su saldo disponible es:");
			lblSuSaldoDisponible.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblSuSaldoDisponible.setBounds(75, 90, 166, 31);
			contentPane.add(lblSuSaldoDisponible);
		}
		{
			txtSaldoDisponibleTransferencia = new JTextField();
			txtSaldoDisponibleTransferencia.setEditable(false);
			txtSaldoDisponibleTransferencia.setColumns(10);
			txtSaldoDisponibleTransferencia.setBounds(204, 95, 112, 19);
			contentPane.add(txtSaldoDisponibleTransferencia);
		}
		{
			lblNewLabel = new JLabel("Concepto de transferencia");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel.setBounds(137, 268, 153, 31);
			contentPane.add(lblNewLabel);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 298, 319, 146);
			contentPane.add(scrollPane);
			{
				txtConceptoTransferencia = new JTextArea();
				scrollPane.setViewportView(txtConceptoTransferencia);
			}
		}
				// Poblar combo box con cuentas simuladas
				for (String cuenta : SimulaciónCuentas.obtenerTodasLasCuentas()) {
					cboxCuentas.addItem(cuenta);
				}

				// Mostrar saldo inicial de la primera cuenta
				if (cboxCuentas.getItemCount() > 0) {
					actualizarSaldoDisponible((String) cboxCuentas.getSelectedItem());
				}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboxCuentas) {
			do_cboxCuentas_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnRealizarTransferencia) {
			do_btnRealizarTransferencia_actionPerformed(e);
		}
	}
	
	private void actualizarSaldoDisponible(String cuenta) {
		double saldo = SimulaciónCuentas.obtenerSaldo(cuenta);
		txtSaldoDisponibleTransferencia.setText(String.valueOf(saldo));
	}

	private void realizarTransferencia() {
		String cuentaOrigen = (String) cboxCuentas.getSelectedItem();
		String cuentaDestino = txtNúmeroCuentaTransferencia.getText().trim();
		String montoStr = txtMontoTransferencia.getText().trim();

		if (cuentaDestino.isEmpty() || montoStr.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Complete todos los campos");
			return;
		}

		if (!SimulaciónCuentas.existeCuenta(cuentaDestino)) {
			JOptionPane.showMessageDialog(this, "La cuenta destino no existe");
			return;
		}

		if (cuentaOrigen.equals(cuentaDestino)) {
			JOptionPane.showMessageDialog(this, "No puede transferir a la misma cuenta");
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

		if (SimulaciónCuentas.transferir(cuentaOrigen, cuentaDestino, monto)) {
			JOptionPane.showMessageDialog(this, "Transferencia realizada con éxito");
			actualizarSaldoDisponible(cuentaOrigen);
			txtConceptoTransferencia.append("Transferencia de S/ " + monto + " a cuenta " + cuentaDestino + " realizada.\n");
		} else {
			JOptionPane.showMessageDialog(this, "Saldo insuficiente o error en la transferencia");
		}
	}
	protected void do_btnRealizarTransferencia_actionPerformed(ActionEvent e) {
		realizarTransferencia();
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_cboxCuentas_actionPerformed(ActionEvent e) {
		String cuentaSeleccionada = (String) cboxCuentas.getSelectedItem();
		actualizarSaldoDisponible(cuentaSeleccionada);
	}
}
