package asm_2;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Product {

    private String ID;
    private String nameProduct;
    private int so_luong;
    private double mony;

    public Product() {
    }

    public Product(String ID, String nameProduct, int so_luong, double mony) {
        this.ID = ID;
        this.nameProduct = nameProduct;
        this.so_luong = so_luong;
        this.mony = mony;
    }

    public double getMony() {
        return mony;
    }

    public void setMony(double mony) {
        this.mony = mony;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

   

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao Id : ");
        ID = sc.nextLine();
        System.out.print("Nhap vao ten san pham: ");
        nameProduct = sc.nextLine();
        System.out.print("Nhap vao so luong san pham: ");
        so_luong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap vao gia san pham: ");
        mony = Double.parseDouble(sc.nextLine());
    }

    @Override
    public String toString() {
        return String.format("|%5s |%20s |%20s |%20s ",ID, nameProduct, so_luong, mony);
    }

}
