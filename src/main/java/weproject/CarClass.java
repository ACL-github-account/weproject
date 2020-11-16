/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aron
 */
public class CarClass {
    public String brand, enginesize, model, colour;
    public int year, carID;
    public double price;
    static int carIDnum = 0; 
    
    public CarClass(){
        this.carID = carIDnum;
        carIDnum++;
    }
    
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
    
    //initialise variables as null, used for fast creation of an object for debug
    public void nullInit(){
        this.brand = null;
        this.enginesize = null;
        this.model = null;
        this.colour = null;
        this.year = 0;
        this.price = 0.00;
    }
    /*was in a uniuque utility funtion class, however it was moved due to its inability
    to process other object and variable types, this allows it to be kept with more closer related code*/
    public static CarClass[] appendCarArray(CarClass[] arr, CarClass apobj){
        CarClass[] rarr = Arrays.copyOf(arr, arr.length + 1);
        rarr[rarr.length - 1] = apobj;
        return rarr;
    }  
    
    public void printID(){
        System.out.print(this.carID + " ");
        System.out.print(this.brand + " ");
        System.out.println(this.model);
    }
    
    public void printcontents(){
        System.out.println("ID:" + this.carID);
        System.out.println("brand: " + this.brand);
        System.out.println("enginesize: " + this.enginesize);
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("price: " + this.price);
        System.out.println("colour: " + this.colour);
        System.out.println();
    }
}
