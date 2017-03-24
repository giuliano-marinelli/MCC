package applet;

import funciones.Funcion;
import funciones.FuncionConstante;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {

    public boolean swborrar = false;
    private Intermediario intermediario;
    private JLabel resultado;

    public PanelDibujo(Intermediario inter, JLabel res) {
        intermediario = inter;
        resultado = res;
//        func = new FuncionConstante(23);
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        if (intermediario.escribirFuncion() != null) {
            g2d.drawString(intermediario.escribirFuncion().toString(), 50, 50);
        }
        g2d.drawString(resultado.getText(), 300, 300);
    }
}
