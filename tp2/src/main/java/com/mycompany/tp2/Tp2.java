/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp2;

/**
 *
 * @author ilari
 */
public class Tp2 {

    public static void main(String[] args) {
        Tree arbol= new Tree();
        arbol.add(10);
        arbol.add(8);
        arbol.add(12);
        arbol.add(9);
        //System.out.println(arbol.getHeight());
        //System.out.println(arbol.getLongestBranch());
        //System.out.println(arbol.getListFrontera());
        //System.out.println(arbol.getMaxElem());
        //System.out.println(arbol.suma());
        System.out.println(arbol.getHojasMayor(12));
    }
   
    public static void rellenarArbol(Tree t){
        rellenarArbol(t.getRootNode());
    }
    
    public static void rellenarArbol(TreeNode n){
        if( n==null || n.esHoja())//interpreto vacio como esto
            return;
        rellenarArbol(n.getIzq());
        rellenarArbol(n.getDer());
        int valIz=n.getIzq()!=null ? n.getIzq().getValor():0;
        int valDer=n.getDer()!=null ? n.getDer().getValor():0;
        n.setValor(valDer-valIz);
        
    }

}
