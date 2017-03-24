package metodosNumericos;

import funciones.Funcion;
import matriz.Matriz;

public class NewtonRaphsonNoLineal {

    public static double[] calcular(Funcion[] f, double[] punto, double e) {
        double[] x;
        double max = 0;
        Funcion[][] J;
        double[][] JRes;
        double[] fRes;
        do {
            max = 0;
            J = jacobiana(f);
            int tam = J.length;
            JRes = new double[tam][tam];
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    JRes[i][j] = J[i][j].valor(punto);
                }
            }
            JRes = Matriz.invertir(JRes);
            fRes = new double[tam];
            for (int i = 0; i < tam; i++) {
                fRes[i] = f[i].valor(punto);
            }
            x = Matriz.restar(punto,Matriz.multiplicar(JRes, fRes));
            double[] temp = Matriz.restar(punto, x);
            for (int i = 0; i < temp.length; i++) {
                max = (Math.abs(temp[i]) >= max) ? temp[i] : max;
            }
            punto = x;
            System.out.println("x="+Matriz.toString(x));
            System.out.println("e="+max);
        } while (max >= e);
        return x;
    }

    private static Funcion[][] jacobiana(Funcion[] f) {
        int tam = f.length;
        Funcion[][] res = new Funcion[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                res[i][j] = f[i].derivar(j);
            }
        }
        return res;
    }

}
