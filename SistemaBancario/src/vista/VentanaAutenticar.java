package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Persona;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAutenticar extends JDialog implements ActionListener {
	
	private Persona persona;
	private boolean estadoAutenticacion = false;

	private static final long serialVersionUID = 1L;
	private JLabel lblAutenticarse;
	private JLabel lblContrasea;
	private JTextField txtContraseña;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	public VentanaAutenticar(Persona persona) {
		this.persona = persona;
		setTitle("Autenticarse");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 412, 238);
		getContentPane().setLayout(null);
		{
			lblAutenticarse = new JLabel("Autenticarse");
			lblAutenticarse.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutenticarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAutenticarse.setBounds(88, 40, 236, 25);
			getContentPane().add(lblAutenticarse);
		}
		{
			lblContrasea = new JLabel("Contraseña:");
			lblContrasea.setBounds(41, 93, 164, 14);
			getContentPane().add(lblContrasea);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(152, 90, 209, 20);
			getContentPane().add(txtContraseña);
		}
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(this);
			btnConfirmar.setBounds(74, 147, 89, 23);
			getContentPane().add(btnConfirmar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(226, 147, 89, 23);
			getContentPane().add(btnCancelar);
		}

	}
	
	public boolean getEstadoAutenticacion() {
		return estadoAutenticacion;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnConfirmar) {
			do_btnConfirmar_actionPerformed(e);
		}
	}
	protected void do_btnConfirmar_actionPerformed(ActionEvent e) {
		String contraseña = txtContraseña.getText();
		if (contraseña.isEmpty()){
			JOptionPane.showMessageDialog(this, "El campo contraseña no debe estar vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (!contraseña.equals(persona.getContraseña())) {
			JOptionPane.showMessageDialog(this, "La contraseña es incorrecta, vuelva a intentarlo.", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		estadoAutenticacion = true;
		dispose();
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		estadoAutenticacion = false;
		dispose();
	}
}
