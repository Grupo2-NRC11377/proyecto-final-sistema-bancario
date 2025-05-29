package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Tarjeta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaVerTarjetas extends JDialog implements ActionListener {
	
	private Cliente cliente;

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JButton btnCerrar;
    private JButton btnBloquear;
    private JTable tableTarjetas;
    private DefaultTableModel tableModel;
    private JLabel lblTarjetasBancarias;
    
    public VentanaVerTarjetas(Cliente cliente) {
    	this.cliente = cliente;
    	
    	setModal(true);
        setTitle("Ver tarjetas bancarias");
        setBounds(100, 100, 650, 450);
        getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(504, 352, 99, 29);
        contentPanel.add(btnCerrar);

        btnBloquear = new JButton("Bloquear Tarjeta");
        btnBloquear.addActionListener(this);
        btnBloquear.setBounds(359, 352, 130, 29);
        contentPanel.add(btnBloquear);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(37, 83, 566, 250);
        contentPanel.add(scrollPane);

        String[] columnas = { "Número de tarjeta", "Tipo de tarjeta", "Fecha de Vencimiento", "Estado" };
        tableModel = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTarjetas = new JTable(tableModel);
        tableTarjetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(tableTarjetas);
        {
        	lblTarjetasBancarias = new JLabel("Tarjetas bancarias");
        	lblTarjetasBancarias.setHorizontalAlignment(SwingConstants.CENTER);
        	lblTarjetasBancarias.setFont(new Font("Tahoma", Font.PLAIN, 20));
        	lblTarjetasBancarias.setBounds(224, 33, 185, 25);
        	contentPanel.add(lblTarjetasBancarias);
        }

        llenarTabla();
    }

    private void llenarTabla() {
        if (cliente == null) return;
        tableModel.setRowCount(0);
        for (Tarjeta tarjeta : cliente.getTarjetas()) {
        	Object[] fila = new Object[] {
                    tarjeta.getNumeroTarjeta(),     
                    tarjeta.getTipoTarjeta(),           
                    tarjeta.getFechaVencimiento(),   
                    tarjeta.getEstado()               
                };
            tableModel.addRow(fila);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == btnBloquear) {
            bloquearTarjetaSeleccionada();
        }
    }

    private void bloquearTarjetaSeleccionada() {
        int posicionFilaSeleccionada = tableTarjetas.getSelectedRow();
        String numeroTarjeta = (String) tableModel.getValueAt(posicionFilaSeleccionada, 0);
        String estado = (String) tableModel.getValueAt(posicionFilaSeleccionada, 3);
        if ("bloqueada".equals(estado)) {
            JOptionPane.showMessageDialog(this, "La tarjeta ya está bloqueada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea bloquear la tarjeta " + numeroTarjeta + "?",
                "Confirmar bloqueo", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
        	Tarjeta tarjeta = cliente.buscarTarjeta(numeroTarjeta);
        	tarjeta.setEstado("bloqueada");
        	llenarTabla();
            JOptionPane.showMessageDialog(this, "La tarjeta ha sido bloqueada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
}
