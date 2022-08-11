/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm_2;

/**
 *
 * @author ADMIN
 */
public class MyList<T> {
    private T data;
    private Node<Product> dauNode;
    private Node<Product> cuoiNode;

    public MyList() {
    }

    public MyList(Node<Product> dauNode, Node<Product> cuoiNode) {
        this.dauNode = dauNode;
        this.cuoiNode = null;
    }

    public Node<Product> getDauNode() {
        return dauNode;
    }

    public void setDauNode(Node<Product> dauNode) {
        this.dauNode = dauNode;
    }

    public Node<Product> getCuoiNode() {
        return cuoiNode;
    }

    public void setCuoiNode(Node<Product> cuoiNode) {
        this.cuoiNode = cuoiNode;
    }

    public boolean IsEmpty() {
        return this.dauNode == null;
    }

    //xoa toan bo danh sach
    public void clear() {
        dauNode = cuoiNode = null;
    }

    public int length() {
        int length = 0;
        Node newNode = this.dauNode;
        while (newNode != null) {
            length++;
            newNode = newNode.getNexNode();
        }
        return length;
    }

    //them vao dau node
    public void add_Dau(T data) {
        Node<Product> newNode = new Node(data,this.dauNode);
        newNode.setNexNode(this.dauNode);
        this.dauNode = newNode;

    }

    //them vao cuoi
    public void add_Cuoi(T data) {
        Node<Product> newNode = new Node(data,this.dauNode);
        if (IsEmpty()) {
            newNode.setNexNode(this.dauNode);
            this.dauNode=this.cuoiNode=newNode;
            
        } else {
            this.cuoiNode.setNexNode(newNode);
            this.cuoiNode = newNode;
        }
    }
    //xoa node dau
    public void deleteNode(T data){
        Node<Product> newNode = new Node(data,this.dauNode);
        if (this.cuoiNode == null) {
            this.dauNode = this.cuoiNode = null;
        }else{
            this.dauNode = this.dauNode.getNexNode();
        }
    }
   public Node sort(Node<Product> node){
       if (node == null) {
           return null;
       }
       node = node.selectDequy(node);
       return node;
   }
   
    @Override
    public String toString() {
        Node<Product> newNode = this.dauNode;
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
