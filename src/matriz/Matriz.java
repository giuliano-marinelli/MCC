package matriz;

public class Matriz {

    public static double[][] sumar(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static double[][] restar(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static double[] restar(double[] A, double[] B) {
        int m = A.length;
        int n = B.length;
        if (n != m) {
            throw new RuntimeException("Error, dimensiones de matrices inoperables.");
        }
        double[] C = new double[m];
        for (int i = 0; i < m; i++) {
            C[i] = A[i] - B[i];
        }
        return C;
    }

    public static double[][] multiplicar(double[][] A, double[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) {
            throw new RuntimeException("Error, dimensiones de matrices inoperables.");
        }
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nB; j++) {
                for (int k = 0; k < nA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static double[] multiplicar(double[][] A, double[] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        if (nA != mB) {
            throw new RuntimeException("Error, dimensiones de matrices inoperables.");
        }
        double[] C = new double[mA];
        for (int i = 0; i < mA; i++) {
            for (int k = 0; k < nA; k++) {
                C[i] += A[i][k] * B[k];
            }
        }
        return C;
    }

    public static double[] multiplicar(double[] A, double escalar) {
        int mA = A.length;
        double[] C = new double[mA];
        for (int i = 0; i < mA; i++) {
            C[i] = A[i] * escalar;
        }
        return C;
    }

    public static double[][] multiplicar(double[][] A, double escalar) {
        int mA = A.length;
        int nA = A[0].length;
        double[][] C = new double[mA][nA];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nA; j++) {
                C[i][j] = A[i][j] * escalar;
            }
        }
        return C;
    }

    public static double[] gauss(double[][] A, double[] b) {
        int N = b.length;
        for (int p = 0; p < N; p++) {
            // Buscar pivot e intercambiar filas
            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            // la matriz no es inversible, (a(ij) con i=j es cero)
            if (Math.abs(A[p][p]) == 0) {
                throw new RuntimeException("La matriz no se puede triangular.");
            }

            // pivot entre A y b
            double mult;
            for (int i = p + 1; i < N; i++) {
                /*se busca el multiplicador para hacer cero los valores de abajo
                 y se aplican las operaciones elementales en ambas matrices*/
                mult = A[i][p] / A[p][p];
                b[i] -= mult * b[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= mult * A[p][j];
                }
            }
        }

        // aplicar sustitucion hacia atras.
        double[] x = new double[N];
        double sum;
        for (int i = N - 1; i >= 0; i--) {
            sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    public static double[][] invertir(double[][] m) {

        double[][] matriz = m;
        double[][] matrizTemp = new double[2][2];
        if (matriz.length == 2 && matriz[0].length == 2) {
            double determinante = matriz[0][0] * matriz[1][1] - matriz[1][0] * matriz[0][1];
            double temp = matrizTemp[0][0];
            matrizTemp[0][0] = matriz[1][1] / determinante;
            matrizTemp[1][1] = matriz[0][0] / determinante;
            matrizTemp[0][1] = matriz[0][1] * -1 / determinante;
            matrizTemp[1][0] = matriz[1][0] * -1 / determinante;
        }
        return matrizTemp;
    }

    public static String toString(double[] m) {
        String res = "[";
        for (int i = 0; i < m.length; i++) {
            res += m[i];
            if (i != m.length - 1) {
                res += ",";
            }
        }
        res += "]";
        return res;
    }

    public static String toString(double[][] m) {
        String res = "[";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                res += m[i][j];
                if (j < m[0].length - 1) {
                    res += ",";
                }
            }
            if (i < m.length - 1) {
                res += "\n";
            }
        }
        res += "]";
        return res;
    }

    /*public static void gauss(double[][] A, double[] B) {
     int n = A.length - 1;
     double[] X = new double[n + 1];
     double[][] S = new double[n + 1][n + 1];
     //System.out.println(Arrays.toString(A[0])+","+Arrays.toString(A[1])+","+Arrays.toString(A[2]));
     //System.out.println(Arrays.toString(B));
     //System.out.println(Arrays.toString(X));
     int k = 1;
     int i;
     while (k <= (n - 1)) {
     i = k + 1;
     while (i <= n) {
     int j = k + 1;
     double m = (-A[i][k]) / A[k][k];
     while (j <= n) {
     A[i][j] = A[i][j] + m * A[k][j];
     j = j + 1;
     }
     B[i] = B[i] + m * B[k];
     i++;
     }
     k++;
     }
        
     X[n] = B[n] / A[n][n];
     System.out.println("X[n]=" + X[n]);
     //System.out.println(Arrays.toString(A[0])+","+Arrays.toString(A[1])+","+Arrays.toString(A[2]));
     //System.out.println(Arrays.toString(B));
     //System.out.println(Arrays.toString(X));
     i = n-1;
     int j;
     while (i <= 1) {
     j = i + 1;
     double s = 0;
     while (j <= n) {
     s = s + S[i][j] * X[j];
     j++;
     }
     X[i] = (B[i] - s) / A[i][i];
     System.out.println("X[" + i + "]=" + X[i]);
     i--;
     }
     }*/
}
