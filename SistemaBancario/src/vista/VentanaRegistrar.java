package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Empleado;
import repositorio.RepositorioCliente;
import repositorio.RepositorioEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class VentanaRegistrar extends JDialog implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNombres;
	private JLabel lblNewLabel_2;
	private JTextField txtApellidos;
	private JLabel lblNewLabel_3;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_4;
	private JTextField txtDireccion;
	private JTextField txtCorreoElectronico;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNewLabel_5;
	private JPasswordField txtContraseña;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
	private JCheckBox chckbxVerContraseña;
	private JLabel lblNewLabel_6;
	private JTextField txtDNI;

	public VentanaRegistrar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		setTitle("Registrar");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 445, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Registrarse");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(165, 22, 114, 35);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombres:");
			lblNewLabel_1.setBounds(37, 112, 155, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setBounds(204, 105, 200, 25);
			contentPanel.add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Apellidos:");
			lblNewLabel_2.setBounds(37, 148, 155, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(204, 141, 200, 25);
			contentPanel.add(txtApellidos);
		}
		{
			lblNewLabel_3 = new JLabel("Teléfono:");
			lblNewLabel_3.setBounds(37, 182, 150, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(204, 175, 200, 25);
			contentPanel.add(txtTelefono);
		}
		{
			lblNewLabel_4 = new JLabel("Dirección:");
			lblNewLabel_4.setBounds(37, 218, 155, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(204, 211, 200, 25);
			contentPanel.add(txtDireccion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(204, 248, 200, 25);
			contentPanel.add(txtCorreoElectronico);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(37, 255, 155, 14);
			contentPanel.add(lblCorreoElectrnico);
		}
		{
			lblNewLabel_5 = new JLabel("Contraseña:");
			lblNewLabel_5.setBounds(37, 294, 155, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(204, 287, 200, 25);
			txtContraseña.setEchoChar('●');
			contentPanel.add(txtContraseña);
		}
		{
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(this);
			btnRegistrarse.setBounds(53, 366, 150, 35);
			contentPanel.add(btnRegistrarse);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(230, 366, 150, 35);
			contentPanel.add(btnCancelar);
		}
		{
			chckbxVerContraseña = new JCheckBox("Ver contraseña");
			chckbxVerContraseña.addActionListener(this);
			chckbxVerContraseña.setBounds(204, 318, 200, 23);
			contentPanel.add(chckbxVerContraseña);
		}
		{
			lblNewLabel_6 = new JLabel("DNI:");
			lblNewLabel_6.setBounds(37, 76, 155, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setColumns(10);
			txtDNI.setBounds(204, 69, 200, 25);
			contentPanel.add(txtDNI);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chckbxVerContraseña) {
			do_chckbxVerContraseña_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarse) {
			do_btnRegistrarse_actionPerformed(e);
		}
	}
	protected void do_btnRegistrarse_actionPerformed(ActionEvent e) {
		try {
			String dni = txtDNI.getText().trim();
			String nombres = txtNombres.getText().trim();
			String apellidos = txtApellidos.getText().trim();
			String telefono = txtTelefono.getText().trim();
			String direccion = txtDireccion.getText().trim();
			String correoElectronico = txtCorreoElectronico.getText().trim();
			char[] contraseña = txtContraseña.getPassword();
			if(dni.isEmpty() || 
					nombres.isEmpty() || 
					apellidos.isEmpty() || 
					telefono.isEmpty() ||
					direccion.isEmpty() ||
					correoElectronico.isEmpty() || 
					contraseña.length == 0) {
				JOptionPane.showMessageDialog(this, "No debe dejar campos vacíos.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(!correoElectronico.contains("@")) {
				JOptionPane.showMessageDialog(this, "Correo electrónico inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(telefono.length() != 9) {
				JOptionPane.showMessageDialog(this, "Número de teléfono inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(dni.length() != 8) {
				JOptionPane.showMessageDialog(this, "DNI inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(RepositorioEmpleado.buscarEmpleado(correoElectronico) != null ||
					RepositorioCliente.buscarCliente(correoElectronico) != null) {
				JOptionPane.showMessageDialog(this, "Correo electrónico ya registrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(RepositorioEmpleado.buscarEmpleadoPorDni(dni) != null ||
					RepositorioCliente.buscarClientePorDni(dni) != null) {
				JOptionPane.showMessageDialog(this, "DNI ya registrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(correoElectronico.contains("@empleado")) {
				Empleado empleado= new Empleado(dni, nombres, apellidos, telefono, direccion, correoElectronico, new String(contraseña));
				RepositorioEmpleado.agregarEmpleado(empleado);
				VentanaMenuEmpleado ventanaMenuEmpleado = new VentanaMenuEmpleado(ventanaPrincipal, empleado);
				ventanaMenuEmpleado.setVisible(true);
			}else {
				Cliente cliente = new Cliente(dni, nombres, apellidos, telefono, direccion, correoElectronico, new String(contraseña));
				RepositorioCliente.agregarCliente(cliente);
				VentanaMenu menu = new VentanaMenu(ventanaPrincipal, cliente);
				menu.setVisible(true);
			}
			ventanaPrincipal.dispose();
			limpiarCampos();
			dispose();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(this, "Error: "+error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void limpiarCampos() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtCorreoElectronico.setText("");
		txtContraseña.setText("");
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		limpiarCampos();
		dispose();
	}
	protected void do_chckbxVerContraseña_actionPerformed(ActionEvent e) {
		if(chckbxVerContraseña.isSelected()) txtContraseña.setEchoChar((char) 0);
		else txtContraseña.setEchoChar('●');
	}
}
