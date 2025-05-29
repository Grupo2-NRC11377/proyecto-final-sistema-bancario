package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Empleado;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenuEmpleado extends JFrame implements ActionListener {

	private Empleado empleado;
	private VentanaPrincipal ventanaPrincipal;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JLabel lblNewLabel;
	private JTextField txtEmpleado;
	private JMenu mnNewMenu;
	private JMenuItem mntmVerPerfil;
	private JMenuItem mntmActualizarPerfil;
	private JMenuItem mntmCambiarContraseña;
	private JMenuItem mntmCerrarSesion;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmVerSolicitudes;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmVerClientes;

	public VentanaMenuEmpleado(VentanaPrincipal ventanaPrincipal, Empleado empleado) {
		setTitle("Menú");
		this.empleado = empleado;
		this.ventanaPrincipal = ventanaPrincipal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 255);
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
					mnNewMenu.add(mntmActualizarPerfil);
				}
				{
					mntmCambiarContraseña = new JMenuItem("Cambiar contraseña");
					mntmCambiarContraseña.addActionListener(this);
					mnNewMenu.add(mntmCambiarContraseña);
				}
				{
					mntmCerrarSesion = new JMenuItem("Cerrar sesión");
					mntmCerrarSesion.addActionListener(this);
					mnNewMenu.add(mntmCerrarSesion);
				}
			}
			{
				mnNewMenu_1 = new JMenu("Solicitudes");
				menuBar.add(mnNewMenu_1);
				{
					mntmVerSolicitudes = new JMenuItem("Ver");
					mntmVerSolicitudes.addActionListener(this);
					mnNewMenu_1.add(mntmVerSolicitudes);
				}
			}
			{
				mnNewMenu_2 = new JMenu("Clientes");
				menuBar.add(mnNewMenu_2);
				{
					mntmVerClientes = new JMenuItem("Ver");
					mntmVerClientes.addActionListener(this);
					mnNewMenu_2.add(mntmVerClientes);
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
			lblNewLabel.setBounds(57, 48, 255, 39);
			contentPane.add(lblNewLabel);
		}
		{
			txtEmpleado = new JTextField();
			txtEmpleado.setText(empleado.getNombres() + " " + empleado.getApellidos());
			txtEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 40));
			txtEmpleado.setEditable(false);
			txtEmpleado.setColumns(10);
			txtEmpleado.setBounds(57, 106, 477, 39);
			contentPane.add(txtEmpleado);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVerClientes) {
			do_mntmVerClientes_actionPerformed(e);
		}
		if (e.getSource() == mntmVerSolicitudes) {
			do_mntmVerSolicitudes_actionPerformed(e);
		}
		if (e.getSource() == mntmCerrarSesion) {
			do_mntmCerrarSesion_actionPerformed(e);
		}
		if (e.getSource() == mntmCambiarContraseña) {
			do_mntmCambiarContraseña_actionPerformed(e);
		}
		if (e.getSource() == mntmActualizarPerfil) {
			do_mntmActualizarPerfil_actionPerformed(e);
		}
		if (e.getSource() == mntmVerPerfil) {
			do_mntmVerPerfil_actionPerformed(e);
		}
	}
	protected void do_mntmVerPerfil_actionPerformed(ActionEvent e) {
		VentanaVerPerfil ventanaVerPerfil = new VentanaVerPerfil(empleado);
		ventanaVerPerfil.setVisible(true);
	}
	protected void do_mntmActualizarPerfil_actionPerformed(ActionEvent e) {
		VentanaActualizarPerfil ventanaActualizarPerfil = new VentanaActualizarPerfil(empleado);
		ventanaActualizarPerfil.setVisible(true);
	}
	protected void do_mntmCambiarContraseña_actionPerformed(ActionEvent e) {
		VentanaCambiarContraseña ventanaCambiarContraseña = new VentanaCambiarContraseña(empleado);
		ventanaCambiarContraseña.setVisible(true);
	}
	protected void do_mntmCerrarSesion_actionPerformed(ActionEvent e) {
		ventanaPrincipal.setVisible(true);
		dispose();
	}
	protected void do_mntmVerSolicitudes_actionPerformed(ActionEvent e) {
		VentanaVerSolicitudes verSolicitudes = new VentanaVerSolicitudes(empleado);
		verSolicitudes.setVisible(true);
	}
	protected void do_mntmVerClientes_actionPerformed(ActionEvent e) {
		VentanaVerClientes ventanaVerClientes = new VentanaVerClientes();
		ventanaVerClientes.setVisible(true);
	}
}
