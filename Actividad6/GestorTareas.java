package Actividad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestorTareas extends JFrame {

    private JTextField campoTarea;
    private JButton btnAgregar, btnEliminar;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloLista;
    private JLabel lblEstado;
    private JMenuItem opcionSalir;

    public GestorTareas() {
        super("Gestor de Tareas");

        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        campoTarea = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");

        panelSuperior.add(campoTarea);
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnEliminar);

        add(panelSuperior, BorderLayout.NORTH);
        
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);

        add(new JScrollPane(listaTareas), BorderLayout.CENTER);

        lblEstado = new JLabel(" ");
        add(lblEstado, BorderLayout.SOUTH);

        JMenuBar barra = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        opcionSalir = new JMenuItem("Salir");
        menuArchivo.add(opcionSalir);
        barra.add(menuArchivo);
        setJMenuBar(barra);

    
        btnAgregar.addActionListener(e -> agregarTarea());
        campoTarea.addActionListener(e -> agregarTarea());

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea();
            }
        });

       
        listaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String tarea = listaTareas.getSelectedValue();
                    if (tarea != null) {
                        JOptionPane.showMessageDialog(
                                GestorTareas.this,
                                "Has hecho doble clic sobre la tarea: " + tarea
                        );
                    }
                }
            }
        });

        listaTareas.addKeyListener(new KeyListenerTareas());

        addWindowListener(new ConfirmarCierre());

        opcionSalir.addActionListener(e -> cerrarAplicacion());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void agregarTarea() {
        String texto = campoTarea.getText().trim();
        if (!texto.isEmpty()) {
            modeloLista.addElement(texto);
            campoTarea.setText("");
            lblEstado.setText("Tarea añadida");
        }
    }

    private void eliminarTarea() {
        int index = listaTareas.getSelectedIndex();
        if (index != -1) {
            modeloLista.remove(index);
            lblEstado.setText("Tarea eliminada");
        }
    }

    private void cerrarAplicacion() {
        int op = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas salir del programa?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private class KeyListenerTareas implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                eliminarTarea();
            }
        }

        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }

    private class ConfirmarCierre extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrarAplicacion();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorTareas());
    }
}