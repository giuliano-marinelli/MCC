package metodosNumericos;

/**
 * Para usar Simpson con una funcion, se debe enviarle un intervalo [a,b] y la
 * cantidad de partes a dividir el intervalo. Para usar Simpson con una tabla de
 * valores, se debe enviarle una matriz con la forma (x,y) comenzando en (0,0),
 * donde (0,0) es el valor de X1 y (0,1) es el valor de f(X1). Asi el (1,0) es
 * X2 y el (1,1) es f(X2) etc. x | y ------------------------ (0,0) x1 | f(x1)
 * (0,1) (1,0) x2 | f(x2) (1,1) (2,0) x3 | f(x3) (2,1)
 *
 */
import funciones.Funcion;

public class SimpsonUnTercio {

    /**
     *
     * @param f funcion
     * @param cantPartes cantidad de partes a dividir el intervalo [a,b]
     * @param a inicio del intervalo
     * @param b fin del intervalo
     * @return
     */
    public static double calcular(Funcion f, int cantPartes, double a, double b) {
        double res = 0;
        double h = (b - a) / cantPartes; //longitud del area
        double temp = f.valor(a) + f.valor(b);
        res = h / 3 * (temp + sumarPuntos(f, h, a, b));
        return res;
    }

    private static double sumarPuntos(Funcion f, double h, double a, double b) {
        double res = 0;
        double resImpar = 0;
        double resPar = 0;
        double i = a + h;
        boolean pos = false; //false es posicion impar
        while (i <= (b - h)) {
            if (pos) {
                resPar += f.valor(i);
            } else {
                resImpar += f.valor(i);
            }
            pos = !pos;
            i += h;
        }
        res = 4 * resImpar + 2 * resPar;
        return res;
    }

    /**
     * @param tablaValores contiene la tabla X|Y.
     * @return
     */
    public static double calcular(double[][] tablaValores) {
        double res = 0;
        double h = tablaValores[1][0] - tablaValores[0][0]; //longitud del area
        double temp = tablaValores[0][1] + tablaValores[tablaValores.length - 1][1];
        res = h / 3 * (temp + sumarPuntos(tablaValores));
        return res;
    }

    private static double sumarPuntos(double[][] tablaValores) {
        double res = 0;
        double resImpar = 0;
        double resPar = 0;
        int i = 1;
        while (i < tablaValores.length - 1) {
            if (i % 2 == 0) {
                resPar += tablaValores[i][1];
            } else {
                resImpar += tablaValores[i][1];
            }
            i++;
        }
        res = 4 * resImpar + 2 * resPar;
        return res;
    }

}
