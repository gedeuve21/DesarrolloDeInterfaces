import javax.swing.*;
import java.awt.*;

public class FormularioAlumno extends JFrame {

    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoEmail;
    private JTextField campoEdad;
    private JTextField campoTelefono;
    private JLabel etiquetaError;

    public FormularioAlumno() {

        setTitle("Formulario de Alumno");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con GridLayout claro
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panel.add(campoNombre);

        panel.add(new JLabel("Apellidos:"));
        campoApellidos = new JTextField();
        panel.add(campoApellidos);

        panel.add(new JLabel("Email:"));
        campoEmail = new JTextField();
        panel.add(campoEmail);

        panel.add(new JLabel("Edad:"));
        campoEdad = new JTextField();
        panel.add(campoEdad);

        panel.add(new JLabel("Teléfono:"));
        campoTelefono = new JTextField();
        panel.add(campoTelefono);

        JButton btnAñadir = new JButton("Añadir alumno");
        panel.add(btnAñadir);

        etiquetaError = new JLabel("Máximo 5 alumnos permitidos");
        etiquetaError.setForeground(Color.RED);
        etiquetaError.setVisible(false);
        panel.add(etiquetaError);

        add(panel);

        // Acción botón
        btnAñadir.addActionListener(e -> agregarAlumno());
    }

    private void agregarAlumno() {

        if (Principal.indiceAlumnos >= Principal.alumnos.length) {
            etiquetaError.setVisible(true);
            return;
        }

        if (campoNombre.getText().isEmpty() ||
            campoApellidos.getText().isEmpty() ||
            campoEmail.getText().isEmpty() ||
            campoEdad.getText().isEmpty() ||
            campoTelefono.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Rellena todos los campos.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(campoEdad.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número.");
            return;
        }

        Alumno nuevo = new Alumno(
                campoNombre.getText(),
                campoApellidos.getText(),
                campoEmail.getText(),
                edad,
                campoTelefono.getText()
        );

        Principal.alumnos[Principal.indiceAlumnos] = nuevo;
        Principal.indiceAlumnos++;

        etiquetaError.setVisible(false);

        campoNombre.setText("");
        campoApellidos.setText("");
        campoEmail.setText("");
        campoEdad.setText("");
        campoTelefono.setText("");

        JOptionPane.showMessageDialog(this, "Alumno añadido correctamente.");
    }
}
