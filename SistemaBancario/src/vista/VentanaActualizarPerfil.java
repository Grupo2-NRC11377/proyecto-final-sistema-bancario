package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaActualizarPerfil extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaActualizarPerfil dialog = new VentanaActualizarPerfil();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaActualizarPerfil() {
		setBounds(100, 100, 450, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setBounds(60, 63, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDOS:");
		lblNewLabel_1.setBounds(60, 105, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TELEFONO:");
		lblNewLabel_2.setBounds(60, 151, 56, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DIRECCIÓN:");
		lblNewLabel_3.setBounds(60, 196, 61, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CORREO ELECTRONICO:");
		lblNewLabel_4.setBounds(60, 245, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CONTRASEÑA:");
		lblNewLabel_5.setBounds(60, 279, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(138, 60, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 102, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 148, 86, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(138, 193, 86, 20);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(138, 242, 86, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(138, 276, 86, 20);
		contentPanel.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("ACTUALIZAR PERFIL");
		lblNewLabel_6.setBounds(153, 23, 100, 14);
		contentPanel.add(lblNewLabel_6);
		
		JButton btnGuardar = new JButton("GUARDAD");
		btnGuardar.setBounds(293, 147, 89, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(293, 209, 89, 23);
		contentPanel.add(btnCancelar);
	}
}
