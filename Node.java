/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm_2;

/**
 *
 * @author ADMIN
 */
public class Node<T> {
  private T data;
  private Node nexNode;

    public Node() {
    }
    
    public Node(T data,Node nexNode) {
        this.data = data;
        this.nexNode = null;
    }
  
  public Node(Node<T> nextNode){
      this.nexNode = nextNode;
  }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNexNode() {
        return nexNode;
    }

    public void setNexNode(Node<T> nexNode) {
        this.nexNode = nexNode;
    }
    //ham hoan vi node
    //sap xep chon tai https://www.geeksforgeeks.org/recursive-selection-sort-singly-linked-list-swapping-node-links/
    public Node swapNode(Node head, Node nodeX, Node nodeY, Node prevY){
        head = nodeY;
        prevY.nexNode = nodeX;
        
        Node tmp = nodeY.nexNode;
        nodeY.nexNode = nodeX.nexNode;
        nodeX = tmp;
        return head;
    }
    //ham sap xep chon
    public Node<Product> selectDequy(Node<Product> head){
        //neu chi co 1 node
        if (head.nexNode ==null) {
            return head;
        }
        //bien chon
        Node<Product> min = head;
        //node truoc
        Node<Product> beforeMin = null;
        //bien tam
        Node<Product> tmp;
        for(tmp = head; tmp.nexNode != null;tmp = tmp.nexNode){
            if (min.data.getID().compareTo(tmp.data.getID()) >=0) {
                min = tmp.nexNode;
                beforeMin = tmp;
            }
        }
        //hoan vi node dau va node min
        if (min !=head) {
            head = swapNode(head, head, min, beforeMin);
        }
        //sap xep chon de quy
        head.nexNode = selectDequy(head.nexNode);
    return  head;
    }
    //ham de quy
    public Node<Product> sort(Node<Product> head){
        if (head == null) {
            return  null;
        }
        head = selectDequy(head);
        return head;  
   }
    @Override
    public String toString() {
        return getData().toString();
    }
  
}
