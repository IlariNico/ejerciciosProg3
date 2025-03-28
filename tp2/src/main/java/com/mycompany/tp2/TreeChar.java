/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ilari
 */
public class TreeChar {
    private TreeNodeChar raiz;
    
    public TreeChar(){
        this.raiz=null;
    }
    
    public TreeNodeChar getRootNode(){
        return this.raiz;
    }
    
    public int getRoot(){
        return this.raiz.getValor();
    }
    
    public boolean hasElem(int num){
        if(this.raiz==null)
            return false;
        return this.deepSearch(raiz, num);
    }
    
    public boolean isEmpty(){
        return this.raiz==null;
    }
    
    public void delete(char val) {
        this.raiz = deleteRec(this.raiz, val); // Actualiza la raíz por si se borra
    }

    private TreeNodeChar deleteRec(TreeNodeChar node, char val) {
        if (node == null) {
            return null; // No se encontró el valor
        }

        if (val < node.getValor()) {
            node.setIzq(deleteRec(node.getIzq(), val)); // Buscar en izquierda
        } 
        else if (val > node.getValor()) {
            node.setDer(deleteRec(node.getDer(), val)); // Buscar en derecha
        } 
        else { // Nodo encontrado
            // Caso 1: Nodo hoja o con un solo hijo
            if (node.getIzq() == null) {
                return node.getDer(); // Reemplazar por hijo derecho (o null)
            } 
            else if (node.getDer() == null) {
                return node.getIzq(); // Reemplazar por hijo izquierdo
            }
            // Caso 2: Nodo con dos hijos
            else {
                // Encontrar el mínimo del subárbol derecho (sucesor in-order)
                TreeNodeChar minNode = findMin(node.getDer());
                // Copiar el valor mínimo al nodo actual
                node.setValor(minNode.getValor());
                // Borrar el nodo mínimo del subárbol derecho
                node.setDer(deleteRec(node.getDer(), minNode.getValor()));
            }
        }
        return node;
    }

    private TreeNodeChar findMin(TreeNodeChar node) {
        while (node.getIzq() != null) {
            node = node.getIzq();
        }
        return node;
    }
    
    public int getHeight(){
        return this.getHeight(this.raiz);
    }
    
    private int getHeight(TreeNodeChar node){
        if(node==null)
            return 0;
        int alturaIzq = getHeight(node.getIzq());
        int alturaDer = getHeight(node.getDer());
        return Math.max(alturaIzq, alturaDer) + 1;
    }
    
    public void imprimirPreOrden(){
        this.imprimirPreOrden(this.raiz);
    }
    
    public void imprimirEnOrden(){
        this.imprimirEnOrden(raiz);
    }
    
    public void imprimirPosOrden(){
        this.imprimirPosOrden(raiz);
    }
    
    private void imprimirPreOrden(TreeNodeChar nodo)
    {
        if (nodo == null)
            return;
        System.out.print(nodo.getValor() + " ");
        imprimirPreOrden(nodo.getIzq());
        imprimirPreOrden(nodo.getDer());
    } 
    
