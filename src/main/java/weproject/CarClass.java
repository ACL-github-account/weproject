/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weproject;

import java.util.Arrays;
import java.util.Scanner;
import static weproject.Main.cars;

/**
 *
 * @author aron
 */
public class CarClass {
    
    //declare attributes
    public String brand, enginesize, model, colour;
    public int year, carID;
    public double price;
    //static int carIDnum = 0; 
    
    //to be used by other classes for listing CarClass attributes.
    public static enum attributelist{
        brand, enginesize, model, colour, year, carID, price;
    }
    
    //assignID on creation
    public CarClass(){
        this.carID = Main.cars.size();
    }
    //initialise attributes from user input
    public void brandinit(){
        System.out.println("input brand");
        Scanner carspecuserinput = new Scanner(System.in);
        this.brand = carspecuserinput.nextLine();
    }
    public void enginesizeinit(){
        System.out.println("input enginesize");
        Scanner carspecuserinput = new Scanner(System.in);
        this.enginesize = carspecuserinput.nextLine();
    }    
    public void yearinit(){
        System.out.println("input year");
        Scanner carspecuserinput = new Scanner(System.in);
        this.year = Integer.parseInt(carspecuserinput.nextLine());        
    }    
    public void priceinit(){
        System.out.println("input price");
        Scanner carspecuserinput = new Scanner(System.in);
        this.price = Double.parseDouble(carspecuserinput.nextLine());
    }    
    public void colourinit(){
        System.out.println("input colour");
        Scanner carspecuserinput = new Scanner(System.in);
        this.colour = carspecuserinput.nextLine();
    }    
    public void modelinit(){
        System.out.println("input model");
        Scanner carspecuserinput = new Scanner(System.in);
        this.model = carspecuserinput.nextLine();
    }
    
    //--------------------------------------------
    
    
    //initialise variables, calls methods initialising each variable from
    //input, they are seperate so they may be called individiauly to edit
    //existing objects
    public void inputinit(){    
        brandinit();
        enginesizeinit();
        modelinit();
        colourinit();
        yearinit();
        priceinit();
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
    /*public static CarClass[] appendCarArray(CarClass[] arr, CarClass apobj){
        CarClass[] rarr = Arrays.copyOf(arr, arr.length + 1);
        rarr[rarr.length - 1] = apobj;
        //System.out.println(String.valueOf(rarr.length));
        return rarr;
    } */ 
    /*public static CarClass[] removeCarObject(CarClass[] arr, int arrIndex){
        CarClass[] rarr = new CarClass[arr.length - 1];
        System.out.println(rarr.length);
        int i = 0, ii = 0;
        for(CarClass x : arr){
            if(i != arrIndex){
               rarr[ii] = x;
               ii = (ii != i) ? ii++ : i;
            }
            i++;
        }
        for (CarClass x : rarr){
            System.out.println(x.carID);
        }
        return rarr;
    }*/
    
    //printsID's and more human readable attributes on one line.
    public void printID(){
        System.out.print(this.carID + " ");
        System.out.print(this.brand + " ");
        System.out.println(this.model);
    }
    
    //prints attributes of a car
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
    
    /*function for updateing IDs to remove the numerical gaps between objects*/
    /*public static void removeIDgaps(){
        int i = 0;
        for(CarClass x : cars){
            x.carID = i;
            i++;
        }
    }*/
}
