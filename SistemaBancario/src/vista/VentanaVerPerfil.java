package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Cliente;

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
	private Cliente cliente;

	public VentanaVerPerfil(Cliente cliente) {
		this.cliente = cliente;
		setTitle("Ver perfil");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 418, 312);
		getContentPane().setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(156, 226, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setBounds(32, 79, 115, 14);
			getContentPane().add(lblNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(32, 104, 115, 14);
			getContentPane().add(lblApellidos);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setBounds(32, 129, 115, 14);
			getContentPane().add(lblTelfono);
		}
		{
			lblDireccin = new JLabel("Dirección:");
			lblDireccin.setBounds(32, 154, 115, 14);
			getContentPane().add(lblDireccin);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(32, 179, 115, 14);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setEditable(false);
			txtNombres.setBounds(157, 76, 209, 20);
			getContentPane().add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setEditable(false);
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(157, 101, 209, 20);
			getContentPane().add(txtApellidos);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(157, 126, 209, 20);
			getContentPane().add(txtTelefono);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(157, 151, 209, 20);
			getContentPane().add(txtDireccion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setEditable(false);
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(157, 176, 209, 20);
			getContentPane().add(txtCorreoElectronico);
		}
		{
			lblNewLabel = new JLabel("Perfil");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(153, 25, 96, 23);
			getContentPane().add(lblNewLabel);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	public void MostrarDatos() {
		txtNombres.setText(cliente.getNombres());
		txtApellidos.setText(cliente.getApellidos());
		txtTelefono.setText(""+cliente.getTelefono());
		txtDireccion.setText(cliente.getDireccion());
		txtCorreoElectronico.setText(cliente.getCorreo());		
	}
}