    private void imprimirEnOrden(TreeNodeChar nodo)
    {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getIzq());
        System.out.print(nodo.getValor() + " ");
        imprimirEnOrden(nodo.getDer());
    }
    
    private void imprimirPosOrden(TreeNodeChar nodo)
    {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getIzq());
        imprimirEnOrden(nodo.getDer());
        System.out.print(nodo.getValor() + " ");
    } 
    
    public List getLongestBranch(){
        return getLongestBranch(raiz);
    }
    
    private List<Character> getLongestBranch(TreeNodeChar nodo) {
        if (nodo == null) {
            return new ArrayList<>(); 
        }
        List<Character> ramaIzq = getLongestBranch(nodo.getIzq());
        List<Character> ramaDer = getLongestBranch(nodo.getDer());

        List<Character> ramaLarga = (ramaDer.size() > ramaIzq.size()) ? ramaDer : ramaIzq;

        ramaLarga.add(0, nodo.getValor()); 
        return ramaLarga;
    }
    
    public List<Character> getListFrontera() {
        List<Character> hojas = new ArrayList<>();
        getListFrontera(raiz, hojas);
        return hojas;
    }

    private void getListFrontera(TreeNodeChar nodo, List<Character> hojas) {
        if (nodo == null) {
            return;
        }
        if (nodo.getIzq() == null && nodo.getDer() == null) {
            hojas.add(nodo.getValor()); // Es una hoja
        }
        getListFrontera(nodo.getIzq(), hojas); 
        getListFrontera(nodo.getDer(), hojas); 
    }
    
    public int getMaxElem(){
        if(raiz==null)
            return -1;
        return getMaxElem(raiz);
    }
    
    public List<Character> getElemAtLevel(int level){
        ArrayList<Character> result=new ArrayList();
        getElemAtLevel(raiz,level,result);
        return result;
    }
    
    private void getElemAtLevel(TreeNodeChar node,int lvl,ArrayList<Character>result){
        if(node==null)
            return;
        lvl--;
        if(lvl==0)
            result.add(node.getValor());
        
        getElemAtLevel(node.getIzq(),lvl,result);
        getElemAtLevel(node.getDer(),lvl,result);
    }
    
    private int getMaxElem(TreeNodeChar nodo){
        if(nodo.getDer()==null)
            return nodo.getValor();
        return getMaxElem(nodo.getDer());
    }
    
    private boolean deepSearch(TreeNodeChar node, int val){
        if (node == null)  
            return false;
        if (node.getValor() == val)  
            return true;
 
        if (val < node.getValor()) 
            return deepSearch(node.getIzq(), val);
        else 
            return deepSearch(node.getDer(), val);
    }
    
    public void add(char valor) {
        if (this.raiz == null)
            this.raiz = new TreeNodeChar(valor);
        else
            this.add(this.raiz,valor);
    }

    private void add(TreeNodeChar nodo, char valor) {
        if (nodo.getValor() > valor) {
            if (nodo.getIzq() == null) {
            TreeNodeChar temp = new TreeNodeChar(valor);
            nodo.setIzq(temp);
            } 
            else {
                add(nodo.getIzq(),valor);
            }
        } 
        else if (nodo.getValor() < valor) {
            if (nodo.getDer() == null) {
            TreeNodeChar temp = new TreeNodeChar(valor);
            nodo.setDer(temp);
            } else {
            add(nodo.getDer(),valor);
            }
        }
    }
    
    public int suma(){
        if(this.isEmpty())
            return -1;
        return suma(this.raiz);
    }
    
    private int suma(TreeNodeChar node){
        if(node==null)
            return 0;
        int suma=node.getValor();
        suma+=suma(node.getIzq());
        suma+=suma(node.getDer());
        return suma;
    }
    
    public ArrayList<ArrayList<Character>> buscaPalabras(int vocales) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        buscaPalabras(this.raiz, result, new ArrayList<>(), vocales);
        return result;
    }

    private void buscaPalabras(TreeNodeChar node, ArrayList<ArrayList<Character>> result, 
                             ArrayList<Character> actual, int vocalesRestantes) {
        if (node == null) {
            return;
        }
        actual.add(node.getValor());

        boolean esVocal = isVocal(node.getValor());
        if (esVocal) {
            vocalesRestantes--;
        }

        if (node.esHoja()) {
            if (vocalesRestantes == 0) {
                result.add(new ArrayList<>(actual));
            }
        } else {
            buscaPalabras(node.getIzq(), result, actual, vocalesRestantes);
            buscaPalabras(node.getDer(), result, actual, vocalesRestantes);
        }
        actual.remove(actual.size() - 1);
    }

// Método auxiliar para verificar vocales
    private boolean isVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
        

}

