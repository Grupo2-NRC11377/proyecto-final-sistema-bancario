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

public class VentanaVerTarjetas extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JButton btnCerrar;
    private JButton btnBloquear;
    private JTable tableTarjetas;
    private DefaultTableModel tableModel;
    private Cliente cliente;
    
    public VentanaVerTarjetas(Cliente cliente) {
    	this.cliente = cliente;
        setTitle("Mis Tarjetas");
        setBounds(100, 100, 450, 350);
        getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(325, 280, 99, 29);
        contentPanel.add(btnCerrar);

        btnBloquear = new JButton("Bloquear Tarjeta");
        btnBloquear.addActionListener(this);
        btnBloquear.setBounds(180, 280, 130, 29);
        contentPanel.add(btnBloquear);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 414, 250);
        contentPanel.add(scrollPane);

        String[] columnas = { "Número", "Tipo", "Titular", "Vencimiento", "Estado" };
        tableModel = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTarjetas = new JTable(tableModel);
        tableTarjetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(tableTarjetas);

        cargarTarjetasCliente();
    }

    private void cargarTarjetasCliente() {
        if (cliente == null) return;

        tableModel.setRowCount(0);

        for (Tarjeta tarjeta : cliente.getTarjetas()) {
            if ("Activa".equalsIgnoreCase(tarjeta.getEstado())) {
                Object[] fila = new Object[] {
                    tarjeta.getNumero(),     
                    tarjeta.getTipo(),               
                    cliente.getNombres(),              
                    tarjeta.getFechaVencimiento(),   
                    tarjeta.getEstado()               
                };
                tableModel.addRow(fila);
            }
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
        int filaSeleccionada = tableTarjetas.getSelectedRow();
        

        String numeroTarjeta = (String) tableModel.getValueAt(filaSeleccionada, 0);
        String estado = (String) tableModel.getValueAt(filaSeleccionada, 4);

        if ("Bloqueada".equals(estado)) {
            JOptionPane.showMessageDialog(this, "La tarjeta ya está bloqueada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea bloquear la tarjeta " + numeroTarjeta + "?",
                "Confirmar bloqueo", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
        	Tarjeta tarjeta = cliente.getTarjetas().get(filaSeleccionada);
        	tarjeta.getEstado();
        	tableModel.setValueAt("Bloqueada", filaSeleccionada, 4);

            JOptionPane.showMessageDialog(this, "La tarjeta ha sido bloqueada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cargarTarjetasActivas(Object[][] tarjetas) {
        tableModel.setRowCount(0);
        for (Object[] fila : tarjetas) {
            if ("Activa".equals(fila[4])) {
                tableModel.addRow(fila);
            }
        }
    }    
}
