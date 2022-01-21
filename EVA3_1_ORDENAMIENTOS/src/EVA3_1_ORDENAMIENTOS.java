
public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        //Vamos a ordenar arreglos (INT)
        int[] datos = new int[10];
        long iniT, finT;
        llenar(datos);//Enviar el arreglo a llenar
        System.out.println("Prueba con selection sort : ");
        imprimir(datos);//Imprimir el contenido
        iniT = System.nanoTime();//Tiempo antes de empezar el método
        selectionSort(datos);
        finT =  System.nanoTime();//Tiempo al terminar el método
        imprimir(datos);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
    }

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
            if(i != iMin){
                //3 pasos
                //Respaldar un valor
                int iTemp = datos[i];
                //Intercambiar un valor
                datos[i] = datos[iMin];
                //Reponer el valor respaldado
                datos[i] = iTemp;
        }
        }
    }
    
    public static void insertionSort(int[] datos){
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i]; //Valor a insertar
            int insP = i; //Posición donde insertaremos
            for (int prev = i - 1; prev >= 10; prev--) { //Buscar donde insertar
                if(datos[prev] > temp){
                    datos[insP] = datos[prev]; //Mover valor de prev a la posición de insP
                    insP--; //Retroceder una posición
                }else{
                    break;
                }
            }
            //Insertar
            datos[insP] = temp;
        }
        
    }
}
