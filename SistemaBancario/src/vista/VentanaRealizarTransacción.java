package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class VentanaRealizarTransacción extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmTransferencia;
	private JMenuItem mntmPago;
	private JMenuBar menuBar;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRealizarTransacción frame = new VentanaRealizarTransacción();
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
	public VentanaRealizarTransacción() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Qué operación desea realizar?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(73, 10, 315, 65);
		contentPane.add(lblNewLabel);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(150, 72, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		menuBar.add(mnOperaciones);
		
		mntmTransferencia = new JMenuItem("Transferencia");
		mntmTransferencia.addActionListener(this);
		mnOperaciones.add(mntmTransferencia);
		
		mntmPago = new JMenuItem("Pago");
		mntmPago.addActionListener(this);
		mnOperaciones.add(mntmPago);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(this);
		btnRegresar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRegresar.setBounds(150, 154, 101, 35);
		contentPane.add(btnRegresar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(e);
		}
		if (e.getSource() == mntmPago) {
			do_mntmPago_actionPerformed(e);
		}
		if (e.getSource() == mntmTransferencia) {
			do_mntmTransferencia_actionPerformed(e);
		}
	}
	protected void do_mntmTransferencia_actionPerformed(ActionEvent e) {
		VentanaTransferencia ventanaTransferencia = new VentanaTransferencia();
		ventanaTransferencia.setVisible(true);
	}
	protected void do_mntmPago_actionPerformed(ActionEvent e) {
		VentanaPago ventanaPago = new VentanaPago();
		ventanaPago.setVisible(true);
	}
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
