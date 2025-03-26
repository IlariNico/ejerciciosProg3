/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp1;

/**
 *
 * @author ilari
 */
public class Tp1 {

    public static void main(String[] args) {
        /*MySimpleLinkedList<String> lista=new MySimpleLinkedList();
        System.out.println(lista);
        //System.out.println(lista.size());
        lista.insertFront("milangas");
        lista.insertFront("pedro");
        System.out.println(lista);
        //String pedro=(String)lista.get(0);
        //String milangas=(String)lista.get(1);
        //lista.extractFront();
        System.out.println(lista);
        for(String elem:lista){
            System.out.println(elem);
        }
        //System.out.println(lista.size());*/
        ListUtils utils=new ListUtils();
        MySimpleLinkedList<Integer> list1=new MySimpleLinkedList();
        list1.insertFront(3);
        list1.insertFront(2);
        list1.insertFront(1);
        MySimpleLinkedList<Integer> list2=new MySimpleLinkedList();
        list2.insertFront(80);
        list2.insertFront(3);
        list2.insertFront(2);
        list2.insertFront(1);
        System.out.println(list1);
        System.out.println(list2);
        MySimpleLinkedList<Integer> result=utils.commonElements(list1, list2, true);
        System.out.println(result);
    }
    
    
}
