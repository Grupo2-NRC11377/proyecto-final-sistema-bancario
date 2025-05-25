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
import javax.swing.JCheckBox;

public class VentanaCambiarContraseña extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContraseñaAnterior;
	private JLabel lblNuevaContraseña;
	private JLabel lblRepetirContraseña;
	private JTextField txtContraseñaAnterior;
	private JTextField txtNuevaContraseña;
	private JTextField txtRepetirContraseña;
	private JButton btnCambiarContraseña;
	private Cliente cliente;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaCambiarContraseña(Cliente cliente) {
		this.cliente = cliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Contraseña");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(147, 13, 132, 39);
			contentPane.add(lblNewLabel);
		}
		{
			lblContraseñaAnterior = new JLabel("Contraseña anterior:");
			lblContraseñaAnterior.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblContraseñaAnterior.setBounds(25, 61, 117, 21);
			contentPane.add(lblContraseñaAnterior);
		}
		{
			lblNuevaContraseña = new JLabel("Nueva contraseña:");
			lblNuevaContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNuevaContraseña.setBounds(25, 92, 117, 21);
			contentPane.add(lblNuevaContraseña);
		}
		{
			lblRepetirContraseña = new JLabel("Repetir nueva contraseña:");
			lblRepetirContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblRepetirContraseña.setBounds(25, 123, 145, 21);
			contentPane.add(lblRepetirContraseña);
		}
		{
			txtContraseñaAnterior = new JTextField();
			txtContraseñaAnterior.setBounds(201, 62, 169, 19);
			contentPane.add(txtContraseñaAnterior);
			txtContraseñaAnterior.setColumns(10);
		}
		{
			txtNuevaContraseña = new JTextField();
			txtNuevaContraseña.setColumns(10);
			txtNuevaContraseña.setBounds(201, 93, 169, 19);
			contentPane.add(txtNuevaContraseña);
		}
		{
			txtRepetirContraseña = new JTextField();
			txtRepetirContraseña.setColumns(10);
			txtRepetirContraseña.setBounds(201, 124, 169, 19);
			contentPane.add(txtRepetirContraseña);
		}
		{
			btnCambiarContraseña = new JButton("Cambiar Contraseña");
			btnCambiarContraseña.addActionListener(this);
			btnCambiarContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			btnCambiarContraseña.setBounds(49, 165, 159, 39);
			contentPane.add(btnCambiarContraseña);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			btnCerrar.setBounds(233, 165, 103, 39);
			contentPane.add(btnCerrar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnCambiarContraseña) {
			do_btnCambiarContraseña_actionPerformed(e);
		}
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
