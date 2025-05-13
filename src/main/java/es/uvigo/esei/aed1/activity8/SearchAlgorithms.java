package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    //Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor) {
        int rows = aux.length;
        int cols = aux[0].length;
        if (xPosition < 0 || xPosition >= rows || yPosition < 0 || yPosition >= cols) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        int originalColor = aux[xPosition][yPosition];
        if (originalColor == newColor) return;

        // arranca el flood-fill indicando también startRow = xPosition
        fillInHelper(aux, xPosition, yPosition, originalColor, newColor, xPosition);
    }

    private static void fillInHelper(int[][] aux, int x, int y, int originalColor, int newColor, int startRow) {
        int rows = aux.length;
        int cols = aux[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols) return;
        if (aux[x][y] != originalColor) return;

        // pintamos
        aux[x][y] = newColor;

        // siempre expandimos verticalmente
        fillInHelper(aux, x - 1, y, originalColor, newColor, startRow);
        fillInHelper(aux, x + 1, y, originalColor, newColor, startRow);

        // SOLO en la fila de inicio permitimos horizontal
        if (x == startRow) {
            fillInHelper(aux, x, y - 1, originalColor, newColor, startRow);
            fillInHelper(aux, x, y + 1, originalColor, newColor, startRow);
        }
    }

    //Exercise 2
    public static boolean isMagicSquare(int[][] board, int magicConstant) {
        int n = board.length;

        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;

        int sumRow;
        int sumCol;

        //Every row & column.
        for (int i = 0; i < n; i++) {
            sumRow = 0;
            sumCol = 0;

            //We can do this since it's a square matrix.
            for (int j = 0; j < n; j++) {
                sumRow += board[i][j];
                sumCol += board[j][i];
            }

            if (sumRow != magicConstant || sumCol != magicConstant) {
                return false;
            }

            sumDiagonal1 += board[i][i];
            sumDiagonal2 += board[i][n - i - 1];
        }

        return sumDiagonal1 == magicConstant && sumDiagonal2 == magicConstant;
    }

    //Exercise 3
    //  - aux, es el array de números enteros clasificados en orden creciente. Puede contener
    //  elementos repetidos.

    //  - elem, es el elemento sobre el que quiero saber cuántos menores que él hay
    public static int howManyMinors(int[] aux, int elem) {
        int inicio = 0;
        int fin = aux.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (aux[medio] < elem) {
                inicio = medio + 1;
            } else if (aux[medio] > elem) {
                fin = medio - 1;
            } else {
                while (medio > 0 && aux[medio - 1] == elem) {
                    medio--;
                }
                return medio;
            }
        }

        return inicio;
    }

    //Exercise 4
    public static int howManyOlder(int[] aux, int elem) {
        int inicio = 0;
        int fin = aux.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (aux[medio] <= elem) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return aux.length - inicio;
    }

    //Exercise 5

    public static int containNumber(int[] array, int beginning, int fin) {
        if (beginning > fin) {
            return -1;
        }
        int mid = (beginning + fin) / 2; // O(log n)

        if (array[mid] == mid) {
            return mid; // Encontrado
        } else if (array[mid] > mid) {
            return containNumber(array, beginning, mid - 1); // Solo puede estar a la izquierda
        } else {
            return containNumber(array, mid + 1, fin); // Solo puede estar a la derecha
        }

    }

    //Exercise 6
    public static int searchInsertionDec(int[] aux, int elem, int max) {
        int inicio = 0;
        int fin = max - 1;
        int medio = 0;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;

            if (aux[medio] == elem) {
                return medio;
            } else if(aux[medio] > elem) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        //Si llegamos aquí no encontramos el elemento, pero "medio" está en la posición correcta
        //para insertarlo en orden decreciente

        System.out.println("El elemento " + elem + " se puede insertar en la posición " + inicio);

        for (int i = max + 1; i > inicio; i--) {
            aux[i] = aux[i - 1];
        }

        aux[inicio] = elem;

        return inicio;
    }

}
