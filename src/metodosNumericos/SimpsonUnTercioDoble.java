package metodosNumericos;

import funciones.Funcion;
import matriz.Matriz;

public class SimpsonUnTercioDoble {

    public static double calcular(Funcion f, int subIntervaloX, int subIntervaloY,
            double a, double b, double c, double d) {
        double resultado = 0;
        //calcular pasos
        double k = (d - c) / subIntervaloY;
        double h = (b - a) / subIntervaloX;

        double[][] m = new double[subIntervaloX + 1][subIntervaloY + 1];
        double[] tempXY = new double[2];
        double i = a;
        double j = c;
        int fila = 0;
        int columna = 0;
        //llenar matriz m 
        while (j <= d) {
            while (i <= b) {
                tempXY[0] = i;
                tempXY[1] = j;
                m[fila][columna] = f.valor(tempXY);
                i += h;
                columna++;
            }
            columna = 0;
            i = a;
            j += k;
            fila++;
        }
        double[][] Aprima = calcularAprima(m.length);
        System.out.println(Matriz.toString(Aprima));
        double[] A = calcularA(m.length);
        double[][] I = Matriz.multiplicar(m, Aprima);
        resultado = multiplicarIs(Matriz.multiplicar(A, (k / 3)), (Matriz.multiplicar(I, (h / 3))));
        return resultado;
    }

    private static double[][] calcularAprima(int tam) {
        double[][] res = new double[tam][1];
        res[0][0] = 1;
        res[tam - 1][0] = 1;
        for (int i = 1; i < tam - 1; i++) {
            if (i % 2 == 0) {
                res[i][0] = 2;
            } else {
                res[i][0] = 4;
            }
        }
        return res;
    }

    private static double[] calcularA(int tam) {
        double[] res = new double[tam];
        res[0] = 1;
        res[tam - 1] = 1;
        for (int i = 1; i < tam - 1; i++) {
            if (i % 2 == 0) {
                res[i] = 2;
            } else {
                res[i] = 4;
            }
        }
        return res;
    }

    private static double multiplicarIs(double[] A, double[][] B) {
        /*A debe ser 1xn y B debe ser de nx1 */
        double res = 0;
        int mA = A.length;
        for (int i = 0; i < mA; i++) {
            res += A[i] * B[i][0];
        }
        return res;

    }
}
