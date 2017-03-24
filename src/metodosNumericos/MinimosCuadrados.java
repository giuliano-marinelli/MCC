package metodosNumericos;

import funciones.Funcion;
import funciones.FuncionPolinomica;
import matriz.Matriz;

public class MinimosCuadrados {

    public static Funcion calcular(double[][] tablaValores, int grado) {
        double sum = 0;
        double[] coef;
        double[][] A = new double[grado + 1][grado + 1];
        double[] b = new double[grado + 1];
        for (int k = 0; k <= grado; k++) {
            for (int j = 0; j <= grado; j++) {
                sum = 0;
                for (int i = 0; i < tablaValores[0].length; i++) {
                    sum += Math.pow(tablaValores[0][i], j + k);
                }
                //System.out.println("a" + j + "*Ex^" + (j + k) + "=" + sum);
                A[k][j] = sum;
            }
            sum = 0;
            for (int j = 0; j < tablaValores[1].length; j++) {
                sum += Math.pow(tablaValores[0][j], k) * tablaValores[1][j];
            }
            //System.out.println("Ex^" + k + "*y=" + sum);
            b[k] = sum;
        }
        //System.out.println(Matriz.toString(A));
        //System.out.println(Matriz.toString(b));
        coef = Matriz.gauss(A, b);
        FuncionPolinomica poliAjuste = new FuncionPolinomica(coef);
        return poliAjuste;
    }

}
