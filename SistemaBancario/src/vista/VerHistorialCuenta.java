package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cuenta;
import modelo.HistorialCuenta;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerHistorialCuenta extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public VerHistorialCuenta() {
		setTitle("Historial");
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(162, 227, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			txtS = new JTextArea();
			txtS.setEditable(false);
			txtS.setBounds(10, 11, 414, 192);
			contentPanel.add(txtS);
		}
	}
	public VerHistorialCuenta(Cuenta cuenta) {
	    this();
	    StringBuilder sb = new StringBuilder();
	    for (HistorialCuenta he : cuenta.getHistorialEstados()) {
	        sb.append(he.toString()).append("\n");
	    }
	    txtS.setText(sb.toString());
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
