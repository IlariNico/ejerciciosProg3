/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp1p2;

/**
 *
 * @author ilari
 */
public class Tp1p2 {

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] arr2={2,1,5,4};
        //System.out.println(isOrder(arr));
        //System.out.println(isOrder(arr2));
        //System.out.println(BinariaRecursiva(arr,1,0,3));
        //System.out.println(binarioConvert(26));
        //System.out.println(fibonacci(6));
        System.out.println(positionEqualValue(arr));
    }
    public static boolean isOrder(int[] arr){
        return isOrder(arr,0);
    }
    
    private static boolean isOrder(int[] arr,int pos){
        if(pos==arr.length)
            return true;
        if(pos==0||(arr[pos]>arr[pos-1]))
            return isOrder(arr,++pos);
        return false;
    }
    
    public static int BinariaRecursiva(int [] A, int X, int inicio, int fin)
    {
        int medio;
        if (inicio > fin) return -1; //sucederá si no se encuentra el elemento
        else {
        medio = (inicio + fin) / 2; //al ser medio un int, se realiza un truncado (pierde la parte decimal)
        if (X > A[medio])
            return BinariaRecursiva(A, X, medio+1, fin);
        else
            if (X < A[medio])
                return BinariaRecursiva(A, X, inicio, medio -1);
            else
                return medio;
        }
    }
    
    public static String binarioConvert(int num){
        return binarioConvert(num,"");
    }
    
    private static String binarioConvert(int num,String result){
        if(num==0||num==1)
            return result+num;
        result=binarioConvert(num/2,result);
        result+=(num%2);
        return result;
    }
    
    public static String fibonacci(int limit) {
      if (limit <= 0) {
          return "";
      }
      return fibonacci(0, 1, "0", limit - 1);
  }

  private static String fibonacci(int prev, int curr, String result, int limit) {
      if (limit == 0) {
          return result;
      }
      result += ", " + curr;  
      return fibonacci(curr, prev + curr, result, --limit);
  }
  public static boolean positionEqualValue(int[] arr){
      return positionEqualValue(arr,0);
  }
  
  private static boolean positionEqualValue(int[] arr,int pos){
      if(pos==arr.length)
          return false;
      if(arr[pos]==pos)
          return true;
      return false||positionEqualValue(arr,++pos);
  }
  
      public static void ordenarPorSeleccion(int[] arreglo) {
        int n = arreglo.length;
        
        // Recorremos todo el arreglo
        for (int i = 0; i < n-1; i++) {
            // Encontrar el mínimo elemento en el arreglo no ordenado
            int indiceMinimo = i;
            for (int j = i+1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            
            // Intercambiar el elemento mínimo encontrado con el primer elemento
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }
      
    public static void ordenarPorBurbuja(int[] arreglo) {
        int n = arreglo.length;
        boolean huboIntercambio;
        
        // Recorremos el arreglo varias veces
        for (int i = 0; i < n-1; i++) {
            huboIntercambio = false;
            
            // Los últimos i elementos ya están en su lugar
            for (int j = 0; j < n-i-1; j++) {
                // Comparar elementos adyacentes
                if (arreglo[j] > arreglo[j+1]) {
                    // Intercambiar elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                    huboIntercambio = true;
                }
            }
            
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }
    }
    
        public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // El arreglo ya está ordenado o es inválido
        }
        int[] temp = new int[arr.length]; // Arreglo temporal para mezclar
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // Método recursivo para dividir y ordenar
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Punto medio para dividir
            
            // Ordenar primera mitad
            mergeSort(arr, temp, left, mid);
            
            // Ordenar segunda mitad
            mergeSort(arr, temp, mid + 1, right);
            
            // Mezclar las mitades ordenadas
            merge(arr, temp, left, mid, right);
        }
    }

    // Método para mezclar dos subarreglos ordenados
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copiar ambas mitades al arreglo temporal
        System.arraycopy(arr, left, temp, left, right - left + 1);
        
        int i = left; // Índice para la mitad izquierda
        int j = mid + 1; // Índice para la mitad derecha
        int k = left; // Índice para el arreglo resultante

        // Mezclar las dos mitades
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        
        // Copiar los elementos restantes de la izquierda (si hay)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        // No necesitamos copiar la derecha porque ya está en su lugar
    }
    
        public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // El arreglo ya está ordenado o es inválido
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // Método recursivo para QuickSort
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Obtener el índice del pivote después de la partición
            int pivotIndex = partition(arr, low, high);
            
            // Ordenar recursivamente los elementos antes y después del pivote
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Seleccionamos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño
        
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                swap(arr, i, j);
            }
        }
        
        // Intercambiar arr[i+1] y arr[high] (o el pivote)
        swap(arr, i + 1, high);
        
        return i + 1;
    }

    // Método auxiliar para intercambiar elementos
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
