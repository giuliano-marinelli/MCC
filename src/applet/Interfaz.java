package applet;

import funciones.Funcion;
import funciones.FuncionBinaria;
import funciones.FuncionConstante;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz extends JApplet {

    private PanelDibujo pd;
    private JTextField campoTextoConstante;
    private Funcion func;
    private String variable;
    private Intermediario inter;
    private JPanel pdatos;
    private int posBotonX;
    private int posBotonY;
    private JLabel error;
    private JLabel resultado;
    private double[] valor;
    private int cantVariables;

    public void init() {
        inter = new Intermediario();
        resultado = new JLabel();
        pd = new PanelDibujo(inter, resultado);
        pdatos = new JPanel();
//        posBotonX = 50;
//        posBotonY = 50;
        pdatos.setLayout(new GridLayout(6, 6));
        error = new JLabel();
        ponerBotones();
    }

    public void ponerBotones() {
        JButton sumar = new JButton("+");
        sumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.sumar();
                pd.repaint();
                repaint();
            }
        });

        JButton restar = new JButton("-");
        restar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                pd.repaint();
                inter.restar();
                repaint();
            }
        });

        JButton multiplicar = new JButton("*");
        multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                pd.repaint();
                inter.multiplicar();
                repaint();
            }
        });

        JButton dividir = new JButton("/");
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.dividir();
                pd.repaint();
                repaint();
            }
        });

        JButton sen = new JButton("sen");
        sen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.sen();
                pd.repaint();
                repaint();
            }
        });

        JButton cos = new JButton("cos");
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.cos();
                pd.repaint();
                repaint();
            }
        });

        JButton tan = new JButton("tan");
        tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.tan();
                pd.repaint();
                repaint();
            }
        });

        JButton atan = new JButton("atan");
        atan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.atan();
                pd.repaint();
                repaint();
            }
        });

        JButton exp = new JButton("exp");
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.exp();
                pd.repaint();
                repaint();
            }
        });

        JButton log = new JButton("log");
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.log();
                pd.repaint();
                repaint();
            }
        });

        JButton abs = new JButton("abs");
        abs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.abs();
                pd.repaint();
                repaint();
            }
        });

        JButton derivar = new JButton("derivar");
        derivar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                inter.derivar(variable);
                pd.repaint();
                repaint();
            }
        });
        JButton calcular = new JButton("Calcular");
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //accion
                resultado.setText(""+inter.valor(valor));
                pd.repaint();
                repaint();
            }
        });

        campoTextoConstante = new JTextField(10);
        JButton ingresarConstante = new JButton("Ingresar");
        ingresarConstante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inter.setOperando(new FuncionConstante(Integer.parseInt(campoTextoConstante.getText())));
                pd.repaint();
                repaint();
            }
        });

        campoTextoConstante = new JTextField(10);
        JButton cantVar = new JButton("Cantidad Variables");
        cantVar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantVariables = Integer.parseInt(campoTextoConstante.getText());
                valor = new double[cantVariables];
                pd.repaint();
                repaint();
            }
        });
        
        campoTextoConstante = new JTextField(10);
        
        JButton derivarVar = new JButton("Derivar variable");
        derivarVar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                variable = (campoTextoConstante.getText());
                pd.repaint();
                repaint();
            }
        });
        
        
        

        JButton borrar = new JButton("Borrar todo");
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
                /*posiblemente haya que reemplazar func = null por
                 func.reset() para poner sus operandos en null y no la funcion
                 */
                inter.borrarFuncion();
                pd.repaint();
                repaint();
            }
        });
        
        JButton polinomio = new JButton("Crear polinomio");
        polinomio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coef;
                coef = campoTextoConstante.getText();
                inter.crearPolinomio(coef);
                pd.repaint();
                repaint();
            }
        });
        
        


        pdatos.add(sumar);
        pdatos.add(restar);
        pdatos.add(multiplicar);
        pdatos.add(dividir);
        pdatos.add(sen);
        pdatos.add(cos);
        pdatos.add(tan);
        pdatos.add(atan);
        pdatos.add(exp);
        pdatos.add(log);
        pdatos.add(abs);
        pdatos.add(derivar);
        pdatos.add(campoTextoConstante);
        pdatos.add(ingresarConstante);
        pdatos.add(calcular);
        pdatos.add(cantVar);
        pdatos.add(polinomio);

        pdatos.add(error);
        pdatos.add(resultado);
        pdatos.add(borrar);

        add(pd);

        add(pdatos, BorderLayout.SOUTH);
    }
}

//        sumar.setBounds(posBotonX, posBotonY, 30, 30);
//        restar.setBounds(posBotonX+10, posBotonY, 30, 30);
//        multiplicar.setBounds(posBotonX+20, posBotonY, 30, 30);
//        dividir.setBounds(posBotonX+30, posBotonY, 30, 30);
//        sen.setBounds(posBotonX, posBotonY+20, 30, 30);
//        cos.setBounds(posBotonX+10, posBotonY+20, 30, 30);
//        tan.setBounds(posBotonX+20, posBotonY+20, 30, 30);
//        atan.setBounds(posBotonX+30, posBotonY+20, 30, 30);
//        exp.setBounds(posBotonX, posBotonY+40, 30, 30);
//        log.setBounds(posBotonX+10, posBotonY+40, 30, 30);
//        abs.setBounds(posBotonX+20, posBotonY+40, 30, 30);
//        derivar.setBounds(posBotonX+30, posBotonY+40, 30, 30);
