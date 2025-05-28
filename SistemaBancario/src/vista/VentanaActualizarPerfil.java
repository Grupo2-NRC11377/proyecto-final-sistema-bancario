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

public class VentanaActualizarPerfil extends JDialog implements ActionListener {
	
	private Persona persona;

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElectronico;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblDni;
	private JTextField txtDni;

	public VentanaActualizarPerfil(Persona persona) {
		this.persona = persona;
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Actualizar perfil");
		setBounds(100, 100, 426, 345);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Perfil");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(159, 27, 107, 25);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNombres = new JLabel("Nombres:");
			lblNombres.setBounds(33, 112, 135, 14);
			getContentPane().add(lblNombres);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setColumns(10);
			txtNombres.setBounds(180, 109, 209, 20);
			getContentPane().add(txtNombres);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(33, 137, 135, 14);
			getContentPane().add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(180, 134, 209, 20);
			getContentPane().add(txtApellidos);
		}
		{
			JLabel lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setBounds(33, 162, 135, 14);
			getContentPane().add(lblTelfono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(180, 159, 209, 20);
			getContentPane().add(txtTelefono);
		}
		{
			JLabel lblDireccin = new JLabel("Dirección:");
			lblDireccin.setBounds(33, 187, 135, 14);
			getContentPane().add(lblDireccin);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(180, 184, 209, 20);
			getContentPane().add(txtDireccion);
		}
		{
			JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(33, 212, 138, 14);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(180, 209, 209, 20);
			getContentPane().add(txtCorreoElectronico);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(242, 257, 89, 23);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(90, 257, 89, 23);
			getContentPane().add(btnGuardar);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setBounds(33, 83, 135, 14);
			getContentPane().add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setText((String) null);
			txtDni.setColumns(10);
			txtDni.setBounds(180, 80, 209, 20);
			getContentPane().add(txtDni);
		}
		mostrarDatos();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
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
