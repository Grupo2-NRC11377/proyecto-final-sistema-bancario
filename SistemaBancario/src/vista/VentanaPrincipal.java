package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnIniciarSesion;
	private JTextField txtCorreoElectronico;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNewLabel_1;
	private JTextField txtContraseña;
	private JButton btnRegistrarse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Bienvenido");
			lblNewLabel.setBounds(45, 38, 60, 14);
			contentPane.add(lblNewLabel);
		}
		{
			btnIniciarSesion = new JButton("Iniciar Sesión");
			btnIniciarSesion.setBounds(112, 179, 200, 35);
			contentPane.add(btnIniciarSesion);
		}
		{
			txtCorreoElectronico = new JTextField();
			txtCorreoElectronico.setBounds(171, 83, 200, 25);
			contentPane.add(txtCorreoElectronico);
			txtCorreoElectronico.setColumns(10);
		}
		{
			lblCorreoElectrnico = new JLabel("Correo electrónico:");
			lblCorreoElectrnico.setBounds(45, 86, 100, 14);
			contentPane.add(lblCorreoElectrnico);
		}
		{
			lblNewLabel_1 = new JLabel("Contraseña:");
			lblNewLabel_1.setBounds(45, 125, 100, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setBounds(171, 122, 200, 25);
			contentPane.add(txtContraseña);
			txtContraseña.setColumns(10);
		}
		{
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.setBounds(112, 225, 200, 35);
			contentPane.add(btnRegistrarse);
		}
	}
}
