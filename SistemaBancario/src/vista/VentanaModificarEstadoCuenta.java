package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Cuenta;
import modelo.Cliente;
import java.awt.*;
import java.awt.event.*;

public class VentanaModificarEstadoCuenta extends JFrame {
    private JTable tablaCuentas;
    private DefaultTableModel modeloTabla;
    private JButton btnCambiarEstado;
    private JButton btnCerrar;
    private Cliente cliente;

    public VentanaModificarEstadoCuenta(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Modificar Estado de Cuentas");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new Object[]{"Nº Cuenta", "Estado", "Tipo"}, 0);
        tablaCuentas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaCuentas);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnCambiarEstado = new JButton("Cambiar Estado");
        btnCambiarEstado.setPreferredSize(new Dimension(140, 30));
        btnCambiarEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tablaCuentas.getSelectedRow();
                if (fila >= 0) {
                    Cuenta cuenta = cliente.getCuentas().get(fila);
                    if (cuenta.getEstado().equals("activa")) {
                        cuenta.cancelar();
                        JOptionPane.showMessageDialog(null, "Estado cambiado a cancelada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Solo se pueden cambiar cuentas activas.");
                    }
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una cuenta.");
                }
            }
        });

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setPreferredSize(new Dimension(100, 30));
        btnCerrar.addActionListener(e -> dispose());

        panelBotones.add(btnCambiarEstado);
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarTabla();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Cuenta c : cliente.getCuentas()) {
            modeloTabla.addRow(new Object[]{c.getNumeroCuenta(), c.getEstado(), c.getTipoCuenta()});
        }
    }
}
