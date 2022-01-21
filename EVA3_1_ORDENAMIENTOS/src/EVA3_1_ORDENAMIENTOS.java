
public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        //Vamos a ordenar arreglos (INT)
        int[] datos = new int[10];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBubble = new int[datos.length];
        int[] copiaQuickSort = new int[datos.length];
        long iniT, finT;
        llenar(datos);//Enviar el arreglo a llenar
        System.out.println("Prueba con selection sort : ");
        imprimir(datos);//Imprimir el contenido
        iniT = System.nanoTime();//Tiempo antes de empezar el método
        selectionSort(datos);
        finT = System.nanoTime();//Tiempo al terminar el método
        imprimir(datos);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
                System.out.println("PRUEBA CON INSERTION SORT: ");
        duplicar(datos, copiaSel);
        imprimir(copiaSel);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        selectionSort(copiaSel);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaSel);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON SELECTION SORT: ");
        duplicar(datos, copiaIns);
        imprimir(copiaIns);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        insertionSort(copiaIns);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaIns);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON BUBBLE SORT: ");
        duplicar(datos, copiaBubble);
        imprimir(copiaBubble);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        bubbleSort(copiaBubble);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaBubble);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON QUICK SORT: ");
        duplicar(datos, copiaQuickSort);
        imprimir(copiaQuickSort);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        quickSort(copiaQuickSort);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaQuickSort);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));
    }
    
    
    //MÉTODOS
    
    //Llenar arreglo con valores aleatorios 0 - 99
    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);

        }
    }

    //Copiar arreglo
    //Imprimir arerglo
    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.println("[" + datos[i] + "]");
        }
        System.out.println("");
    }
     //Duplicar arreglo(arreglos del mismo tamaño)
    public static void duplicar(int[] datos, int[] copia) {
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }
    
    
    //SORTS
    
    //Eficiencia O(N^2) 
    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int iMin = i; //Empieza el algoritmo, el mínimo es el primer elemento
            for (int j = i + 1; j < datos.length; j++) {
                //Comparar
                //Valor [j] vs valor[min]
                if (datos[j] < datos[iMin]) { //Comparar actual vs mínimo actual
                    iMin = j;

                }
            }
            //Intercambio
            if (i != iMin) {
                //3 pasos
                //1-Respaldar un valor
                int iTemp = datos[i];
                //2-Intercambiar un valor
                datos[i] = datos[iMin];
                //3-Reponer el valor respaldado
                datos[i] = iTemp;
            }
        }
    }

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i]; //Valor a insertar
            int insP = i; //Posición donde insertaremos
            for (int prev = i - 1; prev >= 10; prev--) { //Buscar donde insertar
                if (datos[prev] > temp) {
                    datos[insP] = datos[prev]; //Mover valor de prev a la posición de insP
                    insP--; //Retroceder una posición
                } else {
                    break;
                }
            }
            //Insertar
            datos[insP] = temp;
        }

    }

    public static void bubbleSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) { //Pasar
            for (int j = 0; j < (datos.length - 1); j++) { //Comparar e intercambiar
                //Comparar j vs j+1
                if (datos[j] > datos[j + 1]) {
                    //Intercambiar
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }

            }
        }
    } //QuickSort de arranque

    public static void quickSort(int[] datos) { //O(NlogN) Logaritmo base 2
        quickSortRecu(datos, 0, datos.length - 1); //QuickSort a todo el arreglo
    }

    public static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote; //Iniciar
        int too_big;//Buscar mas grandes que pivote
        int too_small; //Buscar mas pequeños que pivote
        boolean stopBig = false, stopSmall = false;
        //control recursividad
        int tama = fin - ini + 1;
        if (tama > 1) { //¿Cuando si puedo realizar quikSort?
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for (int i = ini + 1; i <= fin; i++) {
                if ((datos[too_big] < datos[iPivote]) && (!stopBig)) { //Avanzar
                    too_big++;
                } else {
                    stopBig = true;//Detener cuando encuentre más grande
                }
                if ((datos[too_small] >= datos[iPivote]) && (!stopSmall)) { //Avanzo
                    too_small--;
                } else {
                    stopSmall = true;//Me detengo cuando encuentro uno más grande 
                }
                //Ambos se detienen (swap)
                if (stopBig && stopSmall) {
                    if (too_big < too_small) { //Intercambio
                        int temp = datos[too_big];
                        datos[too_big] = datos[too_small];
                        datos[too_small] = temp;
                        stopBig = false;
                        stopSmall = false; //Seguir avanzando                   
                    } else {
                        break;//Termina el ciclo  
                    }
                }
            }
            //Intercambiar pivote
            int temp = datos[iPivote];
            datos[iPivote] = datos[too_small];
            datos[too_small] = temp;
            iPivote = too_small;//Tambien cambia posición del pivote
//QuickSort izq
            quickSortRecu(datos, ini, iPivote-1);
//QuickSort der
            quickSortRecu(datos, iPivote + 1, fin);
        }
    }
}
