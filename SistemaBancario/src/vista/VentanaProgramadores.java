package vista;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaProgramadores extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblProgramadores;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JLabel lblFoto;
	private JLabel lblFoto_2;
	private JLabel lblFoto_1;
	private JLabel lblFoto_3;
	private JLabel lblBasilioAlvarez;
	private JLabel lblGianellaAnnie;
	private JLabel lblBasilioAlvarez_2;
	private JLabel lblCahuanaMoquillaza;
	private JLabel lblHerbertJherson;
	private JLabel lblBasilioAlvarez_3;
	private JLabel lblBasilioAlvarez_4;
	private JLabel lblGianellaAnnie_2;
	private JLabel lblBasilioAlvarez_5;
	private JLabel lblBasilioAlvarez_6;
	private JLabel lblGianellaAnnie_3;
	private JLabel lblBasilioAlvarez_7;
	private JLabel lblBasilioAlvarez_8;
	private JLabel lblGianellaAnnie_4;
	private JLabel lblBasilioAlvarez_9;
	
	public VentanaProgramadores() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		{
			lblProgramadores = new JLabel("Programadores");
			lblProgramadores.setHorizontalAlignment(SwingConstants.CENTER);
			lblProgramadores.setForeground(new Color(238, 52, 37));
			lblProgramadores.setFont(new Font("Arial", Font.BOLD, 25));
			lblProgramadores.setBackground(Color.WHITE);
			lblProgramadores.setBounds(316, 50, 251, 30);
			getContentPane().add(lblProgramadores);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setForeground(new Color(90, 90, 90));
			btnCerrar.setFont(new Font("Arial", Font.BOLD, 13));
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setBounds(367, 440, 150, 35);
			getContentPane().add(btnCerrar);
		}
		{
			lblNewLabel = new JLabel("Foto 1");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setBounds(50, 120, 137, 171);
			getContentPane().add(lblNewLabel);
		}
		{
			lblFoto = new JLabel("Foto 2");
			lblFoto.setForeground(new Color(0, 0, 0));
			lblFoto.setBackground(new Color(255, 255, 255));
			lblFoto.setBounds(210, 120, 137, 171);
			getContentPane().add(lblFoto);
		}
		{
			lblFoto_2 = new JLabel("Foto 3");
			lblFoto_2.setForeground(new Color(0, 0, 0));
			lblFoto_2.setBackground(new Color(255, 255, 255));
			lblFoto_2.setBounds(370, 120, 137, 171);
			getContentPane().add(lblFoto_2);
		}
		{
			lblFoto_1 = new JLabel("Foto 3");
			lblFoto_1.setForeground(new Color(0, 0, 0));
			lblFoto_1.setBackground(new Color(255, 255, 255));
			lblFoto_1.setBounds(530, 120, 137, 171);
			getContentPane().add(lblFoto_1);
		}
		{
			lblFoto_3 = new JLabel("Foto 3");
			lblFoto_3.setForeground(new Color(0, 0, 0));
			lblFoto_3.setBackground(new Color(255, 255, 255));
			lblFoto_3.setBounds(690, 120, 137, 171);
			getContentPane().add(lblFoto_3);
		}
		{
			lblBasilioAlvarez = new JLabel("Basilio Alvarez");
			lblBasilioAlvarez.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez.setBounds(50, 310, 137, 18);
			getContentPane().add(lblBasilioAlvarez);
		}
		{
			lblGianellaAnnie = new JLabel("Gianella Annie");
			lblGianellaAnnie.setHorizontalAlignment(SwingConstants.CENTER);
			lblGianellaAnnie.setForeground(new Color(90, 90, 90));
			lblGianellaAnnie.setFont(new Font("Arial", Font.BOLD, 15));
			lblGianellaAnnie.setBounds(50, 339, 137, 18);
			getContentPane().add(lblGianellaAnnie);
		}
		{
			lblBasilioAlvarez_2 = new JLabel("(N00396701)");
			lblBasilioAlvarez_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_2.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_2.setBounds(50, 368, 137, 18);
			getContentPane().add(lblBasilioAlvarez_2);
		}
		{
			lblCahuanaMoquillaza = new JLabel("Cahuana Moquillaza");
			lblCahuanaMoquillaza.setHorizontalAlignment(SwingConstants.CENTER);
			lblCahuanaMoquillaza.setForeground(new Color(90, 90, 90));
			lblCahuanaMoquillaza.setFont(new Font("Arial", Font.BOLD, 15));
			lblCahuanaMoquillaza.setBounds(200, 310, 157, 18);
			getContentPane().add(lblCahuanaMoquillaza);
		}
		{
			lblHerbertJherson = new JLabel("Herbert Jherson");
			lblHerbertJherson.setHorizontalAlignment(SwingConstants.CENTER);
			lblHerbertJherson.setForeground(new Color(90, 90, 90));
			lblHerbertJherson.setFont(new Font("Arial", Font.BOLD, 15));
			lblHerbertJherson.setBounds(210, 339, 137, 18);
			getContentPane().add(lblHerbertJherson);
		}
		{
			lblBasilioAlvarez_3 = new JLabel("(N00327161)");
			lblBasilioAlvarez_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_3.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_3.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_3.setBounds(210, 368, 137, 18);
			getContentPane().add(lblBasilioAlvarez_3);
		}
		{
			lblBasilioAlvarez_4 = new JLabel("Corcuera Paredes");
			lblBasilioAlvarez_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_4.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_4.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_4.setBounds(370, 310, 137, 18);
			getContentPane().add(lblBasilioAlvarez_4);
		}
		{
			lblGianellaAnnie_2 = new JLabel("Jose Manuel");
			lblGianellaAnnie_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblGianellaAnnie_2.setForeground(new Color(90, 90, 90));
			lblGianellaAnnie_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblGianellaAnnie_2.setBounds(370, 339, 137, 18);
			getContentPane().add(lblGianellaAnnie_2);
		}
		{
			lblBasilioAlvarez_5 = new JLabel("(N00373084)");
			lblBasilioAlvarez_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_5.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_5.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_5.setBounds(370, 368, 137, 18);
			getContentPane().add(lblBasilioAlvarez_5);
		}
		{
			lblBasilioAlvarez_6 = new JLabel("Cotrina Sandoval");
			lblBasilioAlvarez_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_6.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_6.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_6.setBounds(530, 310, 137, 18);
			getContentPane().add(lblBasilioAlvarez_6);
		}
		{
			lblGianellaAnnie_3 = new JLabel("Alexandra Margoth");
			lblGianellaAnnie_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblGianellaAnnie_3.setForeground(new Color(90, 90, 90));
			lblGianellaAnnie_3.setFont(new Font("Arial", Font.BOLD, 15));
			lblGianellaAnnie_3.setBounds(530, 339, 137, 18);
			getContentPane().add(lblGianellaAnnie_3);
		}
		{
			lblBasilioAlvarez_7 = new JLabel("(N00328935)");
			lblBasilioAlvarez_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_7.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_7.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_7.setBounds(530, 368, 137, 18);
			getContentPane().add(lblBasilioAlvarez_7);
		}
		{
			lblBasilioAlvarez_8 = new JLabel("De La Cruz Villuga");
			lblBasilioAlvarez_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_8.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_8.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_8.setBounds(690, 310, 137, 18);
			getContentPane().add(lblBasilioAlvarez_8);
		}
		{
			lblGianellaAnnie_4 = new JLabel("Kevin Andre");
			lblGianellaAnnie_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblGianellaAnnie_4.setForeground(new Color(90, 90, 90));
			lblGianellaAnnie_4.setFont(new Font("Arial", Font.BOLD, 15));
			lblGianellaAnnie_4.setBounds(690, 339, 137, 18);
			getContentPane().add(lblGianellaAnnie_4);
		}
		{
			lblBasilioAlvarez_9 = new JLabel("(N00368206)");
			lblBasilioAlvarez_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasilioAlvarez_9.setForeground(new Color(90, 90, 90));
			lblBasilioAlvarez_9.setFont(new Font("Arial", Font.BOLD, 15));
			lblBasilioAlvarez_9.setBounds(690, 368, 137, 18);
			getContentPane().add(lblBasilioAlvarez_9);
		}
		setTitle("Programadores");
		setBounds(100, 100, 900, 560);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
