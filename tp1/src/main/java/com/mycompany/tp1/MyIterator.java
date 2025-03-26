/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ilari
 */
public class MyIterator<T> implements Iterator<T> {
        private Node<T> current;
        
        public MyIterator(Node<T> act){
            current=act;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            T info = current.getInfo();
            current = current.getNext();
            return info;
        }
  }

