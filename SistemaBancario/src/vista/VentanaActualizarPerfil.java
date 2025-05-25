package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaActualizarPerfil extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElectronico;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private Cliente cliente;

	public VentanaActualizarPerfil(Cliente cliente) {
		this.cliente = cliente;
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Actualizar perfil");
		setBounds(100, 100, 426, 315);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Perfil");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(151, 27, 107, 25);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNombres = new JLabel("Nombres:");
			lblNombres.setBounds(34, 80, 115, 14);
			getContentPane().add(lblNombres);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setColumns(10);
			txtNombres.setBounds(159, 77, 209, 20);
			getContentPane().add(txtNombres);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(34, 105, 115, 14);
			getContentPane().add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(159, 102, 209, 20);
			getContentPane().add(txtApellidos);
		}
		{
			JLabel lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setBounds(34, 130, 115, 14);
			getContentPane().add(lblTelfono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(159, 127, 209, 20);
			getContentPane().add(txtTelefono);
		}
		{
			JLabel lblDireccin = new JLabel("Dirección:");
			lblDireccin.setBounds(34, 155, 115, 14);
			getContentPane().add(lblDireccin);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(159, 152, 209, 20);
			getContentPane().add(txtDireccion);
		}
		{
			JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(34, 180, 115, 14);
			getContentPane().add(lblCorreoElectrnico);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setColumns(10);
			txtCorreoElectronico.setBounds(159, 177, 209, 20);
			getContentPane().add(txtCorreoElectronico);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(235, 227, 89, 23);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(83, 227, 89, 23);
			getContentPane().add(btnGuardar);
		}
		Iniciar();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	private void Iniciar() {
		txtNombres.setText(cliente.getNombres());
		txtApellidos.setText(cliente.getApellidos());
		txtTelefono.setText(""+cliente.getTelefono());
		txtDireccion.setText(cliente.getDireccion());
		txtCorreoElectronico.setText(cliente.getCorreo());
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		cliente.setNombres(txtNombres.getText());
		cliente.setApellidos(txtApellidos.getText());
		cliente.setDireccion(txtDireccion.getText());
		cliente.setTelefono(Integer.parseInt(txtTelefono.getText()));
		cliente.setCorreo(txtCorreoElectronico.getText());	
		JOptionPane.showMessageDialog(this,"Datos actualizados correctamente");
		Limpiar();
	}
	private void Limpiar() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreoElectronico.setText("");
	}
}
