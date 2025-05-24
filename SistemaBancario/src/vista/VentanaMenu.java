package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VentanaMenu extends JFrame implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmActualizarPerfil;
	private JMenuItem mntmVerPerfil;
	private JMenuItem mntmCerrarSesion;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JMenuItem mntmVerTarjetas;

	public VentanaMenu(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 240);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu = new JMenu("Perfil");
				menuBar.add(mnNewMenu);
				{
					mntmVerPerfil = new JMenuItem("Ver");
					mntmVerPerfil.addActionListener(this);
					mnNewMenu.add(mntmVerPerfil);
				}
				{
					mntmActualizarPerfil = new JMenuItem("Actualizar");
					mntmActualizarPerfil.addActionListener(this);
					{
						mntmVerTarjetas = new JMenuItem("Ver Tarjetas");
						mntmVerTarjetas.addActionListener(this);
						mnNewMenu.add(mntmVerTarjetas);
					}
					mnNewMenu.add(mntmActualizarPerfil);
				}
				{
					mntmCerrarSesion = new JMenuItem("Cerrar sesión");
					mntmCerrarSesion.addActionListener(this);
					mnNewMenu.add(mntmCerrarSesion);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Bienvenido/a,");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel.setBounds(51, 43, 255, 39);
			contentPane.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 40));
			textField.setBounds(51, 101, 477, 39);
			contentPane.add(textField);
			textField.setColumns(10);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVerTarjetas) {
			do_mntmVerTarjetas_actionPerformed(e);
		}
		if (e.getSource() == mntmActualizarPerfil) {
			do_mntmActualizarPerfil_actionPerformed(e);
		}
		if (e.getSource() == mntmVerPerfil) {
			do_mntmVerPerfil_actionPerformed(e);
		}
		if (e.getSource() == mntmCerrarSesion) {
			do_mntmCerrarSesion_actionPerformed(e);
		}
	}
	protected void do_mntmCerrarSesion_actionPerformed(ActionEvent e) {
		ventanaPrincipal.setVisible(true);
		dispose();
	}
	protected void do_mntmVerPerfil_actionPerformed(ActionEvent e) {
		VentanaVerPerfil ventanaVerPerfil = new VentanaVerPerfil();
		ventanaVerPerfil.setVisible(true);
	}
	protected void do_mntmActualizarPerfil_actionPerformed(ActionEvent e) {
		VentanaActualizarPerfil ventanaActualizarPerfil = new VentanaActualizarPerfil();
		ventanaActualizarPerfil.setVisible(true);
	}
	protected void do_mntmVerTarjetas_actionPerformed(ActionEvent e) {
		VentanaVerTarjetas ventanaVerTarjetas = new VentanaVerTarjetas();
		ventanaVerTarjetas.setVisible(true);
	}
}
