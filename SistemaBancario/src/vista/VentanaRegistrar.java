package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import servicio.ServicioCliente;

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

	private VentanaPrincipal ventanaPrincipal = null;
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

	public VentanaRegistrar(VentanaPrincipal ventanaPrincipal) {
		setTitle("Registrar");
		this.ventanaPrincipal = ventanaPrincipal;
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 410, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Registrarse");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(140, 22, 114, 35);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombres:");
			lblNewLabel_1.setBounds(34, 76, 114, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setBounds(160, 71, 200, 25);
			contentPanel.add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Apellidos:");
			lblNewLabel_2.setBounds(34, 112, 114, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(160, 107, 200, 25);
			contentPanel.add(txtApellidos);
		}
		{
			lblNewLabel_3 = new JLabel("Teléfono:");
			lblNewLabel_3.setBounds(34, 146, 114, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(160, 141, 200, 25);
			contentPanel.add(txtTelefono);
		}
		{
			lblNewLabel_4 = new JLabel("Dirección:");
			lblNewLabel_4.setBounds(34, 182, 114, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(160, 177, 200, 25);
			contentPanel.add(txtDireccion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(160, 214, 200, 25);
			contentPanel.add(txtCorreoElectronico);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(34, 219, 114, 14);
			contentPanel.add(lblCorreoElectrnico);
		}
		{
			lblNewLabel_5 = new JLabel("Contraseña:");
			lblNewLabel_5.setBounds(34, 258, 114, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(160, 253, 200, 25);
			txtContraseña.setEchoChar('●');
			contentPanel.add(txtContraseña);
		}
		{
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(this);
			btnRegistrarse.setBounds(34, 330, 150, 35);
			contentPanel.add(btnRegistrarse);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(211, 330, 150, 35);
			contentPanel.add(btnCancelar);
		}
		{
			chckbxVerContraseña = new JCheckBox("Ver contraseña");
			chckbxVerContraseña.addActionListener(this);
			chckbxVerContraseña.setBounds(160, 285, 124, 23);
			contentPanel.add(chckbxVerContraseña);
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
			String nombres = txtNombres.getText().trim();
			String apellidos = txtApellidos.getText().trim();
			String telefono = txtTelefono.getText().trim();
			String direccion = txtDireccion.getText().trim();
			String correoElectronico = txtCorreoElectronico.getText().trim();
			char[] contraseña = txtContraseña.getPassword();
			if(nombres.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() ||direccion.isEmpty() ||correoElectronico.isEmpty() || contraseña.length == 0) {
				JOptionPane.showMessageDialog(this, "No debe dejar campos vacíos.");
				return;
			}else if(!correoElectronico.contains("@")) {
				JOptionPane.showMessageDialog(this, "Correo electrónico inválido.");
				return;
			}else if(telefono.length() != 9) {
				JOptionPane.showMessageDialog(this, "Número de teléfono inválido.");
				return;
			}else if(ServicioCliente.buscarCliente(correoElectronico) != null) {
				JOptionPane.showMessageDialog(this, "Correo electrónico ya registrado.");
				return;
			}
			if(ventanaPrincipal != null) ventanaPrincipal.dispose();
			Cliente cliente = new Cliente(nombres, apellidos, Integer.parseInt(telefono), direccion, correoElectronico, new String(contraseña));
			ServicioCliente.agregarCliente(cliente);
			limpiarCampos();
			dispose();
			VentanaMenu menu = new VentanaMenu(ventanaPrincipal);
			menu.setVisible(true);
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(this, "Número de teléfono inválido. Error: "+error.getMessage());
			txtTelefono.setText("");
		}catch (Exception error) {
			JOptionPane.showMessageDialog(this, "Error: "+error.getMessage());
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
