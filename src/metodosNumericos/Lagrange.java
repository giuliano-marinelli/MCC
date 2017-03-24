package metodosNumericos;

public class Lagrange {

    /**
     *
     * @param tablaValores
     * @param valor valor a interpolar.
     * @return
     */
    public static double calcularInterpolacion(double[][] tablaValores, double valor) {
        double res = 0;
        double temp=1;
        for (int i = 0; i < tablaValores.length; i++) {
            for (int j = 0; j < tablaValores.length; j++) {
                if (j != i) {
                    temp*=(valor-tablaValores[j][0])/(tablaValores[i][0]-tablaValores[j][0]);
                }
            }
            res+=temp*tablaValores[i][1];
            temp=1;
        }
            return res;
    }
}
