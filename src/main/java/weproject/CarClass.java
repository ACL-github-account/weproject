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
    public String brand, model, colour;
    public int year, carID, enginesize;
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
    
    //------------------------------------------------
    //   INPUT CONVERSION AND VALIDATION FUNCTIONS
    //-------------------------------------------------
    public static int inputInt(String inputFieldName){
        //IF INPUT THROWS NOT EXCEPTION THIS BECOMES TRUE TO BREAK LOOP
        boolean validinput = false;
        //RETURN VALUE
        int returnVal = -1;
        
        
        Scanner carspecuserinput;
        do {
            System.out.print(inputFieldName);
            carspecuserinput = new Scanner(System.in);
            try{
                returnVal = Integer.parseInt(carspecuserinput.nextLine()); 
                validinput = true;
            } catch(NumberFormatException e) {
                System.out.println("Not an integer, please try again.");
            }
        } while(validinput == false);
        return returnVal;
    }
    public static double inputDouble(String inputFieldName){
        //IF INPUT THROWS NOT EXCEPTION THIS BECOMES TRUE TO BREAK LOOP
        boolean validinput = false;
        //RETURN VALUE
        double returnVal = -1;
        
        
        Scanner carspecuserinput;
        do {
            System.out.print(inputFieldName);
            carspecuserinput = new Scanner(System.in);
            try{
                returnVal = Double.parseDouble(carspecuserinput.nextLine()); 
                validinput = true;
            } catch(NumberFormatException e) {
                System.out.println("Not an integer, please try again.");
            }
        } while(validinput == false);
        return returnVal;
    }
    
    
    //------------------------------------------------
    //------------------------------------------------
    
    //------------------------------------------------
    //          INITIALIZATION METHODS
    //-------------------------------------------------
    //initialise attributes from user input
    public void brandinit(){
        System.out.println("input brand");
        Scanner carspecuserinput = new Scanner(System.in);
        System.out.print("brand: ");
        this.brand = carspecuserinput.nextLine();
    }
    public void enginesizeinit(){
        System.out.println("input enginesize");
        this.enginesize = inputInt("size: ");
    }    
    public void yearinit(){
        System.out.println("input year");
        this.year = inputInt("year: ");     
    }    
    public void priceinit(){
        System.out.println("input price");
        this.price = inputDouble("price: ");
    }    
    public void colourinit(){
        System.out.println("input colour");
        System.out.print("colour:");
        Scanner carspecuserinput = new Scanner(System.in);
        this.colour = carspecuserinput.nextLine();
    }    
    public void modelinit(){
        System.out.println("input model");
        System.out.print("model: ");
        Scanner carspecuserinput = new Scanner(System.in);
        this.model = carspecuserinput.nextLine();
    }
    
    //-------------------------------------------------
    //-------------------------------------------------
    
    
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
        this.enginesize = 0;
        this.model = null;
        this.colour = null;
        this.year = 0;
        this.price = 0.00;
    }
    
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
        System.out.println("enginesize: " + this.enginesize + "cc");
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("price: £" + this.price);
        System.out.println("colour: " + this.colour);
        System.out.println();
    }
}
