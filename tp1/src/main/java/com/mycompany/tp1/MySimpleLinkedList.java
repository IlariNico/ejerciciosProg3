/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1;

import java.util.Iterator;

/**
 *
 * @author ilari
 */
public class MySimpleLinkedList<T> implements Iterable<T>{
	
        private int cant;
	private Node<T> first;
	
	public MySimpleLinkedList() {
                cant=0;
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
                cant ++;
	}
	
	public T extractFront() {		
		Node<T> temp=this.first.getNext();
                this.first.setNext(null);
                this.first=temp;
                cant --;
		return null;
	}

        public Node<T> getFront() {		
		return this.first;
	}
        
        public void insertBetween(Node<T> node, Node<T> elem){
            Node<T> tmp;
            tmp=node.getNext();
            node.setNext(elem);
            elem.setNext(tmp);
            cant++;
        }
        
	public boolean isEmpty() {
		return first==null;
	}
	
	public T get(int index) {
		if(index<0 || this.first==null)
                    return null;
                Node nodo=this.first;
                T info=null;
                while(index>=0 && nodo!=null && info==null){
                    if(index==0)
                        info=(T)nodo.getInfo();
                    nodo=nodo.getNext();
                    index--;
                }
                return info;
	}
	
	public int size() {
		
		return cant;
	}
	
        public int indexOf(T obj){
            if(this.first==null)
                return -1;
            int index=0;
            Node nodo=this.first;
            int pos=-1;
            while(nodo!=null && pos==-1){
                
                if(nodo.getInfo().equals(obj))
                    pos=index;
                
                nodo=nodo.getNext();
                index++;
            }
            return pos;
        }
        
	@Override
	public String toString() {
            String salida="";
            salida+="< ";
            if(this.first!=null)
                salida+=this.first.toString();
            salida+=" >";
            return salida;
	}
        
        @Override
        public Iterator<T> iterator(){
            return new MyIterator<>(this.first);
        }
	
        
}