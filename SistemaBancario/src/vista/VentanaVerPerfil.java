package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Persona;

public class VentanaVerPerfil extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnCerrar;
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
	private Persona persona;
	private JTextField txtDni;
	private JLabel lblDni;

	public VentanaVerPerfil(Persona persona) {
		this.persona = persona;
		setTitle("Ver perfil");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 418, 329);
		getContentPane().setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(158, 252, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setBounds(34, 105, 115, 14);
			getContentPane().add(lblNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(34, 130, 115, 14);
			getContentPane().add(lblApellidos);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setBounds(34, 155, 115, 14);
			getContentPane().add(lblTelfono);
		}
		{
			lblDireccin = new JLabel("Dirección:");
			lblDireccin.setBounds(34, 180, 115, 14);
			getContentPane().add(lblDireccin);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(34, 205, 152, 14);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setEditable(false);
			txtNombres.setBounds(181, 102, 209, 20);
			getContentPane().add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setEditable(false);
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(181, 127, 209, 20);
			getContentPane().add(txtApellidos);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(181, 152, 209, 20);
			getContentPane().add(txtTelefono);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(181, 177, 209, 20);
			getContentPane().add(txtDireccion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setEditable(false);
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(181, 202, 209, 20);
			getContentPane().add(txtCorreoElectronico);
		}
		{
			lblNewLabel = new JLabel("Perfil");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(153, 25, 96, 23);
			getContentPane().add(lblNewLabel);
		}
		{
			txtDni = new JTextField();
			txtDni.setEditable(false);
			txtDni.setText((String) null);
			txtDni.setColumns(10);
			txtDni.setBounds(181, 77, 209, 20);
			getContentPane().add(txtDni);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setBounds(34, 80, 135, 14);
			getContentPane().add(lblDni);
		}
		mostrarDatos();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	private void mostrarDatos() {
		txtDni.setText(persona.getDni());
		txtNombres.setText(persona.getNombres());
		txtApellidos.setText(persona.getApellidos());
		txtTelefono.setText(persona.getTelefono());
		txtDireccion.setText(persona.getDireccion());
		txtCorreoElectronico.setText(persona.getCorreo());		
	}
}
