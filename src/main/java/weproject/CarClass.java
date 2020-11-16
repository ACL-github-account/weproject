/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;

import java.util.Scanner;

/**
 *
 * @author aron
 */
public class CarClass {
    public String brand;
    public String enginesize;
    public String model;
    public int year;
    public double price;
    public String colour;
    
    public void inputinit(){
        System.out.println("input brand");
        Scanner carspecuserinput = new Scanner(System.in);
        this.brand = carspecuserinput.nextLine();

        System.out.println("input enginesize");
        carspecuserinput = new Scanner(System.in);
        this.enginesize = carspecuserinput.nextLine();

        System.out.println("input model");
        carspecuserinput = new Scanner(System.in);
        this.model = carspecuserinput.nextLine();

        System.out.println("input year");
        carspecuserinput = new Scanner(System.in);
        this.year = Integer.parseInt(carspecuserinput.nextLine());

        System.out.println("input price");
        carspecuserinput = new Scanner(System.in);
        this.price = Double.parseDouble(carspecuserinput.nextLine());

        System.out.println("input colour");
        carspecuserinput = new Scanner(System.in);
        this.colour = carspecuserinput.nextLine();
    }
    public void printcontents(){
        System.out.println("brand: " + this.brand);
        System.out.println("enginesize: " + this.enginesize);
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("price: " + this.price);
        System.out.println("colour: " + this.colour);
        System.out.println();
    }
}
