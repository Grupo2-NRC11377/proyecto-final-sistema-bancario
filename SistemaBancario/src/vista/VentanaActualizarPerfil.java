package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class VentanaActualizarPerfil extends JDialog implements ActionListener {
	
	private Persona persona;

	private static final long serialVersionUID = 1L;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelfono;
	private JLabel lblDireccin;
	private JLabel lblCorreoElectrnico;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElectronico;
	private JLabel lblNewLabel;
	private JTextField txtDni;
	private JLabel lblDni;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public VentanaActualizarPerfil(Persona persona) {
		getContentPane().setBackground(new Color(255, 255, 255));
		this.persona = persona;
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Actualizar perfil");
		setBounds(100, 100, 470, 480);
		getContentPane().setLayout(null);
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setForeground(new Color(90, 90, 90));
			lblNombres.setFont(new Font("Arial", Font.BOLD, 13));
			lblNombres.setBounds(50, 155, 60, 16);
			getContentPane().add(lblNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setForeground(new Color(90, 90, 90));
			lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
			lblApellidos.setBounds(50, 191, 63, 16);
			getContentPane().add(lblApellidos);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setForeground(new Color(90, 90, 90));
			lblTelfono.setFont(new Font("Arial", Font.BOLD, 13));
			lblTelfono.setBounds(50, 227, 60, 16);
			getContentPane().add(lblTelfono);
		}
		{
			lblDireccin = new JLabel("Dirección:");
			lblDireccin.setForeground(new Color(90, 90, 90));
			lblDireccin.setFont(new Font("Arial", Font.BOLD, 13));
			lblDireccin.setBounds(50, 263, 64, 16);
			getContentPane().add(lblDireccin);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setForeground(new Color(90, 90, 90));
			lblCorreoElectrnico.setFont(new Font("Arial", Font.BOLD, 13));
			lblCorreoElectrnico.setBounds(50, 299, 122, 16);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setText((String) null);
			txtNombres.setForeground(new Color(90, 90, 90));
			txtNombres.setFont(new Font("Arial", Font.PLAIN, 13));
			txtNombres.setColumns(10);
			txtNombres.setBackground(Color.WHITE);
			txtNombres.setBounds(200, 151, 200, 25);
			getContentPane().add(txtNombres);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setText((String) null);
			txtApellidos.setForeground(new Color(90, 90, 90));
			txtApellidos.setFont(new Font("Arial", Font.PLAIN, 13));
			txtApellidos.setColumns(10);
			txtApellidos.setBackground(Color.WHITE);
			txtApellidos.setBounds(200, 187, 200, 25);
			getContentPane().add(txtApellidos);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setText((String) null);
			txtTelefono.setForeground(new Color(90, 90, 90));
			txtTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
			txtTelefono.setColumns(10);
			txtTelefono.setBackground(Color.WHITE);
			txtTelefono.setBounds(200, 223, 200, 25);
			getContentPane().add(txtTelefono);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setText((String) null);
			txtDireccion.setForeground(new Color(90, 90, 90));
			txtDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
			txtDireccion.setColumns(10);
			txtDireccion.setBackground(Color.WHITE);
			txtDireccion.setBounds(200, 259, 200, 25);
			getContentPane().add(txtDireccion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setText((String) null);
			txtCorreoElectronico.setForeground(new Color(90, 90, 90));
			txtCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 13));
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBackground(Color.WHITE);
			txtCorreoElectronico.setBounds(200, 295, 200, 25);
			getContentPane().add(txtCorreoElectronico);
		}
		{
			lblNewLabel = new JLabel("Perfil");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(238, 52, 37));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(195, 49, 63, 30);
			getContentPane().add(lblNewLabel);
		}
		{
			txtDni = new JTextField();
			txtDni.setText((String) null);
			txtDni.setForeground(new Color(90, 90, 90));
			txtDni.setFont(new Font("Arial", Font.PLAIN, 13));
			txtDni.setColumns(10);
			txtDni.setBackground(Color.WHITE);
			txtDni.setBounds(200, 115, 200, 25);
			getContentPane().add(txtDni);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setForeground(new Color(90, 90, 90));
			lblDni.setFont(new Font("Arial", Font.BOLD, 13));
			lblDni.setBounds(50, 119, 26, 16);
			getContentPane().add(lblDni);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(new Color(255, 255, 255));
			btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
			btnGuardar.setBackground(new Color(238, 52, 37));
			btnGuardar.setBounds(50, 358, 150, 35);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(new Color(90, 90, 90));
			btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(250, 358, 150, 35);
			getContentPane().add(btnCancelar);
		}
		mostrarDatos();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}
	private void mostrarDatos() {
		txtDni.setText(persona.getDni());
		txtNombres.setText(persona.getNombres());
		txtApellidos.setText(persona.getApellidos());
		txtTelefono.setText(persona.getTelefono());
		txtDireccion.setText(persona.getDireccion());
		txtCorreoElectronico.setText(persona.getCorreo());
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String dni = txtDni.getText().trim();
		String nombres = txtNombres.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String correo = txtCorreoElectronico.getText().trim();
		if(!dni.isEmpty() && !dni.equals(persona.getDni())) {
			if(RepositorioCliente.buscarClientePorDni(dni) != null ||
				RepositorioEmpleado.buscarEmpleadoPorDni(dni) != null) {
				JOptionPane.showMessageDialog(this,"DNI ya registrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else if(dni.length() != 8) {
				JOptionPane.showMessageDialog(this, "DNI inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			persona.setDni(dni);
		}
		if(!nombres.isEmpty() && !nombres.equalsIgnoreCase(persona.getNombres())) persona.setNombres(nombres);
		if(!apellidos.isEmpty() && !apellidos.equalsIgnoreCase(persona.getApellidos())) persona.setApellidos(apellidos);
		if(!telefono.isEmpty() && !telefono.equals(persona.getTelefono())) {
			if(telefono.length() != 9) {
				JOptionPane.showMessageDialog(this, "Número de teléfono inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			persona.setTelefono(telefono);
		}
		if(!direccion.isEmpty() && !direccion.equalsIgnoreCase(persona.getDireccion())) persona.setDireccion(direccion);
		if(!correo.isEmpty() && !correo.equalsIgnoreCase(persona.getCorreo())) {
			if(RepositorioCliente.buscarCliente(correo) != persona ||
				RepositorioEmpleado.buscarEmpleado(correo) != persona) {
				JOptionPane.showMessageDialog(this,"Correo electrónico ya registrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if(!correo.contains("@")) {
				JOptionPane.showMessageDialog(this, "Correo electrónico inválido.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			persona.setCorreo(correo);
		}
		JOptionPane.showMessageDialog(this,"Datos actualizados correctamente");
	}
}
