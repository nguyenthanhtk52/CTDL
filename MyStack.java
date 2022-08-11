/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm_2;

/**
 *
 * @author ADMIN
 */
public class MyStack<T> {

    private Node<T> dauNode;
    // khoi tao

    public Node<T> getDauNode() {
        return dauNode;
    }

    public void setDauNode(Node<T> dauNode) {
        this.dauNode = dauNode;
    }
    
    public MyStack() {
        this.dauNode = null;
    }

    //kiem tra stack rong
    public boolean IsEmpty() {
        return this.dauNode == null;
    }
    //them phan tu
    public void push(Node<T> newNode) {  
        newNode.setNexNode(this.dauNode);
        this.dauNode = newNode;
    }
    //Lay phan tu ra khoi Stack
    public void pop() {
        if (IsEmpty()) {
            System.out.print("Danh sach rong");
        }else{
        Node newNode = this.dauNode;
        this.dauNode = dauNode.getNexNode();
        }
    }
    //xoa stack
    public void clear(){
    this.dauNode = null;
    }
    //doc stack
    public Node<T> peek(){
        if (IsEmpty()) {
            return null;
        }else{
           return this.dauNode;
        }
    }
    
    @Override
    public String toString() {
        Node<T>  newNode= this.dauNode;
        String result = String.format("%5s %18s %22s %22s", " ID", " Ten San Pham ", " So Luong", " Gia");
        result += "\n+-------------------------------------------------------------------------------+";
        while (newNode != null) {
            result += "\n" + newNode.getData();
            newNode = newNode.getNexNode();
        }
        result += "\n+-------------------------------------------------------------------------------+";
        return result;
    }
}
