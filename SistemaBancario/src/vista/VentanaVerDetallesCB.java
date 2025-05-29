package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import modelo.Cuenta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerDetallesCB extends JDialog implements ActionListener {
	
	private Cuenta cuenta;

	private static final long serialVersionUID = 1L;
	private JLabel lblCuentaBancaria;
	private JLabel lblNewLabel;
	private JLabel lblSaldoDisponible;
	private JLabel lblSaldoContable;
	private JLabel lblFechaDeCreacin;
	private JLabel lblEstado;
	private JTextField txtNumeroCuenta;
	private JTextField txtSaldoDisponible;
	private JTextField txtSaldoContable;
	private JTextField txtFechaCreacion;
	private JTextField txtEstado;
	private JButton btnCerrar;

	public VentanaVerDetallesCB(Cuenta cuenta) {
		this.cuenta = cuenta;
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Ver detalles");
		setBounds(100, 100, 450, 330);
		getContentPane().setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(173, 242, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblCuentaBancaria = new JLabel("");
			if(cuenta != null) lblCuentaBancaria.setText(cuenta.getTipoCuenta());
			lblCuentaBancaria.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCuentaBancaria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCuentaBancaria.setBounds(28, 29, 378, 34);
			getContentPane().add(lblCuentaBancaria);
		}
		{
			lblNewLabel = new JLabel("Número de cuenta:");
			lblNewLabel.setBounds(28, 96, 131, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			lblSaldoDisponible = new JLabel("Saldo disponible:");
			lblSaldoDisponible.setBounds(28, 121, 131, 14);
			getContentPane().add(lblSaldoDisponible);
		}
		{
			lblSaldoContable = new JLabel("Saldo contable:");
			lblSaldoContable.setBounds(28, 146, 131, 14);
			getContentPane().add(lblSaldoContable);
		}
		{
			lblFechaDeCreacin = new JLabel("Fecha de creación:");
			lblFechaDeCreacin.setBounds(28, 171, 131, 14);
			getContentPane().add(lblFechaDeCreacin);
		}
		{
			lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(28, 196, 131, 14);
			getContentPane().add(lblEstado);
		}
		{
			txtNumeroCuenta = new JTextField();
			if(cuenta != null) txtNumeroCuenta.setText(cuenta.getNumeroCuenta());
			txtNumeroCuenta.setEditable(false);
			txtNumeroCuenta.setBounds(153, 93, 240, 20);
			getContentPane().add(txtNumeroCuenta);
			txtNumeroCuenta.setColumns(10);
		}
		{
			txtSaldoDisponible = new JTextField();
			if(cuenta != null) txtSaldoDisponible.setText(cuenta.getSaldoDisponibleSoles());
			txtSaldoDisponible.setEditable(false);
			txtSaldoDisponible.setColumns(10);
			txtSaldoDisponible.setBounds(153, 118, 240, 20);
			getContentPane().add(txtSaldoDisponible);
		}
		{
			txtSaldoContable = new JTextField();
			if(cuenta != null) txtSaldoContable.setText(cuenta.getSaldoContableSoles());
			txtSaldoContable.setEditable(false);
			txtSaldoContable.setColumns(10);
			txtSaldoContable.setBounds(153, 143, 240, 20);
			getContentPane().add(txtSaldoContable);
		}
		{
			txtFechaCreacion = new JTextField();
			if(cuenta != null) txtFechaCreacion.setText(cuenta.getFechaCreacion());
			txtFechaCreacion.setEditable(false);
			txtFechaCreacion.setColumns(10);
			txtFechaCreacion.setBounds(153, 168, 240, 20);
			getContentPane().add(txtFechaCreacion);
		}
		{
			txtEstado = new JTextField();
			if(cuenta != null) txtEstado.setText(cuenta.getEstado());
			txtEstado.setEditable(false);
			txtEstado.setColumns(10);
			txtEstado.setBounds(153, 193, 240, 20);
			getContentPane().add(txtEstado);
		}
		mostrarDatos();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	private void mostrarDatos() {
		txtEstado.setText(cuenta.getEstado());
		txtFechaCreacion.setText(cuenta.getFechaCreacion());
		txtNumeroCuenta.setText(cuenta.getNumeroCuenta());
		txtSaldoContable.setText(cuenta.getSaldoContableSoles());
		txtSaldoDisponible.setText(cuenta.getSaldoDisponibleSoles());
	}
}
