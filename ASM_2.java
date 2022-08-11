/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ASM_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  //      InSanDuLieu();
        Scanner sc = new Scanner(System.in);
        int chon;
        MyList<Product> list = new MyList<>();
        MyStack<Product> stack = new MyStack<>();
        MyQueue<Product> queue = new MyQueue<>();
        OperationToProduct opp = new OperationToProduct();
        Product product = new Product();
        boolean fag = true;
        do {
            System.out.println();
            showMenu();
            System.out.println();
            System.out.print("Chon chuc nang : ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    System.out.println("Goodbye ! ");   
                    System.exit(0);
                    break;
                case 1:
                    list.clear();
                    opp.readFileList("data.txt", list);
                    System.out.println();
                    System.out.println("Doc thanh cong !\n");
                    break;
                case 2:
                    //them vao cuoi danh sach
                    opp.add_Product(list);
                    break;
                case 3:
                    //hien thi tung product
                    opp.hienthi3(list);
                    break;
                case 4:
                    //ghi thong tin product
                    opp.writeProduct("data.txt", list);
                    System.out.println("Ghi thanh cong");
                    break;
                case 5:  
                    //tim kiem
                    opp.sreachByID(list);
                    break;
                case 6:
                    //xoa 
                    opp.deleteteByID(list);
                    opp.hienthi(list);
                    break;
                case 7:   
                    //sap xep
                    opp.sortByID(list);                 
                    System.out.println();
                    System.out.println("danh sach sau sap xep");
                    opp.hienthi(list);
                    opp.writeFile("console_output.txt", list.toString());
                    break;
                case 8:
                    int so_luong = list.getDauNode().getData().getSo_luong();
                    String str = "Thap phan " + so_luong +" thanh nhi phan " ;
                   int[] arr = opp.convertToBinary(so_luong);
                   //do dua vao theo kieu queue. nen hien thi phai lay ra theo kieu queue
                    for (int i =arr.length -1; i >=0; i--) {
                        System.out.print( arr[i]);
                        str += arr[i];
                    }
                    System.out.println();
                    //ghi lai ket qua vao file
                    opp.writeFile("console_output.txt", str);
                    break;
                case 9:
                   stack.clear();
                    opp.readFileStack("data.txt", stack);
                    System.out.println(stack);
                    System.out.println("\n Ghi thanh cong");
                    
                    break;
                case 10:
                    queue.clear();
                    opp.readFileQueue("data.txt", queue);
                    System.out.println(queue);
                    System.out.println("\n Ghi thanh cong ");
                    break;
                default:
                    System.out.println("Chon sai chuc nang.\n Moi chon lai ");
                    break;
            }
        } while (true);

    }

    public static void showMenu() {
        System.out.println("<--------------------------------------->");
        System.out.println("  1. Doc file va luu vao danh sach, in ra man hinh ");
        System.out.println("  2. Nhap them san pham vao cuoi danh sach ");
        System.out.println("  3. Hien thi thong tin trong danh sach ");
        System.out.println("  4. Luu danh sach san pham vao file");
        System.out.println("  5. Tim kiem thong tin san phan theo ID ");
        System.out.println("  6. Xoa thong tin san pham theo ID ");
        System.out.println("  7. Sap xep san pham trong danh sach theo ID ");
        System.out.println("  8. Doi so luong san pham dang thap phan sang dang nhi phan ");
        System.out.println("  9. Doc du lieu tu file, luu vao stack va in ra man hinh ");
        System.out.println("  10.Doc du lieu tu file,luu vao queue va in ra man hinh");
        System.out.println("  0.Ket thuc chuong trinh");
    }

    public static void InSanDuLieu() {
        ArrayList<Product> list = new ArrayList<>();
        Product p1 = new Product("p04", "TV Sony", 10, 11.2);
        Product p2 = new Product("p02", "Tu Lanh Sam Sung", 9, 6.4);
        Product p3 = new Product("p01", "May loc nuoc", 15, 3.0);
        Product p4 = new Product("p07", "Dieu hoa Panasonic", 6, 10.3);
        Product p5 = new Product("p08", "Noi com dien", 78, 1.1);
        Product p6 = new Product("p04", "TV TCL 47", 8, 7.3);
        Product p7 = new Product("p14", "Quat dieu hoa", 11, 5.2);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);

        File file = new File("data.txt");
        try {
            FileWriter out = new FileWriter(file);
            BufferedWriter wr = new BufferedWriter(out);
            for (Product product : list) {
                wr.write(product.getID() + "\n");
                wr.write(product.getNameProduct() + "\n");
                wr.write(product.getSo_luong() + "\n");
                wr.write(product.getMony() + "\n");

            }
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
