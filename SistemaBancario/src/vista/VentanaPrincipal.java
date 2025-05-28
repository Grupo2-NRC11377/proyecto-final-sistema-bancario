package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Persona;
import repositorio.RepositorioCliente;
import repositorio.RepositorioEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnIniciarSesion;
	private JTextField txtCorreoElectronico;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNewLabel_1;
	private JButton btnRegistrarse;
	private JPasswordField txtContraseña;
	private JButton btnSalir;
	private JCheckBox chckbxVerContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setTitle("Iniciar sesión");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Bienvenido/a");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(146, 27, 158, 25);
			contentPane.add(lblNewLabel);
		}
		{
			btnIniciarSesion = new JButton("Iniciar Sesión");
			btnIniciarSesion.addActionListener(this);
			btnIniciarSesion.setBounds(125, 199, 200, 35);
			contentPane.add(btnIniciarSesion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setBounds(203, 74, 200, 25);
			contentPane.add(txtCorreoElectronico);
			txtCorreoElectronico.setColumns(10);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(45, 80, 158, 14);
			contentPane.add(lblCorreoElectrnico);
		}
		{
			lblNewLabel_1 = new JLabel("Contraseña:");
			lblNewLabel_1.setBounds(45, 119, 158, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(this);
			btnRegistrarse.setBounds(125, 245, 200, 35);
			contentPane.add(btnRegistrarse);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(203, 113, 200, 25);
			txtContraseña.setEchoChar('●');
			contentPane.add(txtContraseña);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(125, 291, 200, 35);
			contentPane.add(btnSalir);
		}
		{
			chckbxVerContraseña = new JCheckBox("Ver contraseña");
			chckbxVerContraseña.addActionListener(this);
			chckbxVerContraseña.setBounds(203, 143, 200, 23);
			contentPane.add(chckbxVerContraseña);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chckbxVerContraseña) {
			do_chckbxVerContraseña_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarse) {
			do_btnRegistrarse_actionPerformed(e);
		}
		if (e.getSource() == btnIniciarSesion) {
			do_btnIniciarSesion_actionPerformed(e);
		}
	}
	protected void do_btnIniciarSesion_actionPerformed(ActionEvent e) {
		String correoElectronico = txtCorreoElectronico.getText().trim();
		char[] contraseña = txtContraseña.getPassword();
		if(correoElectronico.isEmpty() || 
				contraseña.length == 0) {
			JOptionPane.showMessageDialog(this, "No debe dejar campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}else if(!correoElectronico.contains("@")) {
			JOptionPane.showMessageDialog(this, "Correo electrónico inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Persona persona;
		if(correoElectronico.contains("@empleado.com")) persona = RepositorioEmpleado.buscarEmpleado(correoElectronico, new String(contraseña));
		else persona = RepositorioCliente.buscarCliente(correoElectronico, new String(contraseña));
		if(persona == null) {
			JOptionPane.showMessageDialog(this, "Correo electrónico o contraseña incorrectos. Intente nuevamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(correoElectronico.contains("@empleado.com")) {
			VentanaMenuEmpleado ventanaMenuEmpleado = new VentanaMenuEmpleado(this, (Empleado) persona);
			ventanaMenuEmpleado.setVisible(true);
		}else {
			VentanaMenu menu = new VentanaMenu(this, (Cliente) persona);
			menu.setVisible(true);
		}
		limpiarCampos();
		dispose();
	}
	protected void do_btnRegistrarse_actionPerformed(ActionEvent e) {
		VentanaRegistrar ventanaRegistrar = new VentanaRegistrar(this);
		ventanaRegistrar.setVisible(true);
		limpiarCampos();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	private void limpiarCampos() {
		txtCorreoElectronico.setText("");
		txtContraseña.setText("");
	}
	protected void do_chckbxVerContraseña_actionPerformed(ActionEvent e) {
		if(chckbxVerContraseña.isSelected()) txtContraseña.setEchoChar((char) 0);
		else txtContraseña.setEchoChar('●');
	}
}
