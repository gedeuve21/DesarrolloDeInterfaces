import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Actividad4 extends JFrame {

    
    private final Dimension tamOriginal = new Dimension(400, 300);
    private final Dimension tamPredeterminado = new Dimension(600, 400);

    public Actividad4() {
        setTitle("Actividad 4 - Interfaz Gráfica Swing");
        setSize(tamOriginal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(true);         

        setLayout(new FlowLayout());

        JButton btnColor = new JButton("Cambiar color de fondo");
        JButton btnRedimensionar = new JButton("Redimensionar a 600x400");
        JButton btnRestaurar = new JButton("Restaurar tamaño original");

        add(btnColor);
        add(btnRedimensionar);
        add(btnRestaurar);

        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Color colorAleatorio = new Color(rand.nextInt(256),
                                                 rand.nextInt(256),
                                                 rand.nextInt(256));
                getContentPane().setBackground(colorAleatorio);
            }
        });

        btnRedimensionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(tamPredeterminado);
            }
        });

        btnRestaurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(tamOriginal);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Actividad4().setVisible(true);
            }
        });
    }
}