package metodosNumericos;

import funciones.Funcion;

public class EulerModificado {

    public static double calcular(Funcion f, double valor, double[] intervaloX, int subIntervalos, double condicionI) {
        double y = condicionI;
        double paso = (intervaloX[1] - intervaloX[0]) / subIntervalos;
        double xi;
        //i representa la cantidad de iteraciones
        double i = 0;
        double[] xy = new double[2];
        while ((i*paso) < valor) {
            xi = i * paso;
            double yTemp = calcularEuler(f, xi, condicionI, paso);
            xy[0] = (i + 1) * paso;
            xy[1] = yTemp;
            y = calcularEulerModificado(f, paso, yTemp, xy, condicionI, xi);
            condicionI = y;
            i++;
        }
        return y;
    }

    private static double calcularEulerModificado(Funcion f, double paso, double yTemp, double[] xy, double condicionI, double xi) {
        double[] temp = {xi, condicionI};
        return condicionI + (paso / 2 * (f.valor(temp) + f.valor(xy)));
    }

    private static double calcularEuler(Funcion f, double xi, double yi, double paso) {
        double[] xy = {xi, yi};
        return yi + paso * f.valor(xy);
    }
}
