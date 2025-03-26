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
public class Tree {
    private TreeNode raiz;
    
    public Tree(){
        this.raiz=null;
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
    
    public void delete(int val) {
        this.raiz = deleteRec(this.raiz, val); // Actualiza la raíz por si se borra
    }

    private TreeNode deleteRec(TreeNode node, int val) {
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
                TreeNode minNode = findMin(node.getDer());
                // Copiar el valor mínimo al nodo actual
                node.setValor(minNode.getValor());
                // Borrar el nodo mínimo del subárbol derecho
                node.setDer(deleteRec(node.getDer(), minNode.getValor()));
            }
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getIzq() != null) {
            node = node.getIzq();
        }
        return node;
    }
    
    public int getHeight(){
        return this.getHeight(this.raiz);
    }
    
    private int getHeight(TreeNode node){
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
    
    private void imprimirPreOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        System.out.print(nodo.getValor() + " ");
        imprimirPreOrden(nodo.getIzq());
        imprimirPreOrden(nodo.getDer());
    } 
    
    private void imprimirEnOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getIzq());
        System.out.print(nodo.getValor() + " ");
        imprimirEnOrden(nodo.getDer());
    }
    
    private void imprimirPosOrden(TreeNode nodo)
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
    
    private List<Integer> getLongestBranch(TreeNode nodo) {
        if (nodo == null) {
            return new ArrayList<>(); 
        }
        List<Integer> ramaIzq = getLongestBranch(nodo.getIzq());
        List<Integer> ramaDer = getLongestBranch(nodo.getDer());

        List<Integer> ramaLarga = (ramaDer.size() > ramaIzq.size()) ? ramaDer : ramaIzq;

        ramaLarga.add(0, nodo.getValor()); 
        return ramaLarga;
    }
    
    public List<Integer> getListFrontera() {
        List<Integer> hojas = new ArrayList<>();
        getListFrontera(raiz, hojas);
        return hojas;
    }

    private void getListFrontera(TreeNode nodo, List<Integer> hojas) {
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
    
    public List<Integer> getElemAtLevel(int level){
        ArrayList<Integer> result=new ArrayList();
        getElemAtLevel(raiz,level,result);
        return result;
    }
    
    private void getElemAtLevel(TreeNode node,int lvl,ArrayList<Integer>result){
        if(node==null)
            return;
        lvl--;
        if(lvl==0)
            result.add(node.getValor());
        
        getElemAtLevel(node.getIzq(),lvl,result);
        getElemAtLevel(node.getDer(),lvl,result);
    }
    
    private int getMaxElem(TreeNode nodo){
        if(nodo.getDer()==null)
            return nodo.getValor();
        return getMaxElem(nodo.getDer());
    }
    
    private boolean deepSearch(TreeNode node, int val){
        if (node == null)  
            return false;
        if (node.getValor() == val)  
            return true;
 
        if (val < node.getValor()) 
            return deepSearch(node.getIzq(), val);
        else 
            return deepSearch(node.getDer(), val);
    }
    
    public void add(int valor) {
        if (this.raiz == null)
            this.raiz = new TreeNode(valor);
        else
            this.add(this.raiz,valor);
    }

    private void add(TreeNode nodo, int valor) {
        if (nodo.getValor() > valor) {
            if (nodo.getIzq() == null) {
            TreeNode temp = new TreeNode(valor);
            nodo.setIzq(temp);
            } 
            else {
                add(nodo.getIzq(),valor);
            }
        } 
        else if (nodo.getValor() < valor) {
            if (nodo.getDer() == null) {
            TreeNode temp = new TreeNode(valor);
            nodo.setDer(temp);
            } else {
            add(nodo.getDer(),valor);
            }
        }
    }
}

