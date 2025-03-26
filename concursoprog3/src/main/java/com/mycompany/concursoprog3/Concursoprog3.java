/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.concursoprog3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ilari
 */
public class Concursoprog3 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros=new ArrayList(Arrays.asList(1,7, 3, 8, 4, 13));
        int nroObjetivo=8;
        ArrayList<ArrayList<Integer>> resultados=sumaConjuntos(numeros,nroObjetivo);
        mostrarResultados(resultados);
    }
    
    public static ArrayList<ArrayList<Integer>> sumaConjuntos(ArrayList<Integer>numeros,int nroObjetivo){
        ArrayList<ArrayList<Integer>> resultados=new ArrayList();
        ArrayList<Integer>nrosCopy=new ArrayList(numeros);
        for(int n:numeros){
            ArrayList<Integer> solucionAct=new ArrayList();
            solucionAct.add(n);
            backTrackProf(nrosCopy,nroObjetivo,solucionAct,resultados);
        }
        return resultados;
    }
    
    public static void backTrackProf(ArrayList<Integer>numeros,int sumaObj,ArrayList<Integer> solAct,ArrayList<ArrayList<Integer>> resultados){
        int sumaAct=sumaLista(solAct);
        if(sumaAct==sumaObj){
            resultados.add(new ArrayList(solAct));
            
        }
        else if(sumaAct>sumaObj)
            return;

        for(int i=0;i<numeros.size();i++){
            int num=numeros.get(i);
            if(!solAct.contains(num)){
            solAct.add(num);
            backTrackProf(numeros,sumaObj,solAct,resultados);
            solAct.removeLast();
            }
        }
        
    }
    
    public static int sumaLista(ArrayList<Integer>lista){
        int suma=0;
        for(int i:lista){
            suma+=i;
        }
        return suma;
    }
    
    public static void mostrarLista(ArrayList<Integer>lista){
        for(int n:lista){
            System.out.print(n);
        }
        System.out.println();
    }
    
    public static void mostrarResultados(ArrayList<ArrayList<Integer>>resultados){
        for(ArrayList<Integer> sol:resultados)
            mostrarLista(sol);
    }
}
