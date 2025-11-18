import javax.swing.*;

public class Principal {

    public static Alumno[] alumnos = new Alumno[5];
    public static int indiceAlumnos = 0;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FormularioAlumno().setVisible(true);
        });
    }
}