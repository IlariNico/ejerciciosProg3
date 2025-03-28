/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2;

/**
 *
 * @author ilari
 */
public class TreeNodeChar {
    private char valor;
    private TreeNodeChar izquierda;
    private TreeNodeChar derecha;
    
    public TreeNodeChar(char value){
        this.valor=value;
        this.izquierda=null;
        this.derecha=null;
    }
    
    public void setIzq(TreeNodeChar node){
        this.izquierda=node;
    }
    
    public void setDer(TreeNodeChar node){
        this.derecha=node;
    }
    
    public TreeNodeChar getDer(){
        return this.derecha;
    }
    
    public TreeNodeChar getIzq(){
        return this.izquierda;
    }
    
    public char getValor(){
        return this.valor;
    }
    
    public void setValor(char valor){
        this.valor=valor;
    }
    
    public boolean esHoja(){
        return this.getDer()==null&&this.getIzq()==null;
    }
}
