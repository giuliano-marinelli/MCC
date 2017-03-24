package funciones;

public abstract class Funcion {

    public abstract double valor(double[] x);

    public double valor(double x) {
        double[] aux = {x};
        return valor(aux);
    }

    /**
     * ARREGLAR DERIVAR, SI SE PONE UN INDICE QUE NO ESTA EN EL ARREGLO DERIVA
     * TODAS LAS VARIABLEES
     *
     * @return
     */
    public abstract Funcion derivar();

    /**
     * ARREGLAR DERIVAR, SI SE PONE UN INDICE QUE NO ESTA EN EL ARREGLO DERIVA
     * TODAS LAS VARIABLEES
     *
     * @return
     */
    public abstract Funcion derivar(int indice);

    public abstract String toString();

}
