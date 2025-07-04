package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Persona;
import repositorio.RepositorioCliente;
import repositorio.RepositorioEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		getContentPane().setBackground(new Color(255, 255, 255));
		this.persona = persona;
		
		setTitle("Cambiar contraseña");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 470, 370);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Contraseña");
			lblNewLabel.setForeground(new Color(238, 52, 37));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
			lblNewLabel.setBounds(158, 50, 137, 30);
			getContentPane().add(lblNewLabel);
		}
		{
			lblContraseaAnterior = new JLabel("Contraseña actual:");
			lblContraseaAnterior.setBackground(new Color(255, 255, 255));
			lblContraseaAnterior.setForeground(new Color(90, 90, 90));
			lblContraseaAnterior.setFont(new Font("Arial", Font.BOLD, 13));
			lblContraseaAnterior.setBounds(50, 124, 119, 16);
			getContentPane().add(lblContraseaAnterior);
		}
		{
			txtContraseñaActual = new JTextField();
			txtContraseñaActual.setBackground(new Color(255, 255, 255));
			txtContraseñaActual.setForeground(new Color(90, 90, 90));
			txtContraseñaActual.setFont(new Font("Arial", Font.PLAIN, 13));
			txtContraseñaActual.setColumns(10);
			txtContraseñaActual.setBounds(200, 120, 200, 25);
			getContentPane().add(txtContraseñaActual);
		}
		{
			lblNuevaContrasea = new JLabel("Nueva contraseña:");
			lblNuevaContrasea.setBackground(new Color(255, 255, 255));
			lblNuevaContrasea.setForeground(new Color(90, 90, 90));
			lblNuevaContrasea.setFont(new Font("Arial", Font.BOLD, 13));
			lblNuevaContrasea.setBounds(50, 160, 118, 16);
			getContentPane().add(lblNuevaContrasea);
		}
		{
			txtNuevaContreña = new JTextField();
			txtNuevaContreña.setBackground(new Color(255, 255, 255));
			txtNuevaContreña.setForeground(new Color(90, 90, 90));
			txtNuevaContreña.setFont(new Font("Arial", Font.PLAIN, 13));
			txtNuevaContreña.setColumns(10);
			txtNuevaContreña.setBounds(200, 156, 200, 25);
			getContentPane().add(txtNuevaContreña);
		}
		{
			lblRepetirContrasea = new JLabel("Repetir contraseña:");
			lblRepetirContrasea.setBackground(new Color(255, 255, 255));
			lblRepetirContrasea.setForeground(new Color(90, 90, 90));
			lblRepetirContrasea.setFont(new Font("Arial", Font.BOLD, 13));
			lblRepetirContrasea.setBounds(50, 196, 124, 16);
			getContentPane().add(lblRepetirContrasea);
		}
		{
			txtRepetirContraseña = new JTextField();
			txtRepetirContraseña.setBackground(new Color(255, 255, 255));
			txtRepetirContraseña.setForeground(new Color(90, 90, 90));
			txtRepetirContraseña.setFont(new Font("Arial", Font.PLAIN, 13));
			txtRepetirContraseña.setColumns(10);
			txtRepetirContraseña.setBounds(200, 192, 200, 25);
			getContentPane().add(txtRepetirContraseña);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBackground(new Color(238, 52, 37));
			btnGuardar.setForeground(new Color(255, 255, 255));
			btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(50, 248, 150, 35);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(new Color(90, 90, 90));
			btnCancelar.setBackground(new Color(255, 255, 255));
			btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(250, 248, 150, 35);
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
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String contraseñaActual = txtContraseñaActual.getText();
		String nuevaContraseña = txtNuevaContreña.getText();
		String repetirContraseña = txtRepetirContraseña.getText();
		if (contraseñaActual.isEmpty() || 
				nuevaContraseña.isEmpty() || 
				repetirContraseña.isEmpty()){
			JOptionPane.showMessageDialog(this, "Los campos no deben estar vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (!contraseñaActual.equals(persona.getContraseña())) {
			JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta, vuelva a intentarlo.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (!nuevaContraseña.equals(repetirContraseña)) {
			JOptionPane.showMessageDialog(this, "Las nuevas contraseñas no coinciden.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		persona.setContraseña(repetirContraseña);
		if(persona.getCorreo().contains("@empleado")) RepositorioEmpleado.actualizarEmpleado((Empleado) persona);
		else RepositorioCliente.actualizarCliente((Cliente) persona);
		JOptionPane.showMessageDialog(this, "¡La contraseña fue cambiada correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
}
