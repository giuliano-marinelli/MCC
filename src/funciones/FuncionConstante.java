package funciones;

public class FuncionConstante extends Funcion {

    double valor;

    public FuncionConstante(double valor) {
        this.valor = valor;
    }

    @Override
    public double valor(double[] x) {
        return valor;
    }

    @Override
    public Funcion derivar() {
        return new FuncionConstante(0);
    }

    @Override
    public Funcion derivar(int indice) {
        return new FuncionConstante(0);
    }

    @Override
    public String toString() {
        String res;
        if (valor >= 0) {
            res = "" + valor;
        } else {
            res = "(" + valor + ")";
        }
        int i = res.length() - 1;
        String aux = "";
        boolean flag = true;
        while (i > 0 && flag) {
            if (res.charAt(i) != '.') {
                aux += res.charAt(i);
            } else {
                flag = false;
            }
            i--;
        }
        if (aux.equals("0")) {
            res = res.substring(0, res.length() - 2);
        }
        return res;
    }

}
