package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import modelo.Cliente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

<<<<<<< HEAD
public class VentanaCambiarContraseña extends JFrame implements ActionListener {
=======
public class VentanaCambiarContraseña extends JDialog implements ActionListener {
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContraseñaAnterior;
	private JLabel lblNuevaContraseña;
	private JLabel lblRepetirContraseña;
	private JTextField txtContraseñaAnterior;
	private JTextField txtNuevaContraseña;
	private JTextField txtRepetirContraseña;
	private JButton btnCambiarContraseña;
=======
>>>>>>> refs/remotes/origin/master
	private Cliente cliente;
<<<<<<< HEAD
	private JButton btnCerrar;
=======
	
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
>>>>>>> refs/remotes/origin/master

	public VentanaCambiarContraseña(Cliente cliente) {
		this.cliente = cliente;
<<<<<<< HEAD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Contraseña");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(147, 13, 132, 39);
			contentPane.add(lblNewLabel);
		}
		{
			lblContraseñaAnterior = new JLabel("Contraseña anterior:");
			lblContraseñaAnterior.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblContraseñaAnterior.setBounds(25, 61, 117, 21);
			contentPane.add(lblContraseñaAnterior);
		}
		{
			lblNuevaContraseña = new JLabel("Nueva contraseña:");
			lblNuevaContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNuevaContraseña.setBounds(25, 92, 117, 21);
			contentPane.add(lblNuevaContraseña);
		}
		{
			lblRepetirContraseña = new JLabel("Repetir nueva contraseña:");
			lblRepetirContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblRepetirContraseña.setBounds(25, 123, 145, 21);
			contentPane.add(lblRepetirContraseña);
		}
		{
			txtContraseñaAnterior = new JTextField();
			txtContraseñaAnterior.setBounds(201, 62, 169, 19);
			contentPane.add(txtContraseñaAnterior);
			txtContraseñaAnterior.setColumns(10);
		}
		{
			txtNuevaContraseña = new JTextField();
			txtNuevaContraseña.setColumns(10);
			txtNuevaContraseña.setBounds(201, 93, 169, 19);
			contentPane.add(txtNuevaContraseña);
		}
		{
			txtRepetirContraseña = new JTextField();
			txtRepetirContraseña.setColumns(10);
			txtRepetirContraseña.setBounds(201, 124, 169, 19);
			contentPane.add(txtRepetirContraseña);
		}
		{
			btnCambiarContraseña = new JButton("Cambiar Contraseña");
			btnCambiarContraseña.addActionListener(this);
			btnCambiarContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			btnCambiarContraseña.setBounds(49, 165, 159, 39);
			contentPane.add(btnCambiarContraseña);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			btnCerrar.setBounds(233, 165, 103, 39);
			contentPane.add(btnCerrar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnCambiarContraseña) {
			do_btnCambiarContraseña_actionPerformed(e);
		}
	}
	protected void do_btnCambiarContraseña_actionPerformed(ActionEvent e) {
		String ContraAnterior = txtContraseñaAnterior.getText();
		String NuevaContra = txtNuevaContraseña.getText();
		String RepetirContra = txtRepetirContraseña.getText();
		
		if (ContraAnterior.isEmpty() || NuevaContra.isEmpty() || RepetirContra.isEmpty()){
			JOptionPane.showMessageDialog(this, "Los campos no deben estar vacíos");
=======
		setTitle("Cambiar contraseña");
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.cliente = cliente;
		setBounds(100, 100, 420, 276);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Cambiar contraseña");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(84, 25, 236, 25);
			getContentPane().add(lblNewLabel);
>>>>>>> refs/remotes/origin/master
		}
		{
			lblContraseaAnterior = new JLabel("Contraseña actual:");
			lblContraseaAnterior.setBounds(32, 78, 115, 14);
			getContentPane().add(lblContraseaAnterior);
		}
		{
			txtContraseñaActual = new JTextField();
			txtContraseñaActual.setColumns(10);
			txtContraseñaActual.setBounds(157, 75, 209, 20);
			getContentPane().add(txtContraseñaActual);
		}
		{
			lblNuevaContrasea = new JLabel("Nueva contraseña:");
			lblNuevaContrasea.setBounds(32, 103, 115, 14);
			getContentPane().add(lblNuevaContrasea);
		}
		{
			txtNuevaContreña = new JTextField();
			txtNuevaContreña.setColumns(10);
			txtNuevaContreña.setBounds(157, 100, 209, 20);
			getContentPane().add(txtNuevaContreña);
		}
		{
			lblRepetirContrasea = new JLabel("Repetir contraseña:");
			lblRepetirContrasea.setBounds(32, 128, 115, 14);
			getContentPane().add(lblRepetirContrasea);
		}
		{
			txtRepetirContraseña = new JTextField();
			txtRepetirContraseña.setColumns(10);
			txtRepetirContraseña.setBounds(157, 125, 209, 20);
			getContentPane().add(txtRepetirContraseña);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(82, 179, 89, 23);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(234, 179, 89, 23);
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
	private void Limpiar() {
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
		else if (!contraseñaActual.equals(cliente.getContraseña())) {
			JOptionPane.showMessageDialog(this, "La contraseña anterior es incorrecta, vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (!nuevaContraseña.equals(repetirContraseña)) {
			JOptionPane.showMessageDialog(this, "Las nuevas contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			cliente.setContraseña(repetirContraseña);
			JOptionPane.showMessageDialog(this, "¡Contraseña fue cambiada correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
			Limpiar();
		}

	}
}
