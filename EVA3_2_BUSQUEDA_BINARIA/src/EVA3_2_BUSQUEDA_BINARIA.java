import java.util.Scanner;
public class EVA3_2_BUSQUEDA_BINARIA {

    public static void main(String[] args) {
        int[] datos = new int[20];
        llenar(datos);
        System.out.println("PRUEBA CON SELECTION SORT: ");

        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("\nValor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El elemento esta en la posición: " + iResu);

    }

    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
    }

    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int iMin = i; //Empieza el algoritmo, mínimo es igual a la primera posición 
            for (int j = i + 1; j < datos.length; j++) { //Buscar la posición del más pequeño
                //Comparar
                if (datos[j] < datos[iMin]) {//Comparar contra el mínimo actual
                    iMin = j;
                }
                //Swap
                if (i != iMin) {
                    //3 PASOS   
                    //1-Respaldar valor
                    int iTemp = datos[i];
                    //2-Intercambiar valor
                    datos[i] = datos[iMin];
                    //3-Reponer valor respaldado
                    datos[iMin] = iTemp;
                }
            }
        }
    }

    //Búsqueda binaria recursiva O(LogN)
    public static int binarySearch(int[] datos, int valBuscar) {
        return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
    }

    private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin) {
        int iMid, iResu;
        iMid = ini + ((fin - ini) / 2); //Posición a la mitad de la busqueda
        iResu = -1; //Si no existe valor, regresar -1
        if (fin >= ini) { //Buscamos
            if (valBuscar == datos[iMid]) { //El valor esta a la mitad 
                iResu = iMid; //Encontrar valor y regresar 

            } else if (valBuscar < datos[iMid]) { //No esta a la mitad, pero puede estar en izq
                iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
            } else {//No esta a la mitad, pero puede estar en der
                iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            }
        } //Se detiene el proceso 
        return iResu;

    }
}
