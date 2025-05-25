package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCambiarContraseña extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtContraseñaAnterior;
	private JTextField txtNuevaContraseña;
	private JTextField txtRepetirContraseña;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaCambiarContraseña(Cliente cliente) {
		this.cliente = cliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(162, 10, 123, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblContraseñaAnterior = new JLabel("Contraseña anterior");
		lblContraseñaAnterior.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblContraseñaAnterior.setBounds(48, 72, 123, 21);
		contentPane.add(lblContraseñaAnterior);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNuevaContrasea.setBounds(48, 103, 123, 21);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblRepetirNuevaContrasea = new JLabel("Repetir nueva contraseña");
		lblRepetirNuevaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRepetirNuevaContrasea.setBounds(48, 134, 142, 21);
		contentPane.add(lblRepetirNuevaContrasea);
		
		txtContraseñaAnterior = new JTextField();
		txtContraseñaAnterior.setBounds(224, 73, 164, 19);
		contentPane.add(txtContraseñaAnterior);
		txtContraseñaAnterior.setColumns(10);
		
		txtNuevaContraseña = new JTextField();
		txtNuevaContraseña.setColumns(10);
		txtNuevaContraseña.setBounds(224, 104, 164, 19);
		contentPane.add(txtNuevaContraseña);
		
		txtRepetirContraseña = new JTextField();
		txtRepetirContraseña.setColumns(10);
		txtRepetirContraseña.setBounds(224, 135, 164, 19);
		contentPane.add(txtRepetirContraseña);
		
		JButton btnCambiarContraseña = new JButton("Cambiar contraseña");
		btnCambiarContraseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCambiarContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCambiarContraseña.setBounds(64, 177, 154, 36);
		contentPane.add(btnCambiarContraseña);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCerrar.setBounds(249, 177, 103, 36);
		contentPane.add(btnCerrar);
	}
	
	protected void do_btnCambiarContraseña_actionPerformed(ActionEvent e) {
		String ContraAnterior = txtContraseñaAnterior.getText();
		String NuevaContra = txtNuevaContraseña.getText();
		String RepetirContra = txtRepetirContraseña.getText();
		
		if (ContraAnterior.isEmpty() || NuevaContra.isEmpty() || RepetirContra.isEmpty()){
			JOptionPane.showMessageDialog(this, "Los campos no deben estar vacíos");
		}
		else if (!ContraAnterior.equals(cliente.getContraseña())) {
			JOptionPane.showMessageDialog(this, "La contraseña anterior es incorrecta, vuelva a intentarlo");
			return;
		}
		else if (!NuevaContra.equals(RepetirContra)) {
			JOptionPane.showMessageDialog(this, "Las nuevas contraseñas no coinciden");
			return;
		}
		else {
			cliente.setContraseña(NuevaContra);
			JOptionPane.showMessageDialog(this, "¡Contraseña cambiada correctamente!");
			Limpiar();
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	void Limpiar() {
		txtContraseñaAnterior.setText("");
		txtNuevaContraseña.setText("");
		txtRepetirContraseña.setText("");
	}
}
