
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ActividadSWT {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Actividad 1.1 SWT");
        shell.setSize(300, 200);

        Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        combo.setBounds(50, 40, 200, 30);

        combo.add("Puesto 12");
        combo.add("Puesto 13");  
        combo.add("Puesto 7");   

        Button boton = new Button(shell, SWT.PUSH);
        boton.setText("Aceptar");
        boton.setBounds(100, 90, 100, 30);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}