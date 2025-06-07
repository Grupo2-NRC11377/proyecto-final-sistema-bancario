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
import java.awt.Color;

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
		getContentPane().setBackground(new Color(255, 255, 255));
		this.persona = persona;
		setTitle("Autenticar");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 430, 300);
		getContentPane().setLayout(null);
		{
			lblAutenticarse = new JLabel("Autenticarse");
			lblAutenticarse.setForeground(new Color(238, 52, 37));
			lblAutenticarse.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutenticarse.setFont(new Font("Arial", Font.BOLD, 25));
			lblAutenticarse.setBounds(132, 50, 150, 30);
			getContentPane().add(lblAutenticarse);
		}
		{
			lblContrasea = new JLabel("Contraseña:");
			lblContrasea.setForeground(new Color(90, 90, 90));
			lblContrasea.setFont(new Font("Arial", Font.BOLD, 13));
			lblContrasea.setBounds(50, 120, 76, 16);
			getContentPane().add(lblContrasea);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setForeground(new Color(90, 90, 90));
			txtContraseña.setFont(new Font("Arial", Font.PLAIN, 13));
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(163, 116, 200, 25);
			getContentPane().add(txtContraseña);
		}
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBackground(new Color(238, 52, 37));
			btnConfirmar.setForeground(new Color(255, 255, 255));
			btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
			btnConfirmar.addActionListener(this);
			btnConfirmar.setBounds(50, 175, 150, 35);
			getContentPane().add(btnConfirmar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(new Color(90, 90, 90));
			btnCancelar.setBackground(new Color(255, 255, 255));
			btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(213, 175, 150, 35);
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
