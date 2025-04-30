package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerPerfil extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerPerfil dialog = new VerPerfil();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerPerfil() {
		setBounds(100, 100, 479, 571);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mi Perfil");
			lblNewLabel.setBounds(195, 37, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombres y Apellidos");
			lblNewLabel_1.setBounds(43, 100, 96, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Telefono");
			lblNewLabel_2.setBounds(43, 149, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Direccion");
			lblNewLabel_3.setBounds(43, 206, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(43, 262, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(238, 97, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(238, 149, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(238, 203, 86, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setBounds(238, 259, 86, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
	}

}
