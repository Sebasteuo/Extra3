/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ListaEnlazadaSimple {
    private NodoLista head;
    private int size;
    
    /**
     * Constructor
     * SimpleLinkedList
     */
    public ListaEnlazadaSimple(){
        this.head = null;
        this.size = 0;
    }

    public NodoLista getFlag(){
        return this.head;
    }

    public int getSize(){
        return this.size;
    }
    
    public int getData(int pos){
        NodoLista current = head;
        int count = 1;
        while(count <= this.size){
            if(count == pos){
                return current.getData();
            }
            current = current.getNext();
            count++;
        }
        return 0;
    }
    
    public void insertEnd(int data){
        NodoLista nuevoNodo = new NodoLista(data, null);
        if(head == null){
            head = nuevoNodo;
        }
        else{
            NodoLista current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(nuevoNodo);
        }
        size++;
        nuevoNodo.setPos(size);
    }
    
    public void printList(){
        NodoLista current = head;
        System.out.print("[");
        while(current.getNext() != null){
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.print(current.getData() + "]\n");
    }
}
