package funciones;

public class FuncionVariable extends Funcion {

    int indice;
    String alias;

    public FuncionVariable() {
        this.indice = 0;
    }

    public FuncionVariable(int indice, String ali) {
        this.indice = indice;
        alias = ali;
    }

    @Override
    public double valor(double[] x) {
        return x[indice];
    }

    @Override
    public Funcion derivar() {
        return new FuncionConstante(1);
    }

    @Override
    public Funcion derivar(int indice) {
        FuncionConstante res;
        if (this.indice != indice) {
            res = new FuncionConstante(0);
        } else {
            res = new FuncionConstante(1);
        }
        return res;
    }

    @Override
    public String toString() {
        return alias;
    }

}
