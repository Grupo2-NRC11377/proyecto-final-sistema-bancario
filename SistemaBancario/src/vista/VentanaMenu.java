package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 280);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido,");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(177, 37, 135, 50);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(300, 47, 206, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(49, 96, 630, 50);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu_4 = new JMenu("Perfil");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Actualizar");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesión");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Cuentas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Solicitar");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Retirar");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Depositar");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Transferir");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cancelar");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Tarjetas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Ver");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Solicitar");
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Realizar compras");
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Bloquear");
		mnNewMenu_1.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_2 = new JMenu("Transacciones");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Ver");
		mnNewMenu_2.add(mntmNewMenuItem_9);
	}
}
