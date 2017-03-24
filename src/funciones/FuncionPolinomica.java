package funciones;

import funciones.Funcion;

public class FuncionPolinomica extends Funcion {

    double[] coeficientes;

    public FuncionPolinomica(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    
    @Override
    public double valor(double[] x) {
        return valor(x[0]);
    }

    @Override
    public double valor(double x) {
        double res = 0;
        for (int i = 0; i < coeficientes.length; i++) {
            res = res + (coeficientes[i] * Math.pow(x, i));
        }
        return res;
    }

    public FuncionPolinomica derivar() {
        FuncionPolinomica func;
        double[] cof = new double[coeficientes.length - 1];
        for (int i = 1; i < coeficientes.length; i++) {
            cof[i - 1] = coeficientes[i] * i;
        }
        func = new FuncionPolinomica(cof);
        return func;
    }
    
    public FuncionPolinomica derivar(int indice) {
        FuncionPolinomica func;
        double[] cof = new double[coeficientes.length - 1];
        for (int i = 1; i < coeficientes.length; i++) {
            cof[i - 1] = coeficientes[i] * i;
        }
        func = new FuncionPolinomica(cof);
        return func;
    }

    public double valorDerivada(double x) {
        double valor = 0.0;
        for (int i = 1; i < coeficientes.length; i++) {
            valor += coeficientes[i] * i * (Math.pow(x, i - 1));
        }
        return valor;
    }

        @Override
    public String toString() {
        String res = coeficientes[0] + " ";
        for (int i = 1; i < coeficientes.length; i++) {
            if (coeficientes[i] > 0) {
                res += " + " + coeficientes[i] + "x^" + i + " ";
            } else if (coeficientes[i] < 0) {
                res += coeficientes[i] + "x^" + i + " ";
            }
        }
        return res;
    }

}
