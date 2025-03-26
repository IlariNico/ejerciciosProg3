/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author ilari
 */
public class ListUtils<T extends Comparable<T>>{

    
    public  MySimpleLinkedList<T> commonElements(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2, boolean areListsSorted) {
    if (areListsSorted) {
        return commonElementsSorted(list1, list2);
    } 
    else {
        return commonElementsUnsorted(list1, list2);
        }
    }
    
    private MySimpleLinkedList<T> commonElementsSorted(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Iterator<T> it1 = list1.iterator();
        Iterator<T> it2 = list2.iterator();

        if (!it1.hasNext() || !it2.hasNext()) {
            return result; // Si alguna lista está vacía
        }

        T elem1 = it1.next();
        T elem2 = it2.next();

        while (elem1 != null && elem2 != null) {
            int cmp = elem1.compareTo(elem2);
            if (cmp == 0) {
                insertOrder(result, elem1); // Elemento común
                elem1 = it1.hasNext() ? it1.next() : null;
                elem2 = it2.hasNext() ? it2.next() : null;
            } else if (cmp < 0) {
                elem1 = it1.hasNext() ? it1.next() : null;
            } else {
                elem2 = it2.hasNext() ? it2.next() : null;
            }
        }
        return result;
    }
    
    private MySimpleLinkedList<T> commonElementsUnsorted(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Boolean found;
        for(T elem:list1){
            Iterator it=list2.iterator();
            found=false;
            while(it.hasNext() && !found){
                T elem2=(T)it.next();
                if(elem.equals(elem2)){
                    insertOrder(result,elem);
                    found=true;
                }
            }
        }
        return result;
    }
    
    public void insertOrder(MySimpleLinkedList<T> lista, T elemento) {

        
        //Si la lista no esta vacia, verificamos si el primer nodo de la lista tiene un valor mayor que el elemento que estamos insertando.
        if (lista.isEmpty() || lista.iterator().next().compareTo(elemento) > 0) {
            lista.insertFront(elemento);
            return;
        }

        /*
        * Si no entramos en el if anterior, significa que el nuevo nodo debe insertarse en algun lugar despues del primer nodo.

        * El while  asegura que el valor en el siguiente nodo de actual es menor que el valor de elemento.
        * Si es asi, seguimos avanzando a través de la lista con actual = actual.getNext(), para encontrar la posicion correcta para elemento.

        * */
        Node<T> actual = lista.getFront();
        while (actual.getNext() != null && actual.getNext().getInfo().compareTo(elemento) < 0) {
            actual = actual.getNext();
        }
        //Cuando el ciclo termina, significa que hemos encontrado la posición correcta para insertar el nuevo nodo.
        Node<T> newNode=new Node(elemento,null);
        lista.insertBetween(actual, newNode);
        
    }
}
