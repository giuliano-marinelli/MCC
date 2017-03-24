package applet;

import funciones.*;

public class Intermediario {

    private Funcion operando1;
    private Funcion operando2;
    private Funcion funcion;
    private int operacionPendiente;
    private final int NINGUNA = -1;
    private final int SUMA = 0;
    private final int RESTA = 1;
    private final int MULT = 2;
    private final int DIV = 3;
    private final int SEN = 4;
    private final int COS = 5;
    private final int TAN = 6;
    private final int ATAN = 7;
    private final int EXP = 8;
    private final int ABS = 9;
    private final int SQRT = 10;
    private final int LOG = 11;

    public Intermediario() {
        funcion = null;
        operacionPendiente = NINGUNA;
    }

    public void setOperando(Funcion op) {
        if (operando1 == null) {
            operando1 = op;
            System.out.println("se setio op1: " + operando1.toString());
        } else if (operacionPendiente != NINGUNA) {
            operando2 = op;
            System.out.println("se setio op2: " + operando2.toString() + "con operacion: " + operacionPendiente);
            crearFuncionBinaria();
            System.out.println("la funcion que se creo: " + funcion.getClass() + " con: " + funcion.toString());
        }
    }

    //Funciones binarias
    public void sumar() {

        operacionPendiente = SUMA;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    public void restar() {
        operacionPendiente = RESTA;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    public void multiplicar() {
        operacionPendiente = MULT;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    public void dividir() {
        operacionPendiente = DIV;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    public void raizCuadrada() {
        operacionPendiente = SQRT;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    public void exp() {
        operacionPendiente = EXP;
        if (operando1 == null) {
            operando1 = funcion;
            if (funcion == null) {
                operacionPendiente = NINGUNA;
            }
        }
    }

    //funciones unarias
    public void sen() {
        operacionPendiente = SEN;
        if (operando1 != null) {
            funcion = getFuncion();
            System.out.println("crea la funcion: " + funcion.toString());
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
                System.out.println("crea la funcion: " + funcion.toString());
            }
        }
    }

    public void cos() {
        operacionPendiente = COS;
        if (operando1 != null) {
            funcion = getFuncion();
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
            }
        }
    }

    public void tan() {
        operacionPendiente = TAN;
        if (operando1 != null) {
            funcion = getFuncion();
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
            }
        }
    }

    public void atan() {
        operacionPendiente = ATAN;
        if (operando1 != null) {
            funcion = getFuncion();
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
            }
        }
    }

    public void abs() {
        operacionPendiente = ABS;
        if (operando1 != null) {
            funcion = getFuncion();
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
            }
        }
    }

    public void log() {
        operacionPendiente = LOG;
        if (operando1 != null) {
            funcion = getFuncion();
        } else {
            if (funcion != null) {
                operando1 = funcion;
                funcion = getFuncion();
            }
        }
    }

    //Acciones
    public void crearPolinomio(String coef) {
        coef = coef.trim();
        double[] coeficientes = extraerCoef(coef);
        funcion = new FuncionPolinomica(coeficientes);
    }

    public Funcion derivar() {
        return funcion.derivar();
    }

    public Funcion derivar(int indice) {
        return funcion.derivar(indice);
    }

    //es como derivar(int indice) solo que el indice lo calcula segun la variable
    public Funcion derivar(String var) {
        int indice = 0;
        indice = buscarVariable(var);
        //obtener el indice segun la variable
        return funcion.derivar(indice);
    }

    public double valor(double[] x) {
        return funcion.valor(x);
    }

    public double valor(double x) {
        return funcion.valor(x);
    }

    public void borrarFuncion() {
        funcion = null;
        operando1 = null;
        operando2 = null;
        operacionPendiente = NINGUNA;
    }

    //propias de la clase
    private double[] extraerCoef(String coef) {
        double[] res;
        String[] temp;
        temp = coef.split(" ");
        res = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = Integer.parseInt(temp[i]);
        }
        return res;
    }

    private int buscarVariable(String var) {
        int i = 0;

        switch (var) {
            case "x":
                i = 0;
                break;
            case "y":
                i = 1;
                break;
            case "z":
                i = 2;
                break;
            case "w":
                i = 3;
                break;
        }
        return i;
    }

    private void crearFuncionBinaria() {
        funcion = getFuncion();
        operando1 = null;
        operando2 = null;
        operacionPendiente = NINGUNA;
    }

    private Funcion getFuncion() {
        Funcion res = null;
        switch (operacionPendiente) {
            case SUMA:
                res = new FuncionBinaria(operando1, "+", operando2);
                break;
            case RESTA:
                res = new FuncionBinaria(operando1, "-", operando2);
                break;
            case MULT:
                res = new FuncionBinaria(operando1, "*", operando2);
                break;
            case DIV:
                res = new FuncionBinaria(operando1, "/", operando2);
                break;
            case SEN:
                res = new FuncionUnaria("sen", operando1);
                break;
            case COS:
                res = new FuncionUnaria("cos", operando1);
                break;
            case TAN:
                res = new FuncionUnaria("tan", operando1);
                break;
            case ATAN:
                res = new FuncionUnaria("atan", operando1);
                break;
            case EXP:
                res = new FuncionBinaria(operando1, "pow", operando2);
                break;
            case ABS:
                res = new FuncionUnaria("abs", operando1);
                break;
            case SQRT:
                res = new FuncionBinaria(operando1, "sqrt", operando2);
                break;
            case LOG:
                res = new FuncionUnaria("log", operando1);
                break;
        }

        return res;
    }

    private String getOperacion() {
        String res = "";
        switch (operacionPendiente) {
            case SUMA:
                res = "+";
                break;
            case RESTA:
                res = "-";
                break;
            case MULT:
                res = "*";
                break;
            case DIV:
                res = "/";
                break;
            case SEN:
                res = "sen";
                break;
            case COS:
                res = "cos";
                break;
            case TAN:
                res = "tan";
                break;
            case ATAN:
                res = "atan";
                break;
            case EXP:
                res = "pow";
                break;
            case ABS:
                res = "abs";
                break;
            case SQRT:
                res = "sqrt";
                break;
            case LOG:
                res = "log";
                break;
        }

        return res;
    }

    public String escribirFuncion() {
        String res = "";
        if (funcion != null) {
            res = funcion.toString();
        } else if (operando1 != null) {
            res = operando1.toString();
            if ((operacionPendiente > -1 && operacionPendiente < 4)
                    || operacionPendiente == 8 || operacionPendiente == 10) {
                res += getOperacion();
            }
        }
        return res;
    }
}
