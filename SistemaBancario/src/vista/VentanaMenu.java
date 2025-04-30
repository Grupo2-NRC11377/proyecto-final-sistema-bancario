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
		
		JMenu mnNewMenu = new JMenu("Perfil");
		mnNewMenu.setBounds(49, 107, 115, 26);
		getContentPane().add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Actualizar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesión");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Cuentas");
		mnNewMenu_1.setBounds(175, 107, 115, 26);
		getContentPane().add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Tarjetas");
		mnNewMenu_2.setBounds(310, 107, 115, 26);
		getContentPane().add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Transacciones");
		mnNewMenu_3.setBounds(505, 107, 115, 26);
		getContentPane().add(mnNewMenu_3);
	}
}
