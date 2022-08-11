/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm_2;

/**
 *
 * @author ADMIN
 */
public class MyQueue<T> {
    private Node<T> dauNode;
    private Node<T> cuoiNode;
    
   //khoi tao
    public MyQueue(){}
    
    public MyQueue(Node<T> dauNode, Node<T> cuoiNode){
        this.dauNode = dauNode;
        this.cuoiNode = cuoiNode;
    }
    
    public boolean IsEmpty(){
        
        return this.dauNode == null;
    }
    //tham them vao cuoi Node
    public void push(Node<T> newNode){
        if (IsEmpty()) {
            this.dauNode= this.cuoiNode = newNode;
        }else{
            this.cuoiNode.setNexNode(newNode);
            this.cuoiNode = newNode;
        }
    }
    //doc du lieu queue
    public Node<T> Dos_Queue(){
        
        if (IsEmpty()) {
            return null;
        }else{
            Node<T> newNode =this.dauNode;
            this.dauNode=this.dauNode.getNexNode();
            this.cuoiNode = null;
            return newNode;
        }
     
    }
    public void clear(){
    this.dauNode = this.cuoiNode =null;
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
