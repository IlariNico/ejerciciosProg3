/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2;

/**
 *
 * @author ilari
 */
public class TreeNode {
    private int valor;
    private TreeNode izquierda;
    private TreeNode derecha;
    
    public TreeNode(int value){
        this.valor=value;
        this.izquierda=null;
        this.derecha=null;
    }
    
    public void setIzq(TreeNode node){
        this.izquierda=node;
    }
    
    public void setDer(TreeNode node){
        this.derecha=node;
    }
    
    public TreeNode getDer(){
        return this.derecha;
    }
    
    public TreeNode getIzq(){
        return this.izquierda;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public void setValor(int valor){
        this.valor=valor;
    }
}
