package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCambiarContraseña extends JDialog implements ActionListener {

	private Persona persona;
	
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblContraseaAnterior;
	private JTextField txtContraseñaActual;
	private JLabel lblNuevaContrasea;
	private JTextField txtNuevaContreña;
	private JLabel lblRepetirContrasea;
	private JTextField txtRepetirContraseña;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public VentanaCambiarContraseña(Persona persona) {
		this.persona = persona;
		
		setTitle("Cambiar contraseña");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 448, 276);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Cambiar contraseña");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(112, 33, 236, 25);
			getContentPane().add(lblNewLabel);
		}
		{
			lblContraseaAnterior = new JLabel("Contraseña actual:");
			lblContraseaAnterior.setBounds(38, 86, 164, 14);
			getContentPane().add(lblContraseaAnterior);
		}
		{
			txtContraseñaActual = new JTextField();
			txtContraseñaActual.setColumns(10);
			txtContraseñaActual.setBounds(203, 83, 209, 20);
			getContentPane().add(txtContraseñaActual);
		}
		{
			lblNuevaContrasea = new JLabel("Nueva contraseña:");
			lblNuevaContrasea.setBounds(38, 111, 164, 14);
			getContentPane().add(lblNuevaContrasea);
		}
		{
			txtNuevaContreña = new JTextField();
			txtNuevaContreña.setColumns(10);
			txtNuevaContreña.setBounds(203, 108, 209, 20);
			getContentPane().add(txtNuevaContreña);
		}
		{
			lblRepetirContrasea = new JLabel("Repetir contraseña:");
			lblRepetirContrasea.setBounds(38, 136, 164, 14);
			getContentPane().add(lblRepetirContrasea);
		}
		{
			txtRepetirContraseña = new JTextField();
			txtRepetirContraseña.setColumns(10);
			txtRepetirContraseña.setBounds(203, 133, 209, 20);
			getContentPane().add(txtRepetirContraseña);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(88, 187, 89, 23);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(240, 187, 89, 23);
			getContentPane().add(btnCancelar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	private void limpiar() {
		txtContraseñaActual.setText("");
		txtNuevaContreña.setText("");
		txtRepetirContraseña.setText("");
	}

	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String contraseñaActual = txtContraseñaActual.getText();
		String nuevaContraseña = txtNuevaContreña.getText();
		String repetirContraseña = txtRepetirContraseña.getText();
		
		if (contraseñaActual.isEmpty() || nuevaContraseña.isEmpty() || repetirContraseña.isEmpty()){
			JOptionPane.showMessageDialog(this, "Los campos no deben estar vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (!contraseñaActual.equals(persona.getContraseña())) {
			JOptionPane.showMessageDialog(this, "La contraseña anterior es incorrecta, vuelva a intentarlo.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (!nuevaContraseña.equals(repetirContraseña)) {
			JOptionPane.showMessageDialog(this, "Las nuevas contraseñas no coinciden.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else {
			persona.setContraseña(repetirContraseña);
			JOptionPane.showMessageDialog(this, "¡Contraseña fue cambiada correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
			limpiar();
		}

	}
}
