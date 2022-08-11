/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm_2;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class OperationToProduct {

    Scanner sc = new Scanner(System.in);
    private int index;

    //ham ghi vao file txt
    public void writeFile(String fileName, String str) {
        File file = new File(fileName);

        try {
            FileWriter output = new FileWriter(file, true);
            output.write(str);
            output.write("\n");
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ham cap nhat danh sach vao trong file
    public void writeProduct(String fileName, MyList<Product> list) {
        File file = new File(fileName);
        Node<Product> newNode = list.getDauNode();
        try {
            FileWriter output = new FileWriter(file);

            while (newNode != null) {
                output.write(newNode.getData().getID() + "\n");
                output.write(newNode.getData().getNameProduct() + "\n");
                output.write(newNode.getData().getSo_luong() + "\n");
                output.write(newNode.getData().getMony() + "\n");
                newNode = newNode.getNexNode();
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ham hien thi list 
    public void hienthi(MyList<Product> list) {
        System.out.println(list.toString());
        writeFile("console_ouput.txt", list.toString());
    }

    //ham hien thi phan tu trong list
    public void hienthi3(MyList<Product> list) {
        //hien thi
        if (list.IsEmpty()) {
            System.out.println("Danh sach rong");
        }
        Node newNode = list.getDauNode();
        while (newNode != null) {
            System.out.println(newNode.getData().toString());
            newNode = newNode.getNexNode();
        }

    }

    //ham doc file
    public void readFileList(String fileName, MyList<Product> list) {
        File file = new File(fileName);
        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            String str;
            Product product = new Product();
            int count = 0;
            while ((str = reader.readLine()) != null) {
                count++;
                //luu thuoc tinh cua doi tuong thanh tung dong
                switch (count) {

                    case 1:
                        product.setID(str);
                        break;
                    case 2:
                        product.setNameProduct(str);
                        break;
                    case 3:
                        product.setSo_luong(Integer.parseInt(str));
                        break;
                    case 4:
                        product.setMony(Double.parseDouble(str));
                        break;
                }
                if (count == 4) {
                    list.add_Cuoi(product); // them node vao cuoi sanh sach
                    product = new Product();
                    count = 0;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hienthi(list);
        //writeFile(fileName, fileName);
    }

    //tim kiem vi tri cua san pham trong danh sach
    public int timkiem_Index(MyList<Product> list) {
        String tim_kiem = sc.next();
        int count = 0;
        Node<Product> vi_tri = list.getDauNode();
        while (vi_tri != null) {
            count++;
            if (vi_tri.getData().getID().equals(tim_kiem)) {
                //tim thay vi tri cua san pham
                return count;
            }
            // neu ko tim thay thi so sanh vi tri tiep theo
            vi_tri = vi_tri.getNexNode();
        }
        return -1;
    }

    //nhap san pham moi
    public Product NhapProduct() {
        Product product = new Product();
        product.Nhap();
        return product;
    }

    //them san pham moi vao cuoi sanh sach
    public void add_Product(MyList<Product> list) {
        Product product = NhapProduct();
        list.add_Cuoi(product);
        //writeProduct("data.txt", list);
        //thuc hien thao tac o chuc nang thu 4
    }

    //tim kiem bang ID
    public void sreachByID(MyList<Product> list) {
        System.out.println("Nhap ID tim kiem: ");
        index = timkiem_Index(list);
        if (list.IsEmpty()) {
            System.out.println("Danh sach rong khong the tim kiem.");
            return;
        }
        Node<Product> vi_tri = list.getDauNode(); //khai bao vi tri dau tien
        String str = "";
        int count = 0;
        if (index > 0) {
            while (vi_tri != null) {
                count++;
                //hien thi node tim kiem
                if (count == index) {
                    System.out.print(vi_tri.getData());
                    str = vi_tri.getData().toString();
                }
                vi_tri = vi_tri.getNexNode();
            }
        } else {
            System.out.print(index);
            str += index;
        }
        writeFile("console_output.txt", str);
    }

    //xoa node bang ID
    public void deleteteByID(MyList<Product> list) {

        System.out.println("Nhap ID can xoa: ");
        index = timkiem_Index(list);
        Node<Product> vi_tri = list.getDauNode(); //node hien tai
        Node<Product> tiep_theo = null; // node tiep theo
        //neu vi tri can tim la node dau tien
        if (vi_tri != null && index == 1) {
            list.setDauNode(vi_tri.getNexNode()); // set lai vi tri dau tien
            vi_tri = null;                        //xoa node dau tien
            return;
        }
        int count = 0;
        while (count <= index && index > 1) {
            count++;
            if (count == index) {
                tiep_theo.setNexNode(vi_tri.getNexNode());// xoa node tim thay
            } else {
                tiep_theo = vi_tri;                //xoa node bang cach bo qua node hien tai.chuyen tiep theo len thanh node hien tai
            }
            vi_tri = vi_tri.getNexNode();           //chua tim thay thi dich chuyen den node tiep theo
        }
        writeFile("console_output.txt", list.toString());
    }

    public void sortByID(MyList<Product> list) {
        Node<Product> newNode = list.getDauNode();
        Product tmp;
        while (newNode.getNexNode() != null) {
            //dieu kien de quy
            if (newNode.getData().getID().compareTo(newNode.getNexNode().getData().getID()) > 0) {
                //tien hanh hoan vi
                tmp = newNode.getData();
                newNode.setData(newNode.getNexNode().getData());
                newNode.getNexNode().setData(tmp);

                sortByID(list);//su dung ham de quy
            }
            newNode = newNode.getNexNode();
        }

    }
    //ham chuyen doi sang nhi phan
    private int length = 0;         //chieu dai cua mang
    private int[] arr = new int[10];//mang luu tra ve phan du
    private int[] array;            //mang luu gia tri tra ve

    public int[] convertToBinary(int value) {
        length++;
        //dk ket thuc de quy   
        if (value % 2 == 0) {
            arr[length - 1] = value % 2;          //luu phan du vao mang tam arr
            array = new int[length];            //khoi tao mang luu gia tri tra ve
            for (int i = 0; i < length; i++) {
                array[i] = arr[i];            //luu gia tri cua mang tam arr vao mang array
            }
        } else {
            arr[length - 1] = value % 2;
            convertToBinary(value / 2);         //goi de quy.gia tri qe quy tiep theo la nua~ so con lai
        }

        return array;
    }

    //doc gia tri tu Stack
    public void readFileStack(String fileName, MyStack<Product> stack) {
        File file = new File(fileName);
        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            String str;
            Product product = new Product(); // doi tuong luu thong tin doc
            int count = 0; //lap doc lai file
            while ((str = reader.readLine()) != null) {
                count++;
                // moi lan ket thuc 1 dong xuong dong tiep theo thi co ca thuoc tinh khac nhau
                switch (count) {
                    case 1:
                        product.setID(str);
                        break;
                    case 2:
                        product.setNameProduct(str);
                        break;
                    case 3:
                        product.setSo_luong(Integer.parseInt(str));
                        break;
                    case 4:
                        product.setMony(Double.parseDouble(str));
                        break;
                }
                if (count == 4) {
                    Node<Product> newNode = new Node<>();
                    newNode.setData(product);   // gan doi tuong vao node
                    stack.push(newNode);      // them node moi
                    product = new Product(); // tao lai doi tuong de luu thong tin o vong lap moi
                    count = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ghi ket qua vao file
        // stack.peek();
        writeFile("console_output.txt", stack.toString());
    }

    //ham doc du lieu tu queue
    public void readFileQueue(String fileName, MyQueue<Product> queue) {
        File file = new File(fileName);
        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            String str;
            Product product = new Product();
            int count = 0;
            while ((str = reader.readLine()) != null) {
                count++;
                switch (count) {
                    case 1:
                        product.setID(str);
                        break;
                    case 2:
                        product.setNameProduct(str);
                        break;
                    case 3:
                        product.setSo_luong(Integer.parseInt(str));
                        break;
                    case 4:
                        product.setMony(Double.parseDouble(str));
                        break;
                }
                if (count == 4) {
                    Node<Product> newNode = new Node();
                    newNode.setData(product);        //them doi tuong vao node
                    queue.push(newNode);            //them 1 node moi
                    product = new Product();        //tao lai doi tuong
                    count = 0;                      //tra ve 0 de vong lap while lap lai
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //queue.Dos_Queue();
        writeFile("console_output.txt", queue.toString());
    }
}
