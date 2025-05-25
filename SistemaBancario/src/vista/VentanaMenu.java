package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;

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
	private Cliente cliente;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmActualizarPerfil;
	private JMenuItem mntmVerPerfil;
	private JMenuItem mntmCerrarSesion;
	private JLabel lblNewLabel;
	private JTextField txtCliente;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmVerCuentasBancarias;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmVerTarjetas;
	private JMenuItem mntmSolicitar;
	private JMenuItem mntmCambiarContraseña;

	public VentanaMenu(VentanaPrincipal ventanaPrincipal, Cliente cliente) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.cliente = cliente;
		setTitle("Menú");
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
					mnNewMenu.add(mntmActualizarPerfil);
				}
				{
					mntmCerrarSesion = new JMenuItem("Cerrar sesión");
					mntmCerrarSesion.addActionListener(this);
					{
						mntmCambiarContraseña = new JMenuItem("Cambiar contraseña");
						mntmCambiarContraseña.addActionListener(this);
						mnNewMenu.add(mntmCambiarContraseña);
					}
					mnNewMenu.add(mntmCerrarSesion);
				}
			}
			{
				mnNewMenu_1 = new JMenu("Cuentas");
				menuBar.add(mnNewMenu_1);
				{
					mntmVerCuentasBancarias = new JMenuItem("Ver");
					mntmVerCuentasBancarias.addActionListener(this);
					mnNewMenu_1.add(mntmVerCuentasBancarias);
				}
			}
			{
				mnNewMenu_2 = new JMenu("Tarjetas");
				menuBar.add(mnNewMenu_2);
				{
					mntmVerTarjetas = new JMenuItem("Ver");
					mntmVerTarjetas.addActionListener(this);
					mnNewMenu_2.add(mntmVerTarjetas);
				}
				{
					mntmSolicitar = new JMenuItem("Solicitar");
					mnNewMenu_2.add(mntmSolicitar);
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
			txtCliente = new JTextField();
			if(cliente != null) txtCliente.setText(cliente.getNombres() + " " + cliente.getApellidos());
			txtCliente.setEditable(false);
			txtCliente.setFont(new Font("Tahoma", Font.PLAIN, 40));
			txtCliente.setBounds(51, 101, 477, 39);
			contentPane.add(txtCliente);
			txtCliente.setColumns(10);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCambiarContraseña) {
			do_mntmCambiarContraseña_actionPerformed(e);
		}
		if (e.getSource() == mntmVerTarjetas) {
			do_mntmVerTarjetas_actionPerformed(e);
		}
		if (e.getSource() == mntmVerCuentasBancarias) {
			do_mntmVerCuentasBancarias_actionPerformed(e);
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
		VentanaVerPerfil ventanaVerPerfil = new VentanaVerPerfil(cliente);
		ventanaVerPerfil.MostrarDatos();
		ventanaVerPerfil.setVisible(true);
	}
	protected void do_mntmActualizarPerfil_actionPerformed(ActionEvent e) {
		VentanaActualizarPerfil ventanaActualizarPerfil = new VentanaActualizarPerfil();
		ventanaActualizarPerfil.setVisible(true);
	}
	protected void do_mntmVerCuentasBancarias_actionPerformed(ActionEvent e) {
		VentanaVerCuentasBancarias ventanaVerCuentasBancarias = new VentanaVerCuentasBancarias(cliente);
		ventanaVerCuentasBancarias.llenarTabla();
		ventanaVerCuentasBancarias.setVisible(true);
	}
	protected void do_mntmVerTarjetas_actionPerformed(ActionEvent e) {		VentanaVerTarjetas ventanaVerTarjetas = new VentanaVerTarjetas(cliente);
		ventanaVerTarjetas.setVisible(true);
	}
	protected void do_mntmCambiarContraseña_actionPerformed(ActionEvent e) {
		VentanaCambiarContraseña ventanaCambiarContraseña = new VentanaCambiarContraseña(cliente);
		ventanaCambiarContraseña.setVisible(true);
	}
}
